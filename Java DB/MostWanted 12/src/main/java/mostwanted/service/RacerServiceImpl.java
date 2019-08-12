package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.RacerImportDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.Racer;
import mostwanted.domain.entities.Town;
import mostwanted.repository.RacerRepository;
import mostwanted.repository.TownRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RacerServiceImpl implements RacerService {

    private final static String RACERS_JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/racers.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final RacerRepository racerRepository;
    private final TownRepository townRepository;

    public RacerServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson, RacerRepository racerRepository, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.racerRepository = racerRepository;
        this.townRepository = townRepository;
    }

    @Override
    public Boolean racersAreImported() {
        return this.racerRepository.count()>0;
    }

    @Override
    public String readRacersJsonFile() throws IOException {
        return this.fileUtil.readFile(RACERS_JSON_FILE_PATH);
    }

    @Override
    public String importRacers(String racersFileContent) {
        StringBuilder sb=new StringBuilder();
        RacerImportDto[]racerImportDtos=this.gson.fromJson(racersFileContent, RacerImportDto[].class);

        for (RacerImportDto racerImportDto : racerImportDtos) {
            Racer racer=this.modelMapper.map(racerImportDto,Racer.class);

            if (!this.validationUtil.isValid(racer)){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            if (this.racerRepository.findByName(racerImportDto.getName())!=null){
                sb.append(Constants.DUPLICATE_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Town town=this.townRepository.findByName(racerImportDto.getHomeTown());
            if (town==null){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            racer.setHomeTown(town);
            this.racerRepository.saveAndFlush(racer);
            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Racer",racer.getName())).append(System.lineSeparator());

        }

        return sb.toString();
    }

    @Override
    public String exportRacingCars() {
        StringBuilder sb=new StringBuilder();

        List<Racer> racerList=this.racerRepository.findAllByNumberOfCars();
        for (Racer racer : racerList) {
            sb.append(String.format("Name: %s",racer.getName())).append(System.lineSeparator());
            sb.append("Cars:").append(System.lineSeparator());
            for (Car car : racer.getCars()) {
                sb.append(String.format("%s %s %s",car.getBrand(),car.getModel(),car.getYearOfProduction())).append(System.lineSeparator());
            }
            sb.append(System.lineSeparator());
        }


        return sb.toString();
    }
}
