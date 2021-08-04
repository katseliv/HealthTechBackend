package team.healthtech.service.model.create_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class DoctorCreateDto extends UserCreateDto {

    @JsonProperty("first_name")
    @NotBlank(message = "firstName.is-blank")
    @Size(min = 1, max = 100, message = "firstName.out-of-range")
    private String firstName;

    @JsonProperty("mid_name")
    @NotBlank(message = "midName.is-blank")
    @Size(min = 1, max = 100, message = "midName.out-of-range")
    private String midName;

    @Size(min = 1, max = 100, message = "lastName.out-of-range")
    @JsonProperty("last_name")
    @NotBlank(message = "lastName.is-blank")
    private String lastName;

    @Min(value = 0, message = "rating.is-lower-than-minimum")
    @Max(value = 5, message = "rating.is-higher-than-maximum")
    private Double rating;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
