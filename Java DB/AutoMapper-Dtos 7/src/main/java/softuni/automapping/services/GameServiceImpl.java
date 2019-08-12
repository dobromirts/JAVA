package softuni.automapping.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import softuni.automapping.domain.dtos.GameAddDto;
import softuni.automapping.domain.dtos.GameEditDto;
import softuni.automapping.domain.entities.Game;
import softuni.automapping.domain.entities.Role;
import softuni.automapping.domain.entities.User;
import softuni.automapping.repositories.GameRepository;
import softuni.automapping.repositories.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private ModelMapper modelMapper;
    private String loggedInUesr;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public String addGame(GameAddDto gameAddDto) {
        StringBuilder sb=new StringBuilder();
        User user= (User) this.userRepository.findByEmail(loggedInUesr);
        Game game=modelMapper.map(gameAddDto,Game.class);
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();

        Set<ConstraintViolation<Game>> violations=validator.validate(game);
        if (violations.size()>0){
            for (ConstraintViolation<Game> violation : violations) {
                 sb.append(violation.getMessage());
            }
            return sb.toString();
        }


        if (user.getRole().equals(Role.ADMIN)){
            this.gameRepository.saveAndFlush(game);
            sb.append(String.format("Added %s",game.getTitle()));
            Set<Game> games = user.getGames();
            games.add(game);
            user.setGames(games);
            this.userRepository.saveAndFlush(user);
        }else {
            sb.append(String.format("%s is not admin",user.getFullName()));
        }


        return sb.toString();
    }

    @Override
    public String editGame(GameEditDto gameEditDto) {
        StringBuilder sb=new StringBuilder();

        Game game=this.gameRepository.findById(gameEditDto.getId()).orElse(null);
        if (game==null){
            return sb.append("Invalid id").toString();
        }

        game.setPrice(gameEditDto.getPrice());
        game.setSize(gameEditDto.getSize());

        gameRepository.saveAndFlush(game);
        sb.append(String.format("Edited %s",game.getTitle()));
        return sb.toString();
    }

    @Override
    public String deleteGame(Integer id) {
        StringBuilder sb=new StringBuilder();
        Game game=this.gameRepository.findById(id).orElse(null);
        if (game==null){
            sb.append("No such game");
        }else {
            gameRepository.delete(game);
            sb.append(String.format("Deleted %s",game.getTitle()));
        }
        return sb.toString();
    }

    @Override
    public String getAllGames() {
        StringBuilder sb=new StringBuilder();
        List<Game> all = this.gameRepository.findAll();
        for (Game game : all) {
            sb.append(String.format("%s %s%n",game.getTitle(),game.getPrice()));
        }
        return sb.toString();
    }

    @Override
    public String getInfoForGame(String title) {
        StringBuilder sb=new StringBuilder();
        Game game = this.gameRepository.findByTitle(title).orElse(null);
        sb.append(String.format("Title: %s%n",game.getTitle()));
        sb.append(String.format("Price: %s%n",game.getPrice()));
        sb.append(String.format("Description: %s%n",game.getDescription()));
        sb.append(String.format("Release date: %s%n",game.getReleaseDate()));

        return sb.toString();
    }

    @Override
    public String getUserGames() {
        StringBuilder sb=new StringBuilder();
        User user= (User) this.userRepository.findByEmail(loggedInUesr);
        Set<Game>games=user.getGames();
        for (Game game : games) {
            sb.append(String.format("Title: %s%n",game.getTitle()));
        }

        return sb.toString();
    }

    @Override
    public void logInUser(String email) {
        this.loggedInUesr=email;
    }

    @Override
    public void logOutUser() {
        this.loggedInUesr="";
    }
}
