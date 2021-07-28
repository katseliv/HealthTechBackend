package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentDto appointmentDto, int patientId);

}
