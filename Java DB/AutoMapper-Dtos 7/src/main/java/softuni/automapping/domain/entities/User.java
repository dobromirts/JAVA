package softuni.automapping.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
public class User  extends BaseEntity{
    private String email;
    private String password;
    private String fullName;
    private Set<Game> games;
    private Role role;

    public User() {
    }

    @Column(name = "email",nullable = false,unique = true)
    @Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-z]{2,4}",message = "Incorrect email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "password",nullable = false)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$",message = "Incorrect password!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "full_name",nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToMany(targetEntity = Game.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id",referencedColumnName = "id    "))

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Role getRole() {
        return role;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public void setRole(Role role) {
        this.role = role;
    }
}
