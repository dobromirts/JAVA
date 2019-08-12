package com.softuni.productshop.services.impl;

import com.softuni.productshop.domain.dtos.UserSeedDto;
import com.softuni.productshop.domain.dtos.successfullySoldProducts.ProductWithBuyerDto;
import com.softuni.productshop.domain.dtos.successfullySoldProducts.UserSellerDto;
import com.softuni.productshop.domain.entities.User;
import com.softuni.productshop.repositories.UserRepository;
import com.softuni.productshop.services.UserService;
import com.softuni.productshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ValidatorUtil validatorUtil;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(ValidatorUtil validatorUtil, UserRepository userRepository, ModelMapper modelMapper) {
        this.validatorUtil = validatorUtil;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil.violations(userSeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));
                continue;
            }
            User user=modelMapper.map(userSeedDto,User.class);
            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<UserSellerDto> usersWithSoldProducts() {
        List<User> byProductsToSellIsNotNull = this.userRepository.findByProductsToSellIsNotEmpty();

        List<User> collect = byProductsToSellIsNotNull.stream()
                .filter(u -> u.getProductsToSell().stream().anyMatch(p -> p.getBuyer() != null)).collect(Collectors.toList());

        return collect.stream()
                .map(u -> {
                    UserSellerDto userSellerDto = this.modelMapper.map(u, UserSellerDto.class);
                    List<ProductWithBuyerDto> productWithBuyerDtos = u.getProductsToSell().stream()
                            .filter(p -> p.getBuyer() != null)
                            .map(p -> this.modelMapper.map(p, ProductWithBuyerDto.class)).collect(Collectors.toList());
                    userSellerDto.setSoldProducts(productWithBuyerDtos);
                    return userSellerDto;
                })
                .collect(Collectors.toList());
    }
}
