package alararestaurant.domain.dtos.jsonDtos;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ItemImportDto {
    @Expose
    private String name;

    @Expose
    private String category;

    @Expose
    private BigDecimal price;

    public ItemImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
