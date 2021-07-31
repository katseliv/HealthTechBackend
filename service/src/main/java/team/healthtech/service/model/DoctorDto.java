package team.healthtech.service.model;

public class DoctorDto extends UserDto{

    private Boolean sex;
    private Double rating;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
