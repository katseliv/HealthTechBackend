package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

import javax.validation.Valid;
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
    public DiseaseDto createDisease(@RequestBody DiseaseCreateDto dto) {
        return service.createDisease(dto);
    }

    @GetMapping
    public List<DiseaseDto> getAllDiseasesOfPatient(@PathVariable int patientId) {
        return service.getAllDiseases(patientId);
    }

    @PatchMapping("/{diseaseId}")
    public void updateDisease(@Valid @RequestBody DiseaseUpdateDto dto,
                              @PathVariable int diseaseId){
        service.updateDisease(dto, diseaseId);
    }

}
