package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.UserSeedDto;
import com.softuni.productshop.domain.dtos.successfullySoldProducts.UserSellerDto;

import java.util.List;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);

    List<UserSellerDto> usersWithSoldProducts();
}
