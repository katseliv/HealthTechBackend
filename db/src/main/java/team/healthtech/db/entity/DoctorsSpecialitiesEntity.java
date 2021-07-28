package team.healthtech.db.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.time.Instant;

@Table(schema = "healthtech", name = "doctors_specialities")
@Entity(name = "doctors_specialities")
public class DoctorsSpecialitiesEntity {
    @EmbeddedId
    private DoctorSpecialityId id;

    @Column(name = "receive_date")
    private Date receiveDate;

    public DoctorSpecialityId getId() {
        return id;
    }

    public void setId(DoctorSpecialityId id) {
        this.id = id;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

}
