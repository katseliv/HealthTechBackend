package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class DoctorSpecialitiesDto {

    @JsonProperty("speciality_id")
    private Integer specialityId;

    @NotBlank(message = "receive_date.is-blank")
    @JsonProperty("receive_date")
    private Date receiveDate;

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
