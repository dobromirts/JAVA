package softuni.jsonexercise.domain.dtos;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class UserWithSalesDto implements Serializable {
   @Expose
    private String firstName;
   @Expose
   private String lastName;
   @Expose
   private List<SoldProductDto> soldProducts;

    public UserWithSalesDto() {
    }

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

    public List<SoldProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
