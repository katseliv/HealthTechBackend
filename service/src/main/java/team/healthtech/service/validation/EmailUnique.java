package team.healthtech.service.validation;

import team.healthtech.service.validation.for_update.EmailUniqueForUpdate;
import team.healthtech.service.validation.for_update.LoginUniqueForUpdate;
import team.healthtech.service.validation.validator.StringEmailUnique;
import team.healthtech.service.validation.validator.StringLoginUnique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringEmailUnique.class, EmailUniqueForUpdate.class})
public @interface EmailUnique {

    String message() default "email.already-exists";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};

}
