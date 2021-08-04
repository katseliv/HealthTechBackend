package team.healthtech.service.model.create_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import team.healthtech.service.validation.EmailUnique;
import team.healthtech.service.validation.LoginUnique;

import javax.validation.constraints.*;

public class UserCreateDto {

    @LoginUnique
    @Pattern(regexp = "^[a-zA-Z\\d]{5,32}$", message = "login.invalid")
    @NotNull(message = "login.is-null")
    private String login;

    @EmailUnique
    @Email(message = "email.invalid")
    @NotNull(message = "email.is-null")
    private String email;

    @NotBlank(message = "password.is-blank")
    //@Size(min = 8, max = 10, message = "password.out-of-bounds")
    //@Min(value = 8, message = "password.too-short")
    //@Max(value = 60, message = "password.too-long")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
