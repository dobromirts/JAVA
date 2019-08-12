package com.softuni.productshop.domain.dtos.successfullySoldProducts;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserSellerDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductWithBuyerDto> soldProducts;

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductWithBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductWithBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}