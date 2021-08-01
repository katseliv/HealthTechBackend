package team.healthtech.service.logic.impl;

import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.service.logic.PatientAllergiesService;

import java.util.List;

public class PatientAllergiesServiceImpl implements PatientAllergiesService {
    @Override
    public void addAllergyToPatient(int allergyId, int patientId) {

    }

    @Override
    public void deleteAllergyFromPatient(int allergyId, int patientId) {

    }

    @Override
    public List<AllergyEntity> getAllAllergiesFromPatient(int patientId) {
        return null;
    }

    @Override
    public AllergyEntity getAllergyById(int allergyId) {
        return null;
    }
}
