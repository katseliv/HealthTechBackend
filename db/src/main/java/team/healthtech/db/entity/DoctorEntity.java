package team.healthtech.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "healthtech", name = "doctors")
@Entity(name = "doctors")
public class DoctorEntity extends UserEntity {

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "rating")
    private Double rating;

//    @OneToMany(mappedBy = "doctorId")
//    private List<DoctorSpecialityId> specialities;

    @OneToMany(mappedBy = "doctor")
    private List<CommentEntity> comments;

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
