package softuni.jsonexercise.web.controllers;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarMakeDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CustomerOrderDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.CarSeedDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.CustomerSeedDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.PartSeedDto;
import softuni.jsonexercise.domain.dtos.SeedDtos.SupplierSeedDto;
import softuni.jsonexercise.services.*;
import softuni.jsonexercise.util.FileUtil;

import java.io.IOException;
import java.util.List;

@Controller
public class CarDealerController implements CommandLineRunner {

    private static final String PATH_SUPPLIERS_JSON = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\CarDealer\\src\\main\\resources\\jsonFiles\\suppliers.json";
    private static final String PATH_PARTS_JSON = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\CarDealer\\src\\main\\resources\\jsonFiles\\parts.json";
    private static final String PATH_CARS_JSON = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\CarDealer\\src\\main\\resources\\jsonFiles\\cars.json";
    private static final String PATH_CUSTOMERS_JSON = "C:\\Users\\anato\\OneDrive\\Documents\\SOFTUNI\\Java\\Hibernate\\Lab8-EXERCISE8-JSON\\CarDealer\\src\\main\\resources\\jsonFiles\\customers.json";

    private final Gson gson;
    private FileUtil fileUtil;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public CarDealerController(Gson gson, FileUtil fileUtil, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }


    @Override
    public void run(String... args) throws Exception {

       //this.seedSuppliers();
       //this.seedParts();
       //this.seedCars();
       //this.seedCustomers();
       //this.seedSales();

//Queries:
        this.orderCustomers();
        // this.getCarsToyotaMake();
        // this.getLocalSuppliers();
        //this.getAllCarsWithParts();
        //this.getCustomersWithTotalSales();
        //this.getSalesWithAppliedDiscounts();
    }




    private void seedSuppliers() throws IOException {
        String content = this.fileUtil.fileContent(PATH_SUPPLIERS_JSON);
        SupplierSeedDto[] supplierSeedDtoList = this.gson.fromJson(content, SupplierSeedDto[].class);
        this.supplierService.seedSuppliers(supplierSeedDtoList);
    }

    private void seedParts() throws IOException {
        String content = this.fileUtil.fileContent(PATH_PARTS_JSON);
        PartSeedDto[] partSeedDtos = this.gson.fromJson(content, PartSeedDto[].class);
        this.partService.seedParts(partSeedDtos);
    }

    private void seedCars() throws IOException {
        String content = this.fileUtil.fileContent(PATH_CARS_JSON);
        CarSeedDto[] carSeedDtos = this.gson.fromJson(content, CarSeedDto[].class);
        this.carService.seedCars(carSeedDtos);
    }

    private void seedCustomers() throws IOException {
        String content = this.fileUtil.fileContent(PATH_CUSTOMERS_JSON);


        CustomerSeedDto[] customerSeedDtos = this.gson.fromJson(content, CustomerSeedDto[].class);
        this.customerService.seedCustomers(customerSeedDtos);
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void orderCustomers() {

        List<CustomerOrderDto> customerOrderDtoList = this.customerService.orderCustomers();
        String content = this.gson.toJson(customerOrderDtoList);
        System.out.println(content);
    }

    private void getCarsToyotaMake() {
        List<CarMakeDto> carMakeDtos = this.carService.getAllToyotaCarsOrderedByModelAndTravelDeistance();
        String context = this.gson.toJson(carMakeDtos);
        System.out.println(context);
    }

    private void getLocalSuppliers() {
        String content = this.gson.toJson(this.supplierService.getLocalSuppliers());
        System.out.println(content);
    }

    private void getAllCarsWithParts() {
        String context = this.gson.toJson(this.carService.getAllCarsWithParts());
        System.out.println(context);
    }

    private void getCustomersWithTotalSales() {
        String context = this.gson.toJson(this.customerService.getTotalSalesPerCustomers());
        System.out.println(context);
    }

    private void getSalesWithAppliedDiscounts() {
        String context=this.gson.toJson(this.saleService.getAllSalesWithDiscounts());
        System.out.println(context);
    }
}
