package team.healthtech.service.model;

import team.healthtech.service.validation.LoginUnique;

import javax.validation.constraints.*;

public class UserCreateDto {

    @LoginUnique
    @Pattern(regexp = "^[a-zA-Z\\d]{5,100}$", message = "login.invalid")
    @NotNull(message = "login.is-null")
    private String login;

    @NotBlank(message = "email is blank")
    @Size(min = 5, max = 100, message = "email size is invalid")
    private String email;

    @NotBlank(message = "password.is-blank")
    @Min(value = 12, message = "password.too-short")
    @Max(value = 60, message = "password.too-long")
    private String password;


}
