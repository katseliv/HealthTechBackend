package team.healthtech.service.model;

import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.entity.TimeRecordsEntity;

import java.time.Instant;

public class AppointmentDto {

    private PatientEntity patient;
    private TimeRecordsEntity timeRecord;
//    private String result;
//    private String recipe;
    private boolean isTaken;
//    private String status;
    private Instant datetime;

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public TimeRecordsEntity getTimeRecord() {
        return timeRecord;
    }

    public void setTimeRecord(TimeRecordsEntity timeRecord) {
        this.timeRecord = timeRecord;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

}
