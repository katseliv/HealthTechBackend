package team.healthtech.service.logic;

import team.healthtech.db.entity.AllergyEntity;

import java.util.List;

public interface PatientAllergiesService {
    void addAllergyToPatient(int allergyId, int patientId);

    void deleteAllergyFromPatient(int allergyId, int patientId);

    List<AllergyEntity> getAllAllergiesFromPatient(int patientId);

    AllergyEntity getAllergyById(int allergyId);
}
