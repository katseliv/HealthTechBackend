package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Future;
import java.time.Instant;

public class AppointmentDto {

    private Integer id;

    @JsonProperty("patient_id")
    private Integer patientId;

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("is_taken")
    private Boolean isTaken;

    private Instant datetime;

    private String result;

    private String recipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @JsonProperty("is_taken")
    public Boolean getTaken() {
        return isTaken;
    }

    @JsonProperty("is_taken")
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
