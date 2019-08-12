package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.CategoryByProductsCountDto;
import softuni.jsonexercise.domain.dtos.CategorySeedDto;
import softuni.jsonexercise.domain.entities.Category;
import softuni.jsonexercise.repositories.CategoryRepository;
import softuni.jsonexercise.services.CategoryService;
import softuni.jsonexercise.util.ValidatorUtil;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
@Autowired
    public CategoryServiceImpl(ValidatorUtil validatorUtil, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!this.validatorUtil.isValid(categorySeedDto)) {
                this.validatorUtil.violations(categorySeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }
            Category category = this.modelMapper.map(categorySeedDto, Category.class);
            this.categoryRepository.saveAndFlush(category);
        }
    }

    @Override
    public List<CategoryByProductsCountDto> getCategoryByProductCount() {
        List<Object[]> categories = this.categoryRepository.categoryByProductCount();

        List<CategoryByProductsCountDto> categoryByProductsCountDtos = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            Object[] category = categories.get(i);
            String name = (String) category[0];
            Long productsCount = (Long) category[1];
            BigDecimal revenue = new BigDecimal( category[2].toString());
            BigDecimal averagePrice = revenue.divide(new BigDecimal( productsCount),6,RoundingMode.CEILING);
            CategoryByProductsCountDto categoryDto = new CategoryByProductsCountDto();
            categoryDto.setCategory(name);
            categoryDto.setAveragePrice(averagePrice);
            categoryDto.setProductsCount(productsCount);
            categoryDto.setTotalRevenue(revenue);

            categoryByProductsCountDtos.add(categoryDto);
        }
       return categoryByProductsCountDtos
               .stream()
               .sorted((c1,c2)->c2.getProductsCount().compareTo(c1.getProductsCount())).collect(Collectors.toList());
    }

}

