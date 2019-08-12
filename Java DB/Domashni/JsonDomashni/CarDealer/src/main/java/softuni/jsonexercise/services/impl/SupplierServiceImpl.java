package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.QueriesDtos.SupplierLocalDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.SupplierSeedDto;
import softuni.jsonexercise.domain.entities.Supplier;
import softuni.jsonexercise.repositories.SupplierRepository;
import softuni.jsonexercise.services.SupplierService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final ModelMapper modelMapper;
    private SupplierRepository supplierRepository;
@Autowired
public SupplierServiceImpl(ModelMapper modelMapper, SupplierRepository supplierRepository) {
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedSuppliers(SupplierSeedDto[] supplierSeedDtoList) {
        for (SupplierSeedDto supplierDto : supplierSeedDtoList) {
            Supplier supplier=this.modelMapper.map(supplierDto,Supplier.class);
           this.supplierRepository.saveAndFlush(supplier);
        }
    }

    @Override
    public List<SupplierLocalDto> getLocalSuppliers() {
List<Supplier>localSuppliers=this.supplierRepository.getLocalSuppliersInfo();
List<SupplierLocalDto>localSuppliersDtos=new ArrayList<>();
        for (Supplier localSupplier : localSuppliers) {
          SupplierLocalDto supplierLocalDto=new SupplierLocalDto();
         supplierLocalDto.setId(localSupplier.getId());
          supplierLocalDto.setName(localSupplier.getName());
          supplierLocalDto.setPartsCount(localSupplier.getParts().size());
            localSuppliersDtos.add(supplierLocalDto);
        }
return localSuppliersDtos;

    }
}
