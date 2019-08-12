package com.softuni.productshop.services.impl;

import com.softuni.productshop.domain.dtos.ProductInRangeDto;
import com.softuni.productshop.domain.dtos.ProductSeedDto;
import com.softuni.productshop.domain.entities.Category;
import com.softuni.productshop.domain.entities.Product;
import com.softuni.productshop.domain.entities.User;
import com.softuni.productshop.repositories.CategoryRepository;
import com.softuni.productshop.repositories.ProductRepository;
import com.softuni.productshop.repositories.UserRepository;
import com.softuni.productshop.services.ProductService;
import com.softuni.productshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        for (ProductSeedDto productSeedDto : productSeedDtos) {
            if (!this.validatorUtil.isValid(productSeedDto)){
                this.validatorUtil.violations(productSeedDto).forEach(v->System.out.println(v.getMessage()));
                continue;
            }
            Product product=modelMapper.map(productSeedDto,Product.class);
            product.setBuyer(this.getRandomBuyer());
            product.setSeller(this.getRandomSeller());
            product.setCategories(this.getRandomCategories());

            this.productRepository.saveAndFlush(product);
        }

    }

    private User getRandomBuyer(){
        Random random=new Random();
        int id=random.nextInt((int) (this.userRepository.count()-1))+1;
        if (id%3==0){
            return null;
        }
        return this.userRepository.getOne(id);
    }

    private User getRandomSeller(){
        Random random=new Random();
        int id=random.nextInt((int) (this.userRepository.count()-1))+1;
        return this.userRepository.getOne(id);
    }
    private Category getRandomCategory(){
        Random random=new Random();
        int id=random.nextInt((int) (this.categoryRepository.count()-1))+1;
        return this.categoryRepository.getOne(id);
    }

    private List<Category> getRandomCategories(){
        List<Category> categories=new ArrayList<>();
        Random random=new Random();

        int size=random.nextInt((int) (this.categoryRepository.count()-1))+1;
        for (int i = 0; i <size ; i++) {
            categories.add(this.getRandomCategory());
        }
        return categories;
    }

    @Override
    public List<ProductInRangeDto> productsInRange(BigDecimal more, BigDecimal less) {
        List<Product> products=this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(more,less);
        List<ProductInRangeDto>productInRangeDtos=new ArrayList<>();

        for (Product product : products) {
            ProductInRangeDto productInRangeDto=this.modelMapper.map(product,ProductInRangeDto.class);
            productInRangeDto.setSeller(String.format("%s %s",product.getSeller().getFirstName(),
                    product.getSeller().getLastName()));

            productInRangeDtos.add(productInRangeDto);
            
        }
        return productInRangeDtos;
    }
}
