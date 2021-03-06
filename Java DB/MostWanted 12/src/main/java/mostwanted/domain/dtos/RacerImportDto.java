package mostwanted.domain.dtos;

import com.google.gson.annotations.Expose;
import mostwanted.domain.entities.Town;

public class RacerImportDto {
    @Expose
    private String name;
    @Expose
    private Integer age;
    @Expose
    private Double bounty;
    @Expose
    private String homeTown;

    public RacerImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getBounty() {
        return bounty;
    }

    public void setBounty(Double bounty) {
        this.bounty = bounty;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
