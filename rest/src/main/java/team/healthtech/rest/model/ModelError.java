package team.healthtech.rest.model;

import java.util.List;

public class ModelError {

    private List<ValidationError> errors;

    public ModelError(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

}
