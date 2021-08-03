package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class CommentDto {

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("patient_id")
    private Integer patientId;

    private Integer mark;

    private String comment;

    private Instant date;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

}
