package softuni.jsonexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexercise.domain.dtos.*;
import softuni.jsonexercise.domain.entities.Product;
import softuni.jsonexercise.domain.entities.User;
import softuni.jsonexercise.repositories.UserRepository;
import softuni.jsonexercise.services.UserService;
import softuni.jsonexercise.util.ValidatorUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

@Autowired
    public UserServiceImpl(ValidatorUtil validatorUtil, ModelMapper modelMapper, UserRepository userRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil.violations(userSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                continue;
            }
            User user = modelMapper.map(userSeedDto, User.class);
            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<UserWithSalesDto> getUsersWithSales() {
        List<User> users = this.userRepository.findAllWithProductsSold();
        List<UserWithSalesDto> usersWithSalesDtos = new ArrayList<>();
        for (User user : users) {
            UserWithSalesDto userWithSalesDto = modelMapper.map(user, UserWithSalesDto.class);
            usersWithSalesDtos.add(userWithSalesDto);

        }
        return usersWithSalesDtos;
    }

    //UserCountDto
    //UserWithProductsDto
    //SoldProductsDto
    //ProductDetailsDto

    @Override
    public UserCountDto getUsersAndProducts() {

        List<User> users = this.userRepository.usersWithProducts();

        UserCountDto userCountDto = new UserCountDto();
        userCountDto.setUserCount(users.size());
        List<UserWithProductsDto> usersWithProducts = new ArrayList<>();
        for (User user : users) {
            UserWithProductsDto userWithProductsDto = new UserWithProductsDto();
            userWithProductsDto.setFirstName(user.getFirstName());
            userWithProductsDto.setLastName(user.getLastName());
            userWithProductsDto.setAge(user.getAge());

            SoldProductsDto soldProductsDto = new SoldProductsDto();
            soldProductsDto.setCount(user.getSoldProducts().size());
            List<ProductDetailsDto> productDetailsDtoList = new ArrayList<>();
            for (Product soldProduct : user.getSoldProducts()) {
                ProductDetailsDto productDetailsDto = modelMapper.map(soldProduct, ProductDetailsDto.class);
                productDetailsDtoList.add(productDetailsDto);
            }

            soldProductsDto.setProductDetails(productDetailsDtoList);
            userWithProductsDto.setSoldProducts(soldProductsDto);
            usersWithProducts.add(userWithProductsDto);
        }
List<UserWithProductsDto>sortedUsersWithProducts=this.sortUsersByProductsSoldAndLAstName(usersWithProducts);
        userCountDto.setUsers(sortedUsersWithProducts);
        return  userCountDto;
    }
    public  List<UserWithProductsDto> sortUsersByProductsSoldAndLAstName ( List<UserWithProductsDto> usersWithProducts){

       return usersWithProducts.stream().sorted((u1, u2) -> {
            int result=Long.compare(u2.getSoldProducts().getCount(), u1.getSoldProducts().getCount());
            if (result != 0) {
                return result;
            } else {
                result=u1.getLastName().compareTo(u2.getLastName());
            }
            return result;
        }).collect(Collectors.toList());

    }
}
