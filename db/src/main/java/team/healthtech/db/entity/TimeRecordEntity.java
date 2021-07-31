package team.healthtech.db.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

@Table(schema = "healthtech", name = "time_records")
@Entity(name = "time_records")
public class TimeRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(
        name = "doctor_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false)
    private DoctorEntity doctor;

    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
