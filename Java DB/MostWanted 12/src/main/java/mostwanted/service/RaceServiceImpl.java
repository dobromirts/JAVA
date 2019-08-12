package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.races.EntryImportDto;
import mostwanted.domain.dtos.races.RaceImportDto;
import mostwanted.domain.dtos.races.RaceImportRootDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Race;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RaceRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class RaceServiceImpl implements RaceService {

    private final static String RACES_XML_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/races.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final RaceRepository raceRepository;
    private final RaceEntryRepository raceEntryRepository;
    private final DistrictRepository districtRepository;

    public RaceServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson, RaceRepository raceRepository, RaceEntryRepository raceEntryRepository, DistrictRepository districtRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.raceRepository = raceRepository;
        this.raceEntryRepository = raceEntryRepository;
        this.districtRepository = districtRepository;
    }


    @Override
    public Boolean racesAreImported() {
        return this.raceRepository.count()>0;
    }

    @Override
    public String readRacesXmlFile() throws IOException {
        return fileUtil.readFile(RACES_XML_FILE_PATH);
    }

    @Override
    public String importRaces() throws JAXBException {
        StringBuilder sb=new StringBuilder();
        JAXBContext context=JAXBContext.newInstance(RaceImportRootDto.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();

        RaceImportRootDto raceImportRootDto= (RaceImportRootDto) unmarshaller.unmarshal(new File(RACES_XML_FILE_PATH));

        for (RaceImportDto raceImportDto : raceImportRootDto.getRaceImportDtos()) {
            Race race=this.modelMapper.map(raceImportDto,Race.class);

            District district=this.districtRepository.findByName(raceImportDto.getDistrictName());
            if (district==null){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            race.setDistrict(district);

            if (!this.validationUtil.isValid(race)){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            for (EntryImportDto  entryImportDto : raceImportDto.getEntryImportRootDto().getEntryImportDtoList()) {
                RaceEntry raceEntry=this.raceEntryRepository.findById(entryImportDto.getId()).orElse(null);

                if (raceEntry==null){
                    sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    continue;
                }
                raceEntry.setRace(race);



                race.getRaceEntries().add(raceEntry);

            }

            this.raceRepository.saveAndFlush(race);
            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Race",race.getId())).append(System.lineSeparator());
        }


        return sb.toString();
    }
}