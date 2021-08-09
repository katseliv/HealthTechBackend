package team.healthtech.service.logic;

import team.healthtech.service.model.create_dto.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

import javax.validation.Valid;
import java.util.List;


public interface AppointmentService {

    AppointmentDto createAppointment(@Valid AppointmentCreateDto appointmentCreateDto, Integer patientId);

    void updateAppointment(AppointmentCreateDto appointmentCreateDto, Integer appointmentId);

    List<AppointmentDto> getAppointmentsOfPatientById(Integer patientId);

}
