package softuni.jsonexercise.web.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.jsonexercise.domain.dtos.*;
import softuni.jsonexercise.services.CategoryService;
import softuni.jsonexercise.services.ProductService;
import softuni.jsonexercise.services.UserService;
import softuni.jsonexercise.util.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Controller
public class ProductsShopController implements CommandLineRunner {
    private final static String PATH_JSON_USERS = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\ProductsShop\\src\\main\\resources\\json_files\\users.json";
    private final static String PATH_JSON_CATEGORIES = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\ProductsShop\\src\\main\\resources\\json_files\\categories.json";
    private final static String PATH_JSON_PRODUCTS = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\ProductsShop\\src\\main\\resources\\json_files\\products.json";
    private final Gson gson;
    private FileUtil fileUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductsShopController(Gson gson, FileUtil fileUtil, UserService userService, CategoryService categoryService, ProductService productService) {
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
       // -->До проверяващия: Колега, много ще се радвам ако успееш да напълниш таблицата
        // users_friends и в коментарите на домашното копираш какви промени си направил.
        // 3 дена се блъсках, но нищо не стана.

        //this.seedUsers();
        //this.seedCategories();
        //this.seedProducts();

     //Queries:
       // this.productsInRange();
        this.usersWithProductsSold();
        //this.categoryByProductsCount();
        //this.getUsersAndProducts();
    }


    private void seedUsers() throws IOException {

        String content = this.fileUtil.fileContent(PATH_JSON_USERS);
        UserSeedDto[] userSeedDtos = this.gson.fromJson(content, UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException {
        String content = this.fileUtil.fileContent(PATH_JSON_CATEGORIES);
        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(content, CategorySeedDto[].class);
        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProducts() throws IOException {
        String content = this.fileUtil.fileContent(PATH_JSON_PRODUCTS);
        ProductSeedDto[] productSeedDtos = this.gson.fromJson(content, ProductSeedDto[].class);
        this.productService.seedProducts(productSeedDtos);
    }

    private void productsInRange() {
        Scanner sc = new Scanner(System.in);
        BigDecimal minPrice = new BigDecimal(sc.nextLine());
        BigDecimal maxPrice = new BigDecimal(sc.nextLine());
        List<ProductInRangeDto> productInRangeDtos = this.productService.findProductsInRange(minPrice, maxPrice);
        String productsInRangeJSON = this.gson.toJson(productInRangeDtos);
        System.out.println(productsInRangeJSON);
    }

    private void usersWithProductsSold() {
        List<UserWithSalesDto> users = this.userService.getUsersWithSales();
        String content = gson.toJson(users);
        System.out.println(content);
    }

    private void categoryByProductsCount() {
        List<CategoryByProductsCountDto> categories = this.categoryService.getCategoryByProductCount();
        String content = gson.toJson(categories);
        System.out.println(content);
    }

    private void getUsersAndProducts() {
        UserCountDto userCountDto = this.userService.getUsersAndProducts();
        String content = gson.toJson(userCountDto);
        System.out.println(content);
    }
}
