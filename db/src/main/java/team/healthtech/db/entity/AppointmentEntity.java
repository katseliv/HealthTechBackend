package team.healthtech.db.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.Instant;

@Table(schema = "healthtech", name = "appointments")
@Entity(name = "appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(
        name = "patient_id",
        referencedColumnName = "id",
        insertable = true,
        updatable = true)
    private PatientEntity patient;

    @OneToOne
    @JoinColumn(
        name = "time_record_id",
        referencedColumnName = "id",
        insertable = true,
        updatable = true)
    private TimeRecordEntity timeRecord;

    @Column(name = "is_taken")
    private Boolean isTaken;

    @Column(name = "datetime")
    private Instant datetime;

    @Column(name = "result")
    private String result;

    @Column(name = "recipe")
    private String recipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public TimeRecordEntity getTimeRecord() {
        return timeRecord;
    }

    public void setTimeRecord(TimeRecordEntity timeRecord) {
        this.timeRecord = timeRecord;
    }

    public Boolean isTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

}
