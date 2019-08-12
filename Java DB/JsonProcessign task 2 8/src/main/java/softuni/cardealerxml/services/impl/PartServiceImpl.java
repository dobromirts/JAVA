package softuni.cardealerxml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealerxml.domain.dtos.PartSeedDto;
import softuni.cardealerxml.domain.entities.Part;
import softuni.cardealerxml.domain.entities.Supplier;
import softuni.cardealerxml.repositories.PartRepository;
import softuni.cardealerxml.repositories.SupplierRepository;
import softuni.cardealerxml.services.PartService;

import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, SupplierRepository supplierRepository) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedParts(PartSeedDto[] partSeedDto) {
        for (PartSeedDto seedDto : partSeedDto) {
            Part part=this.modelMapper.map(seedDto,Part.class);
            part.setSupplier(this.getRandomSupplier());
            this.partRepository.saveAndFlush(part);
        }
    }

    private Supplier getRandomSupplier(){
        Random random=new Random();
        int id=random.nextInt((int) (this.supplierRepository.count()-1))+1;
        Supplier supplier=this.supplierRepository.getOne(id);
        return supplier;
    }
}
