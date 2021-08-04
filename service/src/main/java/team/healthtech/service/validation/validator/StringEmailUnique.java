package team.healthtech.service.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.validation.EmailUnique;
import team.healthtech.service.validation.LoginUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringEmailUnique implements ConstraintValidator<EmailUnique, String> {

    private final UserRepository userRepository;

    @Autowired
    public StringEmailUnique(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !userRepository.existsByEmailIgnoreCase(value);
    }
}
