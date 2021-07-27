package team.healthtech.rest.api;

import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.AppointmentService;
import team.healthtech.service.model.AppointmentDto;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/{patientId}")
    AppointmentDto createAppointment(
        @RequestBody AppointmentDto appointmentDto,
        @PathVariable int patientId
    ) {
        return service.createAppointment(appointmentDto, patientId);
    }

    @GetMapping("/{patientId}")
    public List<AppointmentDto> getAppointmentsOfPatient(@PathVariable int patientId) {
        return service.getAppointmentsOfPatientById(patientId);
    }

}
