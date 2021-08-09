package team.healthtech.service.validation.for_update;

import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.model.UserDto;
import team.healthtech.service.validation.EmailUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueForUpdate implements ConstraintValidator<EmailUnique, UserDto> {

    private final UserRepository userRepository;

    @Autowired
    public EmailUniqueForUpdate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {
        if (value == null || value.getId() == null || value.getEmail() == null) {
            return true;
        }

        return !userRepository.existsByIdIsNotAndEmailIgnoreCase(value.getId(), value.getLogin());
    }

}
