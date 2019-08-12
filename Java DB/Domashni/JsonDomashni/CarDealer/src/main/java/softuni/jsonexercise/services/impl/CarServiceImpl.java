package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarMakeDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts.CarDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts.CarWithPartsDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts.PartDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.CarSeedDto;
import softuni.jsonexercise.domain.entities.Car;
import softuni.jsonexercise.domain.entities.Part;
import softuni.jsonexercise.repositories.CarRepository;
import softuni.jsonexercise.repositories.PartRepository;
import softuni.jsonexercise.services.CarService;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, PartRepository partRepository, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;

        this.carRepository = carRepository;
    }

    @Override
    public void seedCars(CarSeedDto[] carSeedDtos) {
        List<Part> partsInDB = this.partRepository.findAll();
        Random random = new Random();
        for (CarSeedDto carDto : carSeedDtos) {
            Car car = this.modelMapper.map(carDto, Car.class);
            Set<Part> parts = new HashSet<>();
            int numberOfParts = 20 - random.nextInt(10);
            for (int i = 0; i < numberOfParts; i++) {
                int index = random.nextInt((int) (this.partRepository.count() - 1)) + 1;

                Part part = partsInDB.get(index);
                parts.add(part);
            }
            car.setParts(parts);
            this.carRepository.saveAndFlush(car);
        }
    }

    @Override
    public List<CarMakeDto> getAllToyotaCarsOrderedByModelAndTravelDeistance() {

      return  this.carRepository.allToyotaCarsOrderedByModel("Toyota")
        .stream()
        .map(c->this.modelMapper.map(c,CarMakeDto.class))
        .collect(Collectors.toList());
            }

    @Override
    @Transactional
    public List<CarWithPartsDto> getAllCarsWithParts() {
        List<Car>cars=this.carRepository.findAll();
                List<CarWithPartsDto>carWithPartsDtos=new ArrayList<>();
        for (Car car : cars) {
            CarWithPartsDto carWithPartsDto=new CarWithPartsDto();
            CarDto carDto=this.modelMapper.map(car,CarDto.class);
            List<PartDto>partDtos=Arrays.asList(this.modelMapper.map(car.getParts(),PartDto[].class));

            carWithPartsDto.setCar(carDto);
            carWithPartsDto.setParts(partDtos);
            carWithPartsDtos.add(carWithPartsDto);
        }
              return carWithPartsDtos;
    }
}

