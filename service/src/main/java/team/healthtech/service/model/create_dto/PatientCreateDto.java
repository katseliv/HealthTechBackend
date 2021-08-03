package team.healthtech.service.model.create_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PatientCreateDto extends UserCreateDto {
    @JsonProperty("age")
    private Integer age;

    @JsonProperty("sex")
    private Character sex;

    @JsonProperty("phone_number")
    @Size(min = 7, max = 11, message = "phone_number.out-of-range")
    @NotBlank(message = "phone_number.is-blank")
    private String phoneNumber;

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
}
