package team.healthtech.db.entity.enums;

import javax.persistence.*;

@Table(schema = "healthtech", name = "allergies")
@Entity(name = "allergies")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final int id;

    @Column
    private final String name;

    public Allergy(int id, String name) {
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
