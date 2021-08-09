package team.healthtech.service.logic;

import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.service.model.AllergyDto;

import javax.validation.Valid;
import java.util.List;

public interface PatientAllergiesService {

    void addAllergyToPatient(@Valid int allergyId, int patientId);

    void deleteAllergyFromPatient(int allergyId, int patientId);

    List<AllergyDto> getAllAllergiesFromPatient(int patientId);

    AllergyDto getAllergyById(int allergyId);

}
