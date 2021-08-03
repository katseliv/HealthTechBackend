package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.PatientDto;

import java.util.List;

@RestController
@RequestMapping("patients/{patientId}/diseases")
public class PatientDiseaseController {
    private final PatientDiseasesService service;

    @Autowired
    public PatientDiseaseController(PatientDiseasesService service) {
        this.service = service;

    }

    @PostMapping
    public DiseaseCreateDto createDisease(@RequestBody DiseaseCreateDto dto,
                                          @PathVariable int patientId) {
        return service.createDisease(dto, patientId);
    }

    @GetMapping
    public List<DiseaseDto> getAllDiseasesOfPatient(@PathVariable int patientId) {
        return service.getAllDiseases(patientId);
    }

    @PutMapping
    public void updateDisease(@RequestBody DiseaseDto dto,
                              @PathVariable int diseaseId){
        service.updateDisease(dto, diseaseId);
    }
}
