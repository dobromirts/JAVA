package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CustomerTotalSaleDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CustomerOrderDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.CustomerSeedDto;
import softuni.jsonexercise.domain.entities.Customer;
import softuni.jsonexercise.repositories.CustomerRepository;
import softuni.jsonexercise.services.CustomerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedCustomers(CustomerSeedDto[] customerSeedDtos) {
        for (CustomerSeedDto customerDto : customerSeedDtos) {
            Customer customer = this.modelMapper.map(customerDto, Customer.class);

            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public List<CustomerOrderDto> orderCustomers() {
        return this.customerRepository.orderCustomersByBirthDateAndYoungDriver()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerOrderDto.class))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<CustomerTotalSaleDto> getTotalSalesPerCustomers() {
        List<Customer> customers = this.customerRepository.AllCustomersWithSales();
        List<CustomerTotalSaleDto> customerTotalSaleDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerTotalSaleDto customerTotalSaleDto = new CustomerTotalSaleDto();
            customerTotalSaleDto.setFullName(customer.getName());
            customerTotalSaleDto.setBoughtCars(customer.getSales().size());
            customerTotalSaleDto.setSpentMoney(customer.getSales().stream()
                    .mapToDouble(s -> s.getCar()
                            .getParts().stream().mapToDouble(p -> p.getPrice().doubleValue())
                            .sum() * (1 - s.getDiscount())).sum());

            customerTotalSaleDtos.add(customerTotalSaleDto);
        }
        return customerTotalSaleDtos
                .stream()
                .sorted(Comparator.comparing(CustomerTotalSaleDto::getSpentMoney, Comparator.reverseOrder())
                        .thenComparing(CustomerTotalSaleDto::getBoughtCars, Comparator.reverseOrder()))
                .collect(Collectors.toList());

    }


}
