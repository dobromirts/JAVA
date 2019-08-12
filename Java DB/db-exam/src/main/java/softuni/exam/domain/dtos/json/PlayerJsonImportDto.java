package softuni.exam.domain.dtos.json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.exam.domain.entities.Position;

import java.math.BigDecimal;

public class PlayerJsonImportDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer number;
    @Expose
    private BigDecimal salary;
    @Expose
    private Position position;
    @Expose
    @SerializedName("picture")
    private PictureJsonImportDto pictureJsonImportDto;
    @Expose
    @SerializedName("team")
    private TeamJsonImportDto teamJsonImportDto;

    public PlayerJsonImportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PictureJsonImportDto getPictureJsonImportDto() {
        return pictureJsonImportDto;
    }

    public void setPictureJsonImportDto(PictureJsonImportDto pictureJsonImportDto) {
        this.pictureJsonImportDto = pictureJsonImportDto;
    }

    public TeamJsonImportDto getTeamJsonImportDto() {
        return teamJsonImportDto;
    }

    public void setTeamJsonImportDto(TeamJsonImportDto teamJsonImportDto) {
        this.teamJsonImportDto = teamJsonImportDto;
    }
}
