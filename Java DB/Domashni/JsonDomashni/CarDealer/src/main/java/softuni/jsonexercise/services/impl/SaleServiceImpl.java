package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts.CarDto;
import softuni.jsonexercise.domain.dtos.QueriesDtos.SalesWithDiscounts.SaleDiscountDto;
import softuni.jsonexercise.domain.entities.Car;
import softuni.jsonexercise.domain.entities.Customer;
import softuni.jsonexercise.domain.entities.Discount;
import softuni.jsonexercise.domain.entities.Sale;
import softuni.jsonexercise.repositories.CarRepository;
import softuni.jsonexercise.repositories.CustomerRepository;
import softuni.jsonexercise.repositories.SaleRepository;
import softuni.jsonexercise.services.SaleService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        Random random = new Random();
        int salesNumber = 40 - random.nextInt(15);
        List<Car> cars = this.carRepository.findAll();
        List<Customer> customers = this.customerRepository.findAll();
        List<Discount> discounts = Arrays.asList(Discount.values());
        for (int i = 0; i < salesNumber; i++) {
            Sale sale = new Sale();
            Customer customer = customers.get(random.nextInt(customers.size() - 1) + 1);
            Car car = cars.get(random.nextInt(cars.size() - 1) + 1);
            Discount discountEnum = discounts.get(random.nextInt(discounts.size() - 1) + 1);
            double discount = discountEnum.getValue();
            if (customer.isYoungDriver()) {
                discount += 0.05;
            }
            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscount(discount);

            this.saleRepository.saveAndFlush(sale);
            cars.remove(car);
        }


    }

    @Override
    @Transactional
    public List<SaleDiscountDto> getAllSalesWithDiscounts() {
        List<SaleDiscountDto> saleDiscountDtos = new ArrayList<>();
        List<Sale> sales = this.saleRepository.findAll();
        for (Sale sale : sales) {
            SaleDiscountDto saleDiscountDto=new SaleDiscountDto();
            CarDto carDto=new CarDto();
            carDto.setMake(sale.getCar().getMake());
            carDto.setModel(sale.getCar().getModel());
            carDto.setTravelledDistance(sale.getCar().getTravelledDistance());
            saleDiscountDto.setCar(carDto);
            saleDiscountDto.setCustomerName(sale.getCustomer().getName());
            saleDiscountDto.setDiscount(sale.getDiscount());
            saleDiscountDto.setPrice(BigDecimal.valueOf(sale.getCar().getParts().stream().mapToDouble(p->p.getPrice().doubleValue()).sum()));
            saleDiscountDto.setPriceWithDiscount(saleDiscountDto.getPrice().multiply(BigDecimal.valueOf(1-saleDiscountDto.getDiscount())));
            saleDiscountDtos.add(saleDiscountDto);
        }
        return saleDiscountDtos;
    }
}
