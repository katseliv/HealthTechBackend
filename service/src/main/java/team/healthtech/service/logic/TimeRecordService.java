package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

public interface TimeRecordService {
    // нужно ли делить на два сервиса для пациентов и докторов?
    TimeRecordDto createTimeRecord(TimeRecordDto dto);

    void updateTimeRecord(AppointmentDto appointmentDto, int appointmentId);

    // учитывая, что у доктора только одно расписание, будет ли это нормой?
    // или у доктора может быть два расписания?
    void deleteTimeRecordByDoctorId(int doctorId);

    void deleteTimeRecord(int timeRecordId);

    AppointmentDto getAppointmentById(int appointmentId);

    List<AppointmentDto> getAllAppointments();

}
