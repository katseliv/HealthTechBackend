package team.healthtech.db.entity;

import team.healthtech.db.entity.enums.Speciality;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class DoctorSpecialityId  implements Serializable {

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "speciality_id")
    private Integer specialityId;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoctorSpecialityId)) return false;
        DoctorSpecialityId that = (DoctorSpecialityId) o;
        return Objects.equals(doctorId, that.doctorId) && specialityId.equals(that.specialityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, specialityId);
    }

}
