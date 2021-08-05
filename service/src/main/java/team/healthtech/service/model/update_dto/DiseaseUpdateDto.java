package team.healthtech.service.model.update_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class DiseaseUpdateDto {
    @JsonProperty("end_date")
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
