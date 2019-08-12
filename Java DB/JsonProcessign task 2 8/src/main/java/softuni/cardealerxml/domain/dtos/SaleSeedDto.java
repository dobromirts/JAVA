package softuni.cardealerxml.domain.dtos;

import com.google.gson.annotations.Expose;
import softuni.cardealerxml.domain.entities.Car;
import softuni.cardealerxml.domain.entities.Customer;

public class SaleSeedDto {
    @Expose
    private Car car;
    @Expose
    private Customer customer;
    @Expose
    private Double discountPercentage;

    public SaleSeedDto() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
