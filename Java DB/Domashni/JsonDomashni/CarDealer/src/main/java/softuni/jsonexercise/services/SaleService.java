package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.QueriesDtos.SalesWithDiscounts.SaleDiscountDto;

import java.util.List;

public interface SaleService {
    void seedSales();
    List<SaleDiscountDto>getAllSalesWithDiscounts();
}
