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
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "speciality")
    private List<DoctorsSpecialitiesEntity> doctors;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
