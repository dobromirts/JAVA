package softuni.cardealerxml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealerxml.domain.dtos.CustomerSeedDto;
import softuni.cardealerxml.domain.entities.Customer;
import softuni.cardealerxml.repositories.CustomerRepository;
import softuni.cardealerxml.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers(CustomerSeedDto[] customerSeedDtos) {
        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            Customer customer=this.modelMapper.map(customerSeedDto,Customer.class);
            this.customerRepository.saveAndFlush(customer);
        }

    }
}
