package team.healthtech.db.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.time.Instant;

public class DoctorsSpecialitiesEntity {

    @EmbeddedId
    private DoctorSpecialityId id;

    @Column(name = "receive_date")
    private Instant receiveDate;

    public DoctorSpecialityId getId() {
        return id;
    }

    public void setId(DoctorSpecialityId id) {
        this.id = id;
    }

    public Instant getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Instant receiveDate) {
        this.receiveDate = receiveDate;
    }

}
