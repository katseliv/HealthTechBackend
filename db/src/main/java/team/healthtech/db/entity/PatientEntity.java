package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "patients")
@Entity(name = "patients")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id_ptr")
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Character sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

}
