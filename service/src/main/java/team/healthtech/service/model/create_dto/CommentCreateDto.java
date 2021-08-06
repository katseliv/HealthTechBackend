package team.healthtech.service.model.create_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class CommentCreateDto {

    @JsonProperty("patient_id")
    private Integer patientId;

    @Max(value = 5, message = "mark.too-big")
    @Min(value = 0, message = "mark.too-small")
    private Integer mark;

    private String comment;

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

}
