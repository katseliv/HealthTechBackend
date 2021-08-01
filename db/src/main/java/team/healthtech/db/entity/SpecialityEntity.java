package team.healthtech.db.entity;

import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "healthtech", name = "specialities")
@Entity(name = "specialities")
public class SpecialityEntity { // ?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "speciality")
    private List<DoctorsSpecialitiesEntity> doctors;

    public SpecialityEntity(int id, String name) {
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
