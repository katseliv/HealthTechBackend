package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.AppointmentService;
import team.healthtech.service.model.AppointmentCreateDto;
import team.healthtech.service.model.AppointmentDto;

import java.util.List;

@RestController
@RequestMapping("/patients/{patientId}/appointments")
public class PatientAppointmentController {

    private final AppointmentService service;

    @Autowired
    public PatientAppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    AppointmentDto createAppointment(@RequestBody AppointmentCreateDto appointmentCreateDto, @PathVariable int patientId){
        return service.createAppointment(appointmentCreateDto, patientId);
    }

    @GetMapping
    List<AppointmentDto> getAllAppointmentsOfPatient(@PathVariable int patientId){
        return service.getAppointmentsOfPatientById(patientId);
    }

}
