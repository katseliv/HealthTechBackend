package team.healthtech.db.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(schema = "healthtech", name = "appointments")
@Entity(name = "appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(
        name = "patient_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false)
    private PatientEntity patient;

    @OneToOne
    @JoinColumn(
        name = "time_record_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false)
    private TimeRecordsEntity timeRecord;

    @Column(name = "is_taken")
    private boolean isTaken;

    @Column(name = "datetime")
    private Instant datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public TimeRecordsEntity getTimeRecord() {
        return timeRecord;
    }

    public void setTimeRecord(TimeRecordsEntity timeRecord) {
        this.timeRecord = timeRecord;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

}
