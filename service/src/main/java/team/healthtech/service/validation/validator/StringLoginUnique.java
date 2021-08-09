package team.healthtech.service.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.validation.LoginUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringLoginUnique implements ConstraintValidator<LoginUnique, String> {

    private final UserRepository userRepository;

    @Autowired
    public StringLoginUnique(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !userRepository.existsByLoginIgnoreCase(value);
    }

}
