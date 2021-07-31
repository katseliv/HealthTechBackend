package team.healthtech.service.model;

public class AppointmentCreateDto { // questionable

    private Integer patientId;
    private Integer timeRecordId;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getTimeRecordId() {
        return timeRecordId;
    }

    public void setTimeRecordId(Integer timeRecordId) {
        this.timeRecordId = timeRecordId;
    }
}
