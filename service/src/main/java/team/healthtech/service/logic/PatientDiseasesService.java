package team.healthtech.service.logic;

import team.healthtech.service.model.DiseaseDto;

import java.util.List;

public interface PatientDiseasesService {

    // dto because акромя id disease has startdate and patientid
    DiseaseDto createDisease(DiseaseDto disease);

    DiseaseDto updateDisease(DiseaseDto diseaseDto, int diseaseId);

    void deleteDisease(int diseaseId);

    DiseaseDto getDiseaseById(int diseaseId);

    List<DiseaseDto> getAllDiseases(int patientId);
}
