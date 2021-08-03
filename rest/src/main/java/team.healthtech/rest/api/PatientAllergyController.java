package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.PatientAllergiesService;
import team.healthtech.service.model.AllergyDto;
import team.healthtech.service.model.PatientDto;

import java.util.List;

@RestController
@RequestMapping("/patients/{patientId}/allergies")
public class PatientAllergyController {
    private final PatientAllergiesService service;

    @Autowired
    public PatientAllergyController(PatientAllergiesService service) {
        this.service = service;
    }

    @PutMapping
    public void addAllergyToPatient(@PathVariable int allergyId,
                                    @PathVariable int patientId) {
        service.addAllergyToPatient(allergyId, patientId);
    }

    // AllergyDto?
    @GetMapping
    public List<AllergyDto> getAllAllergiesFromPatient(@PathVariable int patientId) {
        return service.getAllAllergiesFromPatient(patientId);
    }

    @DeleteMapping
    public void deleteAllergyFromPatient(@PathVariable int allergyId,
                                         @PathVariable int patientId) {
        service.deleteAllergyFromPatient(allergyId, patientId);
    }
}
