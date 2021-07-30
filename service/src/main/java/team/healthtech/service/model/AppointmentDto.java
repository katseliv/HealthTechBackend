package team.healthtech.service.model;

import java.time.Instant;

public class AppointmentDto {

    //patientId
    //timeRecordId

    private PatientDto patient;
    private TimeRecordDto timeRecord;
    private boolean isTaken;
    private Instant datetime;
    private String result;
    private String recipe;

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public TimeRecordDto getTimeRecord() {
        return timeRecord;
    }

    public void setTimeRecord(TimeRecordDto timeRecord) {
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
