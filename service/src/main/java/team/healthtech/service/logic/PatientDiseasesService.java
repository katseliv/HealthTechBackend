package team.healthtech.service.logic;

import team.healthtech.service.model.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;

import java.util.List;

public interface PatientDiseasesService {

    // dto because а кроме id disease has startdate and patientid
    DiseaseCreateDto createDisease(DiseaseCreateDto disease);

    void updateDisease(DiseaseDto diseaseDto, int diseaseId);

    void deleteDisease(int diseaseId);

    DiseaseDto getDiseaseById(int diseaseId);

    List<DiseaseDto> getAllDiseases(int patientId);

}
