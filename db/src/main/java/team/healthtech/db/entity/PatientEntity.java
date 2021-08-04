package team.healthtech.db.entity;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(
    name = "patients-with-allergies",
    attributeNodes = {
        @NamedAttributeNode("id"),
        @NamedAttributeNode("login"),
        @NamedAttributeNode("firstName"),
        @NamedAttributeNode("midName"),
        @NamedAttributeNode("lastName"),
        @NamedAttributeNode(value = "allergies", subgraph = "allergies")
    },
    subgraphs = {
        @NamedSubgraph(
            name = "allergies",
            attributeNodes = {
                @NamedAttributeNode("name")
            }
        )
    }
)
@Table(schema = "healthtech", name = "patients")
@Entity(name = "patients")
public class PatientEntity extends UserEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Character sex;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "patient")
    private List<CommentEntity> comments;

    @ManyToMany
    @JoinTable(
        joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "allergy_id", referencedColumnName = "id"),
        name = "patients_allergies",
        schema = "healthtech"
    )
    private List<AllergyEntity> allergies;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<AllergyEntity> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AllergyEntity> allergies) {
        this.allergies = allergies;
    }

}
