package softuni.automapping.controlers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.automapping.domain.dtos.GameAddDto;
import softuni.automapping.domain.dtos.GameEditDto;
import softuni.automapping.domain.dtos.UserLogginDto;
import softuni.automapping.domain.dtos.UserRegisterDto;
import softuni.automapping.services.GameService;
import softuni.automapping.services.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Controller
public class GameStoreController implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;

    public GameStoreController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] params = scanner.nextLine().split("\\|");

            switch (params[0]) {
                case "RegisterUser":
                    UserRegisterDto userDto = new UserRegisterDto(params[1], params[2], params[4]);
                    System.out.println(this.userService.registerUser(userDto));
                    break;
                case "LoginUser":
                    String email=params[1];
                    String password=params[2];
                    UserLogginDto userLogginDto=new UserLogginDto(email,password);
                    System.out.println(this.userService.loginUser(userLogginDto));
                    this.gameService.logInUser(email);
                    break;
                case "LogoutUser":
                    System.out.println(this.userService.logoutUser());
                    this.gameService.logOutUser();
                    break;
                case "AddGame":
                    GameAddDto gameAddDto=new GameAddDto(params[1],params[4],params[5],Double.parseDouble(params[3]),
                            new BigDecimal(params[2]),params[6], LocalDate.parse(params[7], DateTimeFormatter.ofPattern("dd-MM-yyy")));
                    System.out.println(this.gameService.addGame(gameAddDto));
                    break;
                case "EditGame":
                    GameEditDto gameEditDto=new GameEditDto(Integer.parseInt(params[1]),
                            new BigDecimal(params[2]),Double.parseDouble(params[3]));
                    System.out.println(this.userService.logoutUser());
                    break;
                case "DeleteGame":
                    int id=Integer.parseInt(params[1]);
                    System.out.println(this.gameService.deleteGame(id));
                    break;
                case "AllGames":
                    System.out.println(this.gameService.getAllGames());
                    break;
                case "DetailGame":
                    String title=params[1];
                    this.gameService.getInfoForGame(title);
                    break;
                case "OwnedGames":
                    break;
            }
        }
    }
}
