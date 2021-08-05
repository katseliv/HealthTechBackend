package team.healthtech.service.model.create_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.time.Instant;

public class DiseaseCreateDto {

    private Integer id;

    @JsonProperty("patient_id")
    private Integer patientId;

    private String name;

    @JsonProperty("start_date")
    private Date startDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}