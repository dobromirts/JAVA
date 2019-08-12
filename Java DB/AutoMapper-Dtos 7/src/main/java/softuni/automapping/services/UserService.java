package softuni.automapping.services;

import softuni.automapping.domain.dtos.UserLogginDto;
import softuni.automapping.domain.dtos.UserRegisterDto;

public interface UserService {
    String registerUser(UserRegisterDto userDto);
    String loginUser(UserLogginDto userLogginDto);
    String logoutUser();
}
