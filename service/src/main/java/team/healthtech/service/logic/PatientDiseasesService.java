package team.healthtech.service.logic;

import team.healthtech.service.model.DiseaseEditDto;

import java.util.List;

public interface PatientDiseasesService {
    List<DiseaseEditDto> getAllDiseases(int patientId);

    // dto because акромя id disease has startdate and patientid
    DiseaseEditDto addDisease(DiseaseEditDto disease, int patientId);

    DiseaseEditDto updateDisease(DiseaseEditDto diseaseEditDto, int diseaseId);

    void deleteDisease(DiseaseEditDto disease, int patientId);

}
