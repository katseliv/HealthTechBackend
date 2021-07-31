package team.healthtech.service.logic;

import team.healthtech.db.entity.enums.Allergy;
import team.healthtech.service.model.DiseaseDto;

import java.util.List;

public interface PatientAllergiesService {
    void addAllergyToPatient(int allergyId, int patientId);

    void deleteAllergyFromPatient(int allergyId, int patientId);

    List<Allergy> getAllAllergiesFromPatient(int patientId);

    Allergy getAllergyById(int allergyId);
}
