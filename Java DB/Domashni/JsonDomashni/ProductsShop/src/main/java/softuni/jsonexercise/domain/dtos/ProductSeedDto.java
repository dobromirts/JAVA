package softuni.jsonexercise.domain.dtos;

import com.google.gson.annotations.Expose;
import softuni.jsonexercise.domain.entities.Category;
import softuni.jsonexercise.domain.entities.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ProductSeedDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private User buyer;
    @Expose
    private User seller;
    @Expose
    private List<Category> categories;

    public ProductSeedDto() {
    }

    @NotNull(message = "Product name cannot be null.")
    @Size(min = 3, message = "Product name should be at least 3 symbols!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Price cannot be null.")
    @Min(value = 0, message = "Price cannot be negative number.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @NotNull(message = "Seller cannot be null")
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @NotNull(message = "Product should have at least one category.")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
