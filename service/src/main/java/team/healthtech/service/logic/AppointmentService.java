package team.healthtech.service.logic;

import team.healthtech.service.model.create_dto.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

import java.util.List;


public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentCreateDto appointmentCreateDto, Integer patientId);

    List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId);

}
