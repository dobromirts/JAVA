package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.SeedDtos.PartSeedDto;

public interface PartService {
    void seedParts(PartSeedDto[] partSeedDtos);
}
