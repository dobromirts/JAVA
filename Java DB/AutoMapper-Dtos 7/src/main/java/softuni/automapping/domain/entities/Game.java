package softuni.automapping.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{
    private String title;
    private String trailer;
    private String thumbnail;
    private Double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;
    private Set<User> users;

    public Game() {
    }

    @Column(name = "title",nullable = false,unique = true)
    @Pattern(regexp = "([A-Z][a-zA-Z0-9]+)",message = "Title does not start with capital letter")
    @Size(min = 3,max = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "trailer",unique = true)
    @Size(min = 11,max = 11)
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "thumbnail",unique = true)
    @Pattern(regexp = "(http)?(https)?:\\/\\/.+",message = "Invalid protocol")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Column(name = "size",nullable = false,precision = 1,scale = 19)
    @Min(value = 0)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Column(name = "price",nullable = false,precision = 9,scale = 2)
    @Min(value = 0)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "description")
    @Min(value = 20)
    @Max(value = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date",nullable = false)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToMany(targetEntity = User.class,mappedBy = "games")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
