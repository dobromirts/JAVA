package softuni.cardealerxml.services;

import softuni.cardealerxml.domain.dtos.LocalSupplyerDto;
import softuni.cardealerxml.domain.dtos.SupplierSeedDto;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(SupplierSeedDto[] supplierSeedDtos);
    List<LocalSupplyerDto> getAllLocalSuppliers();
}
