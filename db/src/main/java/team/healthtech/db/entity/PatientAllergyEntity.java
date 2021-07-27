package team.healthtech.db.entity;

import javax.persistence.*;

@NamedEntityGraphs(
    @NamedEntityGraph(
        name = "patient-with-allergies",
        attributeNodes = {
            @NamedAttributeNode("user_id_ptr"),
            @NamedAttributeNode("age"),
            @NamedAttributeNode("sex"),
            @NamedAttributeNode(value = "allergies", subgraph = "allergies")
        },
        subgraphs = {
            @NamedSubgraph(
                name = "allergies",
                attributeNodes = {
                    @NamedAttributeNode("id"),
                    @NamedAttributeNode("name")
                }
            )
        }
    )
)

@Table(name = "patients", schema = "healthtech")
@Entity(name = "PatientAllergy")
public class PatientAllergyEntity {
    @Id
    private PatientAllergyId id;

    @OneToMany
    @JoinColumn(
        name = "allergy_id",
        referencedColumnName = "allergy_id",
        insertable = false,
        updatable = false
    )

    private UserEntity user;

    public void setId(PatientAllergyId id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
