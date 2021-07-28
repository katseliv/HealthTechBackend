package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "doctors")
@Entity(name = "doctors")
public class DoctorEntity extends UserEntity {

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "rating")
    private Double rating;
}
