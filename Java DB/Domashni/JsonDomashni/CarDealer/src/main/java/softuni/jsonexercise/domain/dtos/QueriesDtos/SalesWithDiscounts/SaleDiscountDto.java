package softuni.jsonexercise.domain.dtos.QueriesDtos.SalesWithDiscounts;

import com.google.gson.annotations.Expose;
import softuni.jsonexercise.domain.dtos.QueriesDtos.CarsWithParts.CarDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleDiscountDto implements Serializable {
    @Expose
    private CarDto car;
    @Expose
    private String customerName;
    @Expose
    private double Discount;
    @Expose
    private BigDecimal price;
    @Expose
    private BigDecimal priceWithDiscount;

    public SaleDiscountDto() {
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
