package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.QueriesDtos.CarMakeDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts.CarWithPartsDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.CarSeedDto;

import java.util.List;

public interface CarService {
    void seedCars(CarSeedDto[] carSeedDtos);

    List<CarMakeDto> getAllToyotaCarsOrderedByModelAndTravelDeistance();
    List<CarWithPartsDto>getAllCarsWithParts();
}
