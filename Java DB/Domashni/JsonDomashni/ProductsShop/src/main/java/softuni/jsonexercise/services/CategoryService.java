package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.CategoryByProductsCountDto;
import softuni.jsonexercise.domain.dtos.CategorySeedDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] categorySeedDtos);
    List<CategoryByProductsCountDto> getCategoryByProductCount();
}
