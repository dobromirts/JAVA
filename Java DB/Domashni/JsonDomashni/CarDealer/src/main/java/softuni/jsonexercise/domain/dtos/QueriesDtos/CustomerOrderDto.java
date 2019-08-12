package softuni.jsonexercise.domain.dtos.QueriesDtos;

import com.google.gson.annotations.Expose;
import softuni.jsonexercise.domain.entities.Sale;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class CustomerOrderDto implements Serializable {
   @Expose
    private int Id;
    @Expose
    private String Name;
    @Expose
    private Date BirthDate;
    @Expose
    private boolean IsYoungDriver;
    @Expose
    private Set<Sale> Sales;

    public CustomerOrderDto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return IsYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        IsYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return Sales;
    }

    public void setSales(Set<Sale> sales) {
        Sales = sales;
    }
}
