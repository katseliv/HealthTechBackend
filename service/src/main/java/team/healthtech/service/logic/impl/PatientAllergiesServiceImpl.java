package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.repository.AllergyRepository;
import team.healthtech.service.logic.PatientAllergiesService;

import java.util.List;

@Service
public class PatientAllergiesServiceImpl implements PatientAllergiesService {

    private final AllergyRepository repository;

    public PatientAllergiesServiceImpl(AllergyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addAllergyToPatient(int allergyId, int patientId) {
        // need to make a question
    }

    @Override
    public void deleteAllergyFromPatient(int allergyId, int patientId) {
        // need to make a question
    }

    @Override
    public List<AllergyEntity> getAllAllergiesFromPatient(int patientId) {
        return null;
    }

    @Override
    public AllergyEntity getAllergyById(int allergyId) {
        /*
        return repository.findById(allergyId)
            .map(updateMapper::fromEntity)
            .orElse(null);

            need allergyMapper?

         */
        return null;
    }
}
