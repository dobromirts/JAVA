package com.softuni.productshop.services.impl;

import com.softuni.productshop.domain.dtos.CategorySeedDto;
import com.softuni.productshop.domain.dtos.catogoriesWithProducts.CategoryByProductsDto;
import com.softuni.productshop.domain.entities.Category;
import com.softuni.productshop.domain.entities.Product;
import com.softuni.productshop.repositories.CategoryRepository;
import com.softuni.productshop.services.CategoryService;
import com.softuni.productshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;
    private ValidatorUtil validatorUtil;

    public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository, ValidatorUtil validatorUtil) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!this.validatorUtil.isValid(categorySeedDto)){
                this.validatorUtil.violations(categorySeedDto).forEach(v->System.out.println(v.getMessage()));
                continue;
            }
            Category category=modelMapper.map(categorySeedDto,Category.class);
            this.categoryRepository.saveAndFlush(category);
        }
    }

    @Override
    public List<CategoryByProductsDto> getCategoriesByProductCount() {
        return this.categoryRepository.findAllOrderByProductsCount()
                .stream()
                .filter(c -> c.getProducts().size() > 0)
                .map(c -> {
                    CategoryByProductsDto dto = this.modelMapper.map(c, CategoryByProductsDto.class);
                    dto.setCategory(c.getName());
                    dto.setProductCount(c.getProducts().size());

                    List<Product> products = c.getProducts();

                    BigDecimal totalPrice = products.stream()
                            .map(Product::getPrice)
                            .reduce(BigDecimal::add)
                            .orElse(BigDecimal.ZERO);

                    dto.setAveragePrice(totalPrice
                            .divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP));
                    dto.setTotalRevenue(totalPrice);

                    return dto;
                }).collect(Collectors.toList());
    }
}
