package team.healthtech.db.entity.enums;

import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "healthtech", name = "specialities")
@Entity(name = "specialities")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final int id;

    @Column
    private final String name;

    @OneToMany(mappedBy = "specialities")
    private List<DoctorsSpecialitiesEntity> doctors;

    public Speciality(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
