package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.TownImportDto;
import mostwanted.domain.entities.Town;
import mostwanted.repository.TownRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TownServiceImpl implements TownService{

    private final static String TOWNS_JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/towns.json";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count()>0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return this.fileUtil.readFile(TOWNS_JSON_FILE_PATH);
    }

    @Override
    public String importTowns(String townsFileContent) {
        StringBuilder sb=new StringBuilder();

        TownImportDto[]townImportDtos=this.gson.fromJson(townsFileContent,TownImportDto[].class);

        for (TownImportDto townImportDto : townImportDtos) {

//            Town town=this.townRepository.findByName(townImportDto.getName());
//            if (town!=null){
//                sb.append("Duplicate");
//                continue;
//            }

            //If throw exception validate dto-TownImport

            Town town=this.modelMapper.map(townImportDto,Town.class);

            if (!this.validationUtil.isValid(town)){
                sb.append(Constants.DUPLICATE_DATA_MESSAGE).append(System.lineSeparator());

                continue;
            }
            this.townRepository.save(town);
            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Town",town.getName())).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportRacingTowns() {
        StringBuilder sb=new StringBuilder();
        List<Town> townList=this.townRepository.findAllByRacersIsNotNullOrderByRacersDesc();
        for (Town town : townList) {
            sb.append(String.format("Name: %s",town.getName())).append(System.lineSeparator());
            sb.append(String.format("Racers: %s",town.getRacers().size())).append(System.lineSeparator());
        }
        
        return sb.toString();
    }
}
