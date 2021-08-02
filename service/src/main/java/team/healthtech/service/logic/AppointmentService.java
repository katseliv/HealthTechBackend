package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

import java.util.List;


public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentCreateDto appointmentDto, Integer patientId);

    List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId);

}
