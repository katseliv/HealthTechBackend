package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "patients")
@Entity(name = "patients")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id_ptr")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
