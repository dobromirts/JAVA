package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.QueriesDtos.CustomerTotalSaleDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CustomerOrderDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.SalesWithDiscounts.SaleDiscountDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.CustomerSeedDto;

import java.util.List;

public interface CustomerService {
    void seedCustomers(CustomerSeedDto[] customerSeedDtos);

    List<CustomerOrderDto> orderCustomers();
    List<CustomerTotalSaleDto>getTotalSalesPerCustomers();


}
