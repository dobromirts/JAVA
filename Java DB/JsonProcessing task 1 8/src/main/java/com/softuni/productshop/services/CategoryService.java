package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.CategorySeedDto;
import com.softuni.productshop.domain.dtos.catogoriesWithProducts.CategoryByProductsDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[]categorySeedDtos);
    List<CategoryByProductsDto> getCategoriesByProductCount();
}
