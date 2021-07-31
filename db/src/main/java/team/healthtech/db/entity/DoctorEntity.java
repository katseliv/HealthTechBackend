package team.healthtech.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "healthtech", name = "doctors")
@Entity(name = "doctors")
public class DoctorEntity extends UserEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorsSpecialitiesEntity> specialities;

    @OneToMany(mappedBy = "doctor")
    private List<CommentEntity> comments;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
