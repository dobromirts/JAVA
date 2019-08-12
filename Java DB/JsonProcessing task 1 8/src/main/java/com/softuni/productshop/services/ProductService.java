package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.ProductInRangeDto;
import com.softuni.productshop.domain.dtos.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);
    List<ProductInRangeDto> productsInRange(BigDecimal more,BigDecimal less);
}
