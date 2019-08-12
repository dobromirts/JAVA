package softuni.cardealerxml.web.controllers;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.cardealerxml.domain.dtos.CarSeedDto;
import softuni.cardealerxml.domain.dtos.CustomerSeedDto;
import softuni.cardealerxml.domain.dtos.PartSeedDto;
import softuni.cardealerxml.domain.dtos.SupplierSeedDto;
import softuni.cardealerxml.services.*;
import softuni.cardealerxml.uti.FileUtil;

import java.io.IOException;


@Controller
public class CarDealerController implements CommandLineRunner {
    private static final String SUPPLIERS_JSON_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessign task 2 8\\src\\main\\resources\\suppliers.json";
    private static final String PART_JSON_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessign task 2 8\\src\\main\\resources\\parts.json";
    private static final  String CAR_JSON_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessign task 2 8\\src\\main\\resources\\cars.json";
    private static final String CUSTOMER_JSON_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\JsonProcessign task 2 8\\src\\main\\resources\\customers.json";


    private SupplierService supplierService;
    private PartService partService;
    private CarService carService;
    private CustomerService customerService;
    private SaleService saleService;
    private Gson gson;
    private FileUtil fileUtil;

    public CarDealerController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, Gson gson, FileUtil fileUtil) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
        this.fileUtil = fileUtil;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedSuppliers();
//        this.seedProducts();
//        this.seedCars();
//        this.seedCustomers();
//        this.seedSales();


        /**
         *  Query 2 - Cars from make toyota
         */
        //this.carsFromMakeToyota();

        /**
         *  Query 3- Local suppliers
         */
        //this.localSuppliers();

        /**
         *  Query 4- Cars with their list of parts
         */
        this.carsWithTheirListOfParts();

    }

    private void carsWithTheirListOfParts() {
        System.out.println(this.gson.toJson(this.carService.getCarsWithParts()));
    }

    private void localSuppliers() {
        System.out.println(this.gson.toJson(this.supplierService.getAllLocalSuppliers()));
    }

    private void carsFromMakeToyota() {

        System.out.println(this.gson.toJson(this.carService.getCarsFromMake()));
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void seedCustomers() throws IOException {
        String content=this.fileUtil.getContent(CUSTOMER_JSON_PATH);
        CustomerSeedDto[]customerSeedDtos=this.gson.fromJson(content,CustomerSeedDto[].class);
        this.customerService.seedCustomers(customerSeedDtos);
    }

    private void seedCars() throws IOException {
        String contetn=this.fileUtil.getContent(CAR_JSON_PATH);
        CarSeedDto[]carSeedDtos=this.gson.fromJson(contetn,CarSeedDto[].class);
        this.carService.seedCars(carSeedDtos);
    }

    private void seedProducts() throws IOException {
        String content=this.fileUtil.getContent(PART_JSON_PATH);
        PartSeedDto[]partSeedDtos=this.gson.fromJson(content,PartSeedDto[].class);
        this.partService.seedParts(partSeedDtos);
    }

    private void seedSuppliers() throws IOException {
        String content=this.fileUtil.getContent(SUPPLIERS_JSON_PATH);
        SupplierSeedDto[]supplierSeedDtos=this.gson.fromJson(content,SupplierSeedDto[].class);
        this.supplierService.seedSuppliers(supplierSeedDtos);
    }
}
