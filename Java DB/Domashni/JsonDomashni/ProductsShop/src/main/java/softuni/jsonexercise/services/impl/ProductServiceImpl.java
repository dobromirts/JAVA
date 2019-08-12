package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.ProductInRangeDto;
import softuni.jsonexercise.domain.dtos.ProductSeedDto;
import softuni.jsonexercise.domain.entities.Category;
import softuni.jsonexercise.domain.entities.Product;
import softuni.jsonexercise.domain.entities.User;
import softuni.jsonexercise.repositories.CategoryRepository;
import softuni.jsonexercise.repositories.ProductRepository;
import softuni.jsonexercise.repositories.UserRepository;
import softuni.jsonexercise.services.ProductService;
import softuni.jsonexercise.util.ValidatorUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
@Autowired
    public ProductServiceImpl(ValidatorUtil validatorUtil, ModelMapper modelMapper, ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        int count = 1;
        Random random = new Random();
        for (ProductSeedDto productSeedDto : productSeedDtos) {
            int i = random.nextInt(count);
            if (i % 3 != 0) {
                productSeedDto.setBuyer(this.getRandomUser());
            }
            count++;
            productSeedDto.setSeller(this.getRandomUser());
            productSeedDto.setCategories(this.getRandomCategories());

            if (!this.validatorUtil.isValid(productSeedDto)) {
                this.validatorUtil.violations(productSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }

            Product product = this.modelMapper.map(productSeedDto, Product.class);

            this.productRepository.saveAndFlush(product);
        }
    }

    @Override
    public List<ProductInRangeDto> findProductsInRange(BigDecimal minPrice, BigDecimal maxPrice) {

        List<Product> products = this.productRepository
                .findAllByPriceGreaterThanAndPriceLessThanAndBuyerIsNullOrderByPriceAsc(minPrice, maxPrice)
                .stream().collect(Collectors.toList());
        List<ProductInRangeDto> productInRangeDtos = new ArrayList<>();
        for (Product product : products) {
            ProductInRangeDto productInRangeDto = modelMapper.map(product, ProductInRangeDto.class);
            productInRangeDto.setSeller(product.getSeller().getFullName());
            productInRangeDtos.add(productInRangeDto);
        }
        return productInRangeDtos;
    }

    private User getRandomUser() {
        Random random = new Random();
        int id = random.nextInt((int) this.userRepository.count() - 1) + 1;
        return this.userRepository.getOne(id);
    }

    private Category getRandomCategory() {
        Random random = new Random();
        int id = random.nextInt((int) this.categoryRepository.count() - 1) + 1;
        return this.categoryRepository.findById(id).orElse(null);
    }

    private List<Category> getRandomCategories() {
        Random random = new Random();
        List<Category> categories = new ArrayList<>();
        int size = random.nextInt((int) this.categoryRepository.count() - 1) + 1;
        while (size-- > 0) {
            categories.add(this.getRandomCategory());
        }
        return categories;
    }
}

