package team.healthtech.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import team.healthtech.rest.exceptions.TimeTableAlreadyExists;
import team.healthtech.rest.model.ModelError;
import team.healthtech.rest.model.ValidationError;
import team.healthtech.service.EntityNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class HealthtechExceptionHandlers {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HealthtechExceptionHandlers.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ModelError> handleCvl(ConstraintViolationException e) {
        var errors = e.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .map(ValidationError::new)
            .collect(Collectors.toUnmodifiableList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ModelError(errors));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEnf(EntityNotFoundException e) {
        logger.error("Failed to find entity in DB", e);
    }
}
