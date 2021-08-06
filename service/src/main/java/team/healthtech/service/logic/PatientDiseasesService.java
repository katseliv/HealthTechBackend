package team.healthtech.service.logic;

import org.mapstruct.Mapping;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

import javax.validation.Valid;
import java.util.List;

public interface PatientDiseasesService {

    DiseaseDto createDisease(@Valid DiseaseCreateDto dto);

    void updateDisease(@Valid DiseaseUpdateDto diseaseDto, int diseaseId);

    void deleteDisease(int diseaseId);

    DiseaseDto getDiseaseById(int diseaseId);

    List<DiseaseDto> getAllDiseases(int patientId);

}
