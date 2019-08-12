package softuni.jsonexercise.domain.dtos.QueriesDtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CustomerTotalSaleDto {
    @Expose
    private String fullName;
    @Expose
    private int boughtCars;
    @Expose
    private double spentMoney;

    public CustomerTotalSaleDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public double getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(double spentMoney) {
        this.spentMoney = spentMoney;
    }
}
