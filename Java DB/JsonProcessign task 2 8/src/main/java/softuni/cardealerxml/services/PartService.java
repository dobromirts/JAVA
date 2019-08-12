package softuni.cardealerxml.services;

import softuni.cardealerxml.domain.dtos.PartSeedDto;

public interface PartService {
    void seedParts(PartSeedDto[] partSeedDto);
}
