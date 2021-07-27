package team.healthtech.db.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class DoctorSpecialityId  implements Serializable {

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "speciality_id")
    private Speciality speciality;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoctorSpecialityId)) return false;
        DoctorSpecialityId that = (DoctorSpecialityId) o;
        return Objects.equals(doctorId, that.doctorId) && speciality == that.speciality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, speciality);
    }
}
