package com.softuni.productshop.web.controllers;

import com.google.gson.Gson;
import com.softuni.productshop.domain.dtos.CategorySeedDto;
import com.softuni.productshop.domain.dtos.ProductInRangeDto;
import com.softuni.productshop.domain.dtos.ProductSeedDto;
import com.softuni.productshop.domain.dtos.UserSeedDto;
import com.softuni.productshop.services.CategoryService;
import com.softuni.productshop.services.ProductService;
import com.softuni.productshop.services.UserService;
import com.softuni.productshop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {
    private UserService userService;
    private FileUtil fileUtil;
    private Gson gson;
    private CategoryService categoryService;
    private ProductService productService;


    private static final String USER_JSON_FILE_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessing task 1 8\\src\\main\\resources\\users.json";
    private static final  String PRODUCT_JSON_FILE_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessing task 1 8\\src\\main\\resources\\products.json";
    private static final  String CATEGORY_JSON_FILE_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessing task 1 8\\src\\main\\resources\\categories.json";


    @Autowired
    public ProductShopController(UserService userService, FileUtil fileUtil, Gson gson, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @Override
    public void run(String... args) throws Exception {
        //this.seedUsers();
        //this.seedCategories();
        //this.seedProducts();
        //productsInRange();
        //this.soldProducts();
        this.categoriesByProductCount();

    }


    private void seedCategories() throws IOException {
        String content=this.fileUtil.fileContent(CATEGORY_JSON_FILE_PATH);
        CategorySeedDto[] categorySeedDtos=this.gson.fromJson(content,CategorySeedDto[].class);
        this.categoryService.seedCategories(categorySeedDtos);

    }

    private void seedProducts() throws IOException {
        String content=this.fileUtil.fileContent(PRODUCT_JSON_FILE_PATH);
        ProductSeedDto[]productSeedDtos=this.gson.fromJson(content,ProductSeedDto[].class);
        this.productService.seedProducts(productSeedDtos);
    }

    private void seedUsers() throws IOException {
        String content=this.fileUtil.fileContent(USER_JSON_FILE_PATH);

        System.out.println();
        UserSeedDto[]userSeedDtos=gson.fromJson(content,UserSeedDto[].class);
        this.userService.seedUsers(userSeedDtos);
    }
    /**
     * Query 1 - Products In Range
     */
    private void productsInRange() {
        List<ProductInRangeDto> productInRangeDtos=this.productService.productsInRange(BigDecimal.valueOf(500),
                BigDecimal.valueOf(1000));

        String productsInRangeJson=this.gson.toJson(productInRangeDtos);
        System.out.println(productsInRangeJson);
    }

    /**
     * Query 2 - Successfully Sold Products
     */

    public void soldProducts(){
        this.userService.usersWithSoldProducts().stream().map(u -> this.gson.toJson(u)).forEach(System.out::println);
    }

    /**
     * Query 3 - Categories By Products Count
     */
    public void categoriesByProductCount(){
        this.categoryService.getCategoriesByProductCount().stream().map(c -> this.gson.toJson(c))
                .forEach(System.out::println);
    }


}
