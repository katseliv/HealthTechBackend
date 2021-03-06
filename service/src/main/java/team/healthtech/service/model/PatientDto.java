package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PatientDto extends UserDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("mid_name")
    private String midName;

    @JsonProperty("last_name")
    private String lastName;

    private Integer age;

    private Character sex;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private List<AllergyDto> allergies;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AllergyDto> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AllergyDto> allergies) {
        this.allergies = allergies;
    }

}
