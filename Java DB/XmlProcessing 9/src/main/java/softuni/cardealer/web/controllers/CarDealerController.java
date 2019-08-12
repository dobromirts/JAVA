package softuni.cardealer.web.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.cardealer.services.CarService;
import softuni.cardealer.services.CustomerService;
import softuni.cardealer.services.PartService;
import softuni.cardealer.services.SupplierService;


@Controller
public class
CarDealerController implements CommandLineRunner {
    private SupplierService supplierService;
    private PartService partService;
    private CarService carService;
    private CustomerService customerService;

    public CarDealerController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;

    }

    @Override
    public void run(String... args) throws Exception {
//        this.supplierService.seedSuppliers();
//        this.partService.seedParts();
//        this.carService.seedCars();
//        this.customerService.seedCustomers();


        /**Query 1
         *
         */
        this.customerService.exportCustomers();

        /**Query 2
         *
         */
        //this.carService.exportCars();

        /**Query 3
         *
         */
        //this.supplierService.exportSuppliers();

        /**Query 4
         *
         */
        this.carService.exportCarsWithParts();
    }


}
