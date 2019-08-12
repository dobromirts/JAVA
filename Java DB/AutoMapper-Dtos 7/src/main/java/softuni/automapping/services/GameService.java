package softuni.automapping.services;

import softuni.automapping.domain.dtos.GameAddDto;
import softuni.automapping.domain.dtos.GameEditDto;

public interface GameService {
    String addGame(GameAddDto gameAddDto);
    void logInUser(String email);
    void logOutUser();
    String editGame(GameEditDto gameEditDto);
    String deleteGame(Integer id);
    String getAllGames();
    String getInfoForGame(String title);
    String getUserGames();
}

