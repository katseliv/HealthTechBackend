package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.PatientService;
import team.healthtech.service.model.PatientDto;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public PatientDto createPatient(
        @RequestBody PatientDto patientDto
    ) {
        return service.createPatient(patientDto);
    }

    @GetMapping
    public List<PatientDto> getAllPatients() {
        return service.getAllPatients();
    }

    @PutMapping("/{patientId}")
    public void updatePatient(@RequestBody PatientDto patientDto,
                              @PathVariable int patientId
    ) {
        service.updatePatient(patientDto, patientId);
    }

    @GetMapping("/{patientId}")
    public PatientDto getPatient(
        @PathVariable int patientId
    ) {
        return service.getPatientById(patientId);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(
        @PathVariable int patientId
    ) {
        service.deletePatientById(patientId);
    }

}
