package team.healthtech.db.entity;

import javax.persistence.*;

@Table(schema = "healthtech", name = "user")
@Entity(name = "user")
public class User {
    @Id //javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "mid_name")
    private String mid_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "password")
    private String password;

    public String getFirst_name() {
        return first_name;
    }

    public String getMid_name() {
        return mid_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMid_name(String mid_name) {
        this.mid_name = mid_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
