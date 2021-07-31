package team.healthtech.service.logic.impl;

import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

public class TimeRecordServiceImpl implements TimeRecordService {
    @Override
    public TimeRecordDto createTimeRecord(TimeRecordDto dto) {
        return null;
    }

    @Override
    public void updateTimeRecord(AppointmentDto appointmentDto, int appointmentId) {

    }

    @Override
    public void deleteTimeRecordsByDoctorId(int doctorId) {

    }

    @Override
    public void deleteTimeRecord(int timeRecordId) {

    }

    @Override
    public AppointmentDto getAppointmentById(int appointmentId) {
        return null;
    }

    @Override
    public void deleteAllAppointments(int timeRecordId) {

    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        return null;
    }
}
