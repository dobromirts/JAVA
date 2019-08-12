package softuni.cardealerxml.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealerxml.domain.entities.Car;
import softuni.cardealerxml.domain.entities.Customer;
import softuni.cardealerxml.domain.entities.Sale;
import softuni.cardealerxml.repositories.CarRepository;
import softuni.cardealerxml.repositories.CustomerRepository;
import softuni.cardealerxml.repositories.SaleRepository;
import softuni.cardealerxml.services.SaleService;

import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        Random random=new Random();
        for (int i = 0; i <this.customerRepository.count() ; i++) {
            int carId=random.nextInt((int) (this.carRepository.count()-1))+1;
            int customerId=random.nextInt((int) (this.customerRepository.count()-1))+1;

            Car car=this.carRepository.getOne(carId);
            Customer customer=this.customerRepository.getOne(customerId);

            Sale sale=new Sale();
            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscountPercentage("10%");

            this.saleRepository.saveAndFlush(sale);
        }

    }
}
