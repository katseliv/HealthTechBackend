package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.time.Instant;
import java.util.Date;

public class TimeRecordDto {

    private Integer id;

    private DoctorDto doctor;

    @NotBlank(message = "startTime.is-null")
    @Future(message = "startTime.invalid")
    @JsonProperty("start_time")
    private Time startTime;

    @NotBlank(message = "endTime.is-null")
    @Future(message = "endTime.invalid")
    @JsonProperty("end_time")
    private Time endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
