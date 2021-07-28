package team.healthtech.db.entity;

import javax.persistence.*;
/*
    MappedSuperClass InheritanceStrategy - две аннотации, которые позволяют организовывать наследование, где его по сути нет
    в реляционных бд их нет ни в каком виде, а с точки зрения кода - есть
 */
@Table(schema = "healthtech", name = "users")
@Entity(name = "users")
public class UserEntity {

    @Id //javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
