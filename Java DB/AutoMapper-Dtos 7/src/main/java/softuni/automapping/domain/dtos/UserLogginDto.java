package softuni.automapping.domain.dtos;

public class UserLogginDto {
    private String email;
    private String password;

    public UserLogginDto() {
    }

    public UserLogginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
