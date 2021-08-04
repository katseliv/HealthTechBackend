package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class DoctorSpecialitiesDto {

    private String name;

    @JsonProperty("receive_date")
    private Date receiveDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

}
