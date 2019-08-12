package softuni.cardealerxml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealerxml.domain.dtos.CarSeedDto;
import softuni.cardealerxml.domain.dtos.CarWithModelDto;
import softuni.cardealerxml.domain.dtos.CarsWithPartsDto;
import softuni.cardealerxml.domain.dtos.PartsOfCarDto;
import softuni.cardealerxml.domain.entities.Car;
import softuni.cardealerxml.domain.entities.Part;
import softuni.cardealerxml.repositories.CarRepository;
import softuni.cardealerxml.repositories.PartRepository;
import softuni.cardealerxml.services.CarService;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;


    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void seedCars(CarSeedDto[] carSeedDtos) {
        for (CarSeedDto carSeedDto : carSeedDtos) {
            Car car=this.modelMapper.map(carSeedDto,Car.class);
            Set<Part>parts=new HashSet<>();
            for (int i = 0; i <12 ; i++) {
                parts.add(this.getRandomPart());
            }
            car.setParts(parts);
            this.carRepository.saveAndFlush(car);
        }
    }

    private Part getRandomPart(){
        Random random=new Random();
        int id=random.nextInt((int) (this.partRepository.count()-1))+1;
        Part part=this.partRepository.getOne(id);
        return part;
    }

    @Override
    public List<CarWithModelDto> getCarsFromMake() {
        List<Car> cars=this.carRepository.findAllByMakeOrderByModel("Toyota");
        List<CarWithModelDto>carWithModelDtos=cars.stream().map(c->this.modelMapper.map(c,CarWithModelDto.class)).collect(Collectors.toCollection(ArrayList::new));

        return carWithModelDtos;
    }
    @Transactional
    @Override
    public List<CarsWithPartsDto> getCarsWithParts() {
        List<Car>cars=this.carRepository.findAllCars();

        System.out.println();


        System.out.println();
        List<CarsWithPartsDto>carsWithPartsDtos=new ArrayList<>();

        for (Car car : cars) {
            List<PartsOfCarDto> partsOfCarDtos=car.getParts().stream().map(p->this.modelMapper.map(p,PartsOfCarDto.class)).collect(Collectors.toCollection(ArrayList::new));
            CarsWithPartsDto carsWithPartsDto=this.modelMapper.map(car,CarsWithPartsDto.class);
            carsWithPartsDtos.add(carsWithPartsDto);
        }

        return carsWithPartsDtos;
    }
}
