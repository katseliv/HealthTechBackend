package team.healthtech.service.validation.for_update;

import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.model.UserDto;
import team.healthtech.service.validation.LoginUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginUniqueForUpdate implements ConstraintValidator<LoginUnique, UserDto> {

    private final UserRepository userRepository;

    @Autowired
    public LoginUniqueForUpdate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {
        if (value == null || value.getId() == null || value.getLogin() == null) {
            return true;
        }

        return !userRepository.existsByIdIsNotAndLoginIgnoreCase(value.getId(), value.getLogin());
    }
}
