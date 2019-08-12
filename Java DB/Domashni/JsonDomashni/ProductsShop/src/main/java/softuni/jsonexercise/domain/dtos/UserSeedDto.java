package softuni.jsonexercise.domain.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserSeedDto implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;

    public UserSeedDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 3, message = "Last name should be at least 3 symbols.")  //for length
    @NotNull(message = "Last Name is obligatory field!")

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Min(value = 0,message = "Age cannot be negative number.")  // for number
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
