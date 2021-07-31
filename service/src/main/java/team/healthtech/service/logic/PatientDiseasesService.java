package team.healthtech.service.logic;

import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.entity.enums.Allergy;
import team.healthtech.service.model.DiseaseDto;

import java.util.List;

public interface PatientDiseasesService {

    List<DiseaseDto> getAllDiseases(int patientId);

    // dto because акромя id disease has startdate and patientid
    DiseaseDto addDisease(DiseaseDto disease, int patientId);

    DiseaseDto updateDisease(DiseaseDto diseaseDto, int diseaseId);

    void deleteDisease(DiseaseDto disease, int patientId);

}
