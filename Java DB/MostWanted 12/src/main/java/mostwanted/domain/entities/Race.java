package mostwanted.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "races")
public class Race extends BaseEntity{
    private Integer laps;
    private District district;
    private List<RaceEntry> raceEntries;

    public Race() {
        this.raceEntries=new ArrayList<>();
    }

    @Column(name = "laps",nullable = false,columnDefinition = "integer default 0")
    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }


    @ManyToOne
    @JoinColumn(name = "district_id",referencedColumnName = "id",nullable = false)
    public District getDistrict() {
        return district;
    }


    public void setDistrict(District district) {
        this.district = district;
    }

    @OneToMany(mappedBy = "race")
    public List<RaceEntry> getRaceEntries() {
        return raceEntries;
    }

    public void setRaceEntries(List<RaceEntry> raceEntries) {
        this.raceEntries = raceEntries;
    }
}
