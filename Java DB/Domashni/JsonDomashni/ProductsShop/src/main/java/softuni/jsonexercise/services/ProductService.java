package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.ProductInRangeDto;
import softuni.jsonexercise.domain.dtos.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductInRangeDto> findProductsInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
