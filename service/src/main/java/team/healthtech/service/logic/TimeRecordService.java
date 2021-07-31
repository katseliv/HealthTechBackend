package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

public interface TimeRecordService {
    TimeRecordDto createTimeRecord(TimeRecordDto dto);

    void updateTimeRecord(AppointmentDto appointmentDto, int appointmentId);

    // учитывая, что у доктора только одно расписание, будет ли это нормой?
    // или у доктора может быть два расписания?
    void deleteTimeRecordsByDoctorId(int doctorId);

    void deleteTimeRecord(int timeRecordId);

    AppointmentDto getAppointmentById(int appointmentId);

    void deleteAllAppointments(int timeRecordId);

    List<AppointmentDto> getAllAppointments();

}
