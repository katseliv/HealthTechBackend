package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.PatientAllergiesService;
import team.healthtech.service.model.AllergyDto;
import team.healthtech.service.model.PatientDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients/{patientId}/allergies")
public class PatientAllergyController {

    private final PatientAllergiesService service;

    @Autowired
    public PatientAllergyController(PatientAllergiesService service) {
        this.service = service;
    }

    @Secured({"ROLE_DOCTOR", "ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{allergyId}")
    public void addAllergyToPatient(@Valid @PathVariable int allergyId,
                                    @PathVariable int patientId) {
        service.addAllergyToPatient(allergyId, patientId);
    }

    @Secured({"ROLE_DOCTOR", "ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AllergyDto> getAllAllergiesFromPatient(@PathVariable int patientId) {
        return service.getAllAllergiesFromPatient(patientId);
    }

    @Secured({"ROLE_DOCTOR", "ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{allergyId}")
    public void deleteAllergyFromPatient(@PathVariable int allergyId,
                                         @PathVariable int patientId) {
        service.deleteAllergyFromPatient(allergyId, patientId);
    }

}
