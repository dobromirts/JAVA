package softuni.cardealerxml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealerxml.domain.dtos.LocalSupplyerDto;
import softuni.cardealerxml.domain.dtos.SupplierSeedDto;
import softuni.cardealerxml.domain.entities.Supplier;
import softuni.cardealerxml.repositories.SupplierRepository;
import softuni.cardealerxml.services.SupplierService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private  ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers(SupplierSeedDto[] supplierSeedDtos) {
        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            Supplier supplier=modelMapper.map(supplierSeedDto,Supplier.class);
            this.supplierRepository.saveAndFlush(supplier);
        }

    }

    @Override
    public List<LocalSupplyerDto> getAllLocalSuppliers() {
        List<Supplier> suppliers=this.supplierRepository.findAllByImportedFalse();
        return suppliers.stream().map(s->this.modelMapper.map(s,LocalSupplyerDto.class)).collect(Collectors.toList());
    }
}
