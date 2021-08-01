package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "allergies")
@Entity(name = "allergies")
public class AllergyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final int id;

    @Column(name = "name")
    private final String name;

    public AllergyEntity(int id, String name) {
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
