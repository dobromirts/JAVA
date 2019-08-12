package softuni.exam.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
    private String name;
    private Picture picture;

    public Team() {
    }


    @NotNull
    @Size(min = 3,max = 20)
    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(targetEntity = Picture.class)
    @JoinColumn(name = "picture_id",referencedColumnName = "id",nullable = false)
    @NotNull
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
