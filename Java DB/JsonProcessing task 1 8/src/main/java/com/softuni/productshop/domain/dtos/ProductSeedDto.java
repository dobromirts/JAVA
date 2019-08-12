package com.softuni.productshop.domain.dtos;

import com.google.gson.annotations.Expose;



import com.softuni.productshop.domain.entities.Category;
import com.softuni.productshop.domain.entities.User;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class ProductSeedDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;



    public ProductSeedDto(){
    }

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name should be at least 3 symbols")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
