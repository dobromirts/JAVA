package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.SeedDtos.PartSeedDto;
import softuni.jsonexercise.domain.entities.Part;
import softuni.jsonexercise.repositories.PartRepository;
import softuni.jsonexercise.repositories.SupplierRepository;
import softuni.jsonexercise.services.PartService;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
@Autowired
    public PartServiceImpl(ModelMapper modelMapper, SupplierRepository supplierRepository, PartRepository partRepository) {
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
    }

    @Override
    public void seedParts(PartSeedDto[] partSeedDtos) {

        Random random = new Random();
        for (PartSeedDto partDto : partSeedDtos) {
            int index = random.nextInt((int) (this.supplierRepository.count() - 1)) + 1;
            Part part = this.modelMapper.map(partDto, Part.class);
            part.setSupplier(this.supplierRepository.getOne(index));
            this.partRepository.saveAndFlush(part);
        }
    }
}
