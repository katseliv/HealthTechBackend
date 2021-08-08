package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class DoctorSpecialitiesDto {

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("speciality_id")
    private Integer specialityId;

    @JsonProperty("receive_date")
    private Date receiveDate;

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

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

}
