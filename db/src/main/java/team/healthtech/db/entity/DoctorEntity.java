package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "doctors")
@Entity(name = "doctors")
public class DoctorEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id_ptr")
    private Integer id;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "rating")
    private Double rating;
}
