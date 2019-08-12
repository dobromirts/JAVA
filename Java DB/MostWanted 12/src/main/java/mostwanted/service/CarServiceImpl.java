package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.CarImportDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarServiceImpl implements CarService{

    private final static String CARS_JSON_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/files/cars.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;

    public CarServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson, CarRepository carRepository, RacerRepository racerRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
    }

    @Override
    public Boolean carsAreImported() {
        return this.carRepository.count()>0;
    }

    @Override
    public String readCarsJsonFile() throws IOException {
        return this.fileUtil.readFile(CARS_JSON_FILE_PATH);
    }

    @Override
    public String importCars(String carsFileContent) {
        StringBuilder sb=new StringBuilder();
        CarImportDto[]carImportDtos=this.gson.fromJson(carsFileContent,CarImportDto[].class);

        for (CarImportDto carImportDto : carImportDtos) {
            Car car=this.modelMapper.map(carImportDto,Car.class);

            if (!this.validationUtil.isValid(car)){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Racer racer=this.racerRepository.findByName(carImportDto.getRacerName());
            if (racer==null){
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            car.setRacer(racer);
            this.carRepository.saveAndFlush(car);
            sb.append(String.format("Successfully imported Car - %s %s @ %s.",car.getBrand(),car.getModel(),car.getYearOfProduction())).append(System.lineSeparator());
        }


        return sb.toString();
    }
}
