package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.QueriesDtos.SupplierLocalDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.SupplierSeedDto;

import java.util.List;

public interface SupplierService {

    void seedSuppliers(SupplierSeedDto[]supplierSeedDtoList);

    List<SupplierLocalDto> getLocalSuppliers();

}
