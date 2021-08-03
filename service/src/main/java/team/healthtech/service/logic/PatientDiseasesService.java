package team.healthtech.service.logic;

import org.mapstruct.Mapping;
import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;

import java.util.List;

public interface PatientDiseasesService {

    DiseaseDto createDisease(DiseaseCreateDto dto);

    void updateDisease(DiseaseDto diseaseDto, int diseaseId);

    void deleteDisease(int diseaseId);

    DiseaseDto getDiseaseById(int diseaseId);

    List<DiseaseDto> getAllDiseases(int patientId);

}
