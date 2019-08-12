package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.json.PictureJsonImportDto;
import softuni.exam.domain.dtos.json.PlayerJsonImportDto;
import softuni.exam.domain.dtos.json.TeamJsonImportDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String JSON_PLAYERS_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\db-exam\\src\\main\\resources\\files\\json\\players.json";

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final PlayerRepository playerRepository;
    private final FileUtil fileUtil;

    public PlayerServiceImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, TeamRepository teamRepository, PictureRepository pictureRepository, PlayerRepository playerRepository, FileUtil fileUtil) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.playerRepository = playerRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb=new StringBuilder();
        PlayerJsonImportDto[]playerJsonImportDtos=this.gson.fromJson(readPlayersJsonFile(),PlayerJsonImportDto[].class);

        for (PlayerJsonImportDto playerJsonImportDto : playerJsonImportDtos) {
            PictureJsonImportDto pictureJsonImportDto = playerJsonImportDto.getPictureJsonImportDto();
            TeamJsonImportDto teamJsonImportDto = playerJsonImportDto.getTeamJsonImportDto();

            Team team=this.teamRepository.findByName(teamJsonImportDto.getName());
            Picture picture=this.pictureRepository.findByUrl(pictureJsonImportDto.getUrl());

            if (team==null || picture==null){
                sb.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            Player player=this.modelMapper.map(playerJsonImportDto,Player.class);
            player.setPicture(picture);
            player.setTeam(team);

            if (!this.validatorUtil.isValid(player)){
                sb.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            this.playerRepository.saveAndFlush(player);
            sb.append(String.format("Successfully imported player- %s %s",player.getFirstName(),player.getLastName())).append(System.lineSeparator());


        }

        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count()>0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return this.fileUtil.readFile(JSON_PLAYERS_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb=new StringBuilder();
        List<Player> players=this.playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(10000));

        for (Player player : players) {
            sb.append(String.format("   Player name: %s %s",player.getFirstName(),player.getLastName())).append(System.lineSeparator());
            sb.append(String.format("   Number: %s",player.getNumber())).append(System.lineSeparator());
            sb.append(String.format("   Salary: %s",player.getSalary())).append(System.lineSeparator());
            sb.append(String.format("   Team: %s",player.getTeam().getName())).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb=new StringBuilder();
        List<Player> players=this.playerRepository.findAllPlayerByTeam();

        sb.append("Team: North Hub").append(System.lineSeparator());
        for (Player player : players) {
            sb.append(String.format("Player name: %s %s - %s",player.getFirstName(),player.getLastName(),player.getPosition())).append(System.lineSeparator());
            sb.append(String.format("Number: %s",player.getNumber())).append(System.lineSeparator());
        }


        return sb.toString();
    }
}
