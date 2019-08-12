package softuni.jsonexercise.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import softuni.jsonexercise.util.FileUtilImpl;
import softuni.jsonexercise.util.ValidatorUtil;
import softuni.jsonexercise.util.ValidatorUtilImpl;

import javax.validation.*;


@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

    }

    @Bean
    public FileUtilImpl fileUtilImpl() {
        return new FileUtilImpl();
    }

    @Bean
    public Validator validator() {
        ValidatorFactory vf =Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
    @Bean
    public ValidatorUtilImpl validatorUtilImpl(){
        return new ValidatorUtilImpl(validator());
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
