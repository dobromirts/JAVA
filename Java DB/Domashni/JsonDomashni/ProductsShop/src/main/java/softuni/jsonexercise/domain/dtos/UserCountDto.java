package softuni.jsonexercise.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class UserCountDto implements Serializable {
    @Expose
    private long userCount;
    @Expose
    private List<UserWithProductsDto> users;

    public UserCountDto() {
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }

    public List<UserWithProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithProductsDto> users) {
        this.users = users;
    }
}
