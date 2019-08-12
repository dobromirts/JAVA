package softuni.cardealerxml.services;

import softuni.cardealerxml.domain.dtos.CarSeedDto;
import softuni.cardealerxml.domain.dtos.CarWithModelDto;
import softuni.cardealerxml.domain.dtos.CarsWithPartsDto;

import java.util.List;

public interface CarService {
    void seedCars(CarSeedDto[]carSeedDtos);
    List<CarWithModelDto> getCarsFromMake();
    List<CarsWithPartsDto> getCarsWithParts();

}
