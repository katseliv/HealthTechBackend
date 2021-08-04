package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorDto extends UserDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("mid_name")
    private String midName;

    @JsonProperty("last_name")
    private String lastName;

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
