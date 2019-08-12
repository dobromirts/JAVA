package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.RacerImportDto;
import mostwanted.domain.dtos.raceentries.RaceEntryImportDto;
import mostwanted.domain.dtos.raceentries.RaceEntryImportRootDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final static String RACE_ENTRIES_XML_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/race-entries.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final RaceEntryRepository raceEntryRepository;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;

    public RaceEntryServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson, RaceEntryRepository raceEntryRepository, CarRepository carRepository, RacerRepository racerRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.raceEntryRepository = raceEntryRepository;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
    }

    @Override
    public Boolean raceEntriesAreImported() {
        return this.raceEntryRepository.count()>0;
    }

    @Override
    public String readRaceEntriesXmlFile() throws IOException {
        return fileUtil.readFile(RACE_ENTRIES_XML_FILE_PATH);
    }

    @Override
    public String importRaceEntries() throws JAXBException{
        StringBuilder sb=new StringBuilder();
        JAXBContext context=JAXBContext.newInstance(RaceEntryImportRootDto.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();

        RaceEntryImportRootDto raceEntryImportRootDto= (RaceEntryImportRootDto) unmarshaller.unmarshal(new File(RACE_ENTRIES_XML_FILE_PATH));

        for (RaceEntryImportDto raceEntryImportDto : raceEntryImportRootDto.getRaceEntryImportDto()) {
            RaceEntry raceEntry=this.modelMapper.map(raceEntryImportDto, RaceEntry.class);

            if (!this.validationUtil.isValid(raceEntry)){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Car car=this.carRepository.findById(raceEntryImportDto.getCarId()).orElse(null);
            if (car==null){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            raceEntry.setCar(car);

            Racer racer=this.racerRepository.findByName(raceEntryImportDto.getRacerName());
            if (racer==null){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            racer.getCars().add(car);
            this.racerRepository.saveAndFlush(racer);

            raceEntry.setRacer(racer);
            raceEntry.setRace(null);
            this.raceEntryRepository.saveAndFlush(raceEntry);
            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"RaceEntry",raceEntry.getId())).append(System.lineSeparator());

        }

        return sb.toString();
    }
}
