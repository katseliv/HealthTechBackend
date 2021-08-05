package team.healthtech.service.logic;

import org.mapstruct.Mapping;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

import java.util.List;

public interface PatientDiseasesService {

    DiseaseDto createDisease(DiseaseCreateDto dto);

    void updateDisease(DiseaseUpdateDto diseaseDto, int diseaseId);

    void deleteDisease(int diseaseId);

    DiseaseDto getDiseaseById(int diseaseId);

    List<DiseaseDto> getAllDiseases(int patientId);

}
