package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;

public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    AppointmentDto updateUser(AppointmentDto appointmentDto);

    void deleteAppointmentById(int id);

}
