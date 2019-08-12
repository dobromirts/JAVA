package softuni.jsonexercise.services;

import softuni.jsonexercise.domain.dtos.UserSeedDto;
import softuni.jsonexercise.domain.dtos.UserCountDto;
import softuni.jsonexercise.domain.dtos.UserWithSalesDto;

import java.util.List;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos );

    List<UserWithSalesDto> getUsersWithSales();

    UserCountDto getUsersAndProducts();
}
