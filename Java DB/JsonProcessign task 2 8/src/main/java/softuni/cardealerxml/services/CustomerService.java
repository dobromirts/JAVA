package softuni.cardealerxml.services;

import softuni.cardealerxml.domain.dtos.CustomerSeedDto;

public interface CustomerService {
    void seedCustomers(CustomerSeedDto[] customerSeedDtos);
}
