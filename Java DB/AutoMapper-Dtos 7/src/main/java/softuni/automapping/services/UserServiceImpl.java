package softuni.automapping.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.automapping.domain.dtos.UserLogginDto;
import softuni.automapping.domain.dtos.UserRegisterDto;
import softuni.automapping.domain.entities.Role;
import softuni.automapping.domain.entities.User;
import softuni.automapping.repositories.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private ModelMapper modelMapper;
    private String logedInUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper=new ModelMapper();
        this.logedInUser="";
    }

    @Override
    public String registerUser(UserRegisterDto userDto) {
        StringBuilder sb=new StringBuilder();

        if (this.userRepository.findByEmail(userDto.getEmail()).size()!=0){
            return sb.append("User already exists").toString();
        }

        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();

        User user=modelMapper.map(userDto,User.class);

        Set<ConstraintViolation<User>>violations=validator.validate(user);

        if (violations.size()==0){
            sb.append(String.format("%s was registered",user.getFullName()));
            this.userRepository.saveAndFlush(user);
        }else {
            if (this.userRepository.count()==0){
                user.setRole(Role.ADMIN);
            }else {
                user.setRole(Role.USER);
            }

            for (ConstraintViolation<User> violation : violations) {
                sb.append(violation.getMessage());
            }
        }

        return sb.toString();
    }

    @Override
    public String loginUser(UserLogginDto userLogginDto) {
        StringBuilder sb=new StringBuilder();

        if (!this.logedInUser.isEmpty()){
            return sb.append("User is already logged in").toString();
        }

        User user= (User) this.userRepository.findByEmail(userLogginDto.getEmail());

        if (this.userRepository.findByEmail(userLogginDto.getEmail()).size()==0){
            sb.append("No such user");
        }else {

            if (user.getEmail().equals(userLogginDto.getEmail())|| user.getPassword().equals(userLogginDto.getPassword())){
                sb.append("Incorrect username/password");
            }else {
                this.logedInUser=user.getEmail();
                sb.append(String.format("User %s successfully logged in",user.getFullName()));
            }
        }
        return sb.toString();
    }

    @Override
    public String logoutUser() {
        StringBuilder sb=new StringBuilder();
        if (this.logedInUser.isEmpty()){
            sb.append("Cannot log out.No user was logged in.");
        }else {
            User user= (User) this.userRepository.findByEmail(this.logedInUser);
            sb.append(String.format("User %s successfully logged out.",user.getFullName()));
            this.logedInUser="";
        }
        return sb.toString();
    }
}
