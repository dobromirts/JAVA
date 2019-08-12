package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.xml.teams.TeamImportDto;
import softuni.exam.domain.dtos.xml.teams.TeamImportRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAM_XML_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\db-exam\\src\\main\\resources\\files\\xml\\teams.xml";

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final TeamRepository teamRepository;
    private final FileUtil fileUtil;
    private final PictureRepository pictureRepository;

    public TeamServiceImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, TeamRepository teamRepository, FileUtil fileUtil, PictureRepository pictureRepository) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.teamRepository = teamRepository;
        this.fileUtil = fileUtil;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importTeams() throws JAXBException {
        StringBuilder sb=new StringBuilder();
        JAXBContext context=JAXBContext.newInstance(TeamImportRootDto.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        TeamImportRootDto teamImportRootDto= (TeamImportRootDto) unmarshaller.unmarshal(new File(TEAM_XML_PATH));

        for (TeamImportDto teamImportDto : teamImportRootDto.getTeamImportDtos()) {
            if (this.pictureRepository.findByUrl(teamImportDto.getPictureImportDto().getUrl())==null){
                sb.append("Invalid team").append(System.lineSeparator());
                continue;
            }

            Picture picture=this.pictureRepository.findByUrl(teamImportDto.getPictureImportDto().getUrl());
            Team team=this.modelMapper.map(teamImportDto,Team.class);
            team.setPicture(picture);

            if (!this.validatorUtil.isValid(team)){
                sb.append("Invalid team").append(System.lineSeparator());
                continue;
            }

            this.teamRepository.saveAndFlush(team);
            sb.append(String.format("Successfully imported team- %s",team.getName())).append(System.lineSeparator());


        }
        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count()>0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return this.fileUtil.readFile(TEAM_XML_PATH);
    }
}
