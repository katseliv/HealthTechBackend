package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentCreateDto {

    @JsonProperty("patient_id")
    private Integer patientId;

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
