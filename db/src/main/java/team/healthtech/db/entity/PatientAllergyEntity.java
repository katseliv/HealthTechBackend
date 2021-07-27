package team.healthtech.db.entity;

import javax.persistence.*;
import java.time.Instant;

@NamedEntityGraphs(
    @NamedEntityGraph(
        name = "1",
        subgraphs = @NamedSubgraph(
            name = "patient",
            attributeNodes = {
                @NamedAttributeNode("user_id_ptr"),
                @NamedAttributeNode("age"),
                @NamedAttributeNode("sex")
            }),
        attributeNodes = {
            @NamedAttributeNode(value = "patient", subgraph = "patient"),
            @NamedAttributeNode("user_id_ptr")
        }
    )
)
@Table(name = "patients", schema = "healthtech")
@Entity(name = "PatientAllergy")
public class PatientAllergyEntity {

    @EmbeddedId
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
