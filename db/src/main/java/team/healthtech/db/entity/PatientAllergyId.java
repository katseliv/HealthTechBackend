package team.healthtech.db.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class PatientAllergyId implements Serializable {
    @Column(name = "patient_id")
    private Integer patientId;
////////////////////////////////
    @Column(name = "room_id")
    private Integer roomId;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientAllergyId)) return false;
        PatientAllergyId that = (PatientAllergyId) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, roomId);
    }

}
