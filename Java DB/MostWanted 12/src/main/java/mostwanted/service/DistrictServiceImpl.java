package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.DistrictImportDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Town;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.TownRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
@Transactional
@Service
public class DistrictServiceImpl implements DistrictService{
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final DistrictRepository districtRepository;
    private final TownRepository townRepository;

    private final static String DISTRICT_JSON_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/files/districts.json";

    public DistrictServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson, DistrictRepository districtRepository, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.districtRepository = districtRepository;
        this.townRepository = townRepository;
    }


    @Override
    public Boolean districtsAreImported() {
        return this.districtRepository.count()>0;
    }

    @Override
    public String readDistrictsJsonFile() throws IOException {
        return this.fileUtil.readFile(DISTRICT_JSON_FILE_PATH);
    }

    @Override
    public String importDistricts(String districtsFileContent) {
        StringBuilder sb=new StringBuilder();

        DistrictImportDto[]districtImportDtos=this.gson.fromJson(districtsFileContent,DistrictImportDto[].class);

        for (DistrictImportDto districtImportDto : districtImportDtos) {
            District district=this.modelMapper.map(districtImportDto,District.class);

            if (!this.validationUtil.isValid(district)){
                sb.append(Constants.INCORRECT_DATA_MESSAGE  ).append(System.lineSeparator());

                continue;
            }

            if (this.districtRepository.findByName(districtImportDto.getName())!=null){
                sb.append(Constants.DUPLICATE_DATA_MESSAGE).append(System.lineSeparator());

                continue;
            }
            Town town=this.townRepository.findByName(districtImportDto.getTownName());
            if (town==null){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            district.setTown(town);


            this.districtRepository.save(district);
            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"District",district.getName())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
