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

    @ManyToMany
    @JoinTable(
        joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id"),
        inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "speciality_id"),
        name = "doctors_specialities",
        schema = "healthtech"
    )
    private List<DoctorsSpecialitiesEntity> specialities;

    @OneToMany(mappedBy = "doctors")
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

    public List<DoctorsSpecialitiesEntity> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<DoctorsSpecialitiesEntity> specialities) {
        this.specialities = specialities;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
