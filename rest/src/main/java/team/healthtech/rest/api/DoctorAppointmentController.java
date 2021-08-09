package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.AppointmentService;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;

import java.util.List;

@RestController
@RequestMapping("/doctors/{appointmentId}/appointments")
public class DoctorAppointmentController {

    private final AppointmentService service;

    @Autowired
    public DoctorAppointmentController(AppointmentService service) {
        this.service = service;
    }

    @Secured({"ROLE_PATIENT", "ROLE_DOCTOR"})
    @PutMapping
    public void updateAppointment(
        @RequestBody AppointmentCreateDto appointmentCreateDto,
        @PathVariable Integer appointmentId
    ){
        service.updateAppointment(appointmentCreateDto, appointmentId);
    }

}
