package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "doctors")
@Entity(name = "doctors")
public class DoctorEntity {
    @Id //javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id_ptr")
    private int id;
}
