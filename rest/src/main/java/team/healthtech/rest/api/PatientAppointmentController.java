package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.AppointmentService;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;
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

    @Secured({"ROLE_PATIENT", "ROLE_DOCTOR", "ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AppointmentDto createAppointment(
        @RequestBody AppointmentCreateDto appointmentCreateDto,
        @PathVariable Integer patientId
    ){
        return service.createAppointment(appointmentCreateDto, patientId);
    }

    @Secured({"ROLE_PATIENT", "ROLE_DOCTOR", "ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AppointmentDto> getAllAppointmentsOfPatient(@PathVariable int patientId){
        return service.getAppointmentsOfPatientById(patientId);
    }

}
