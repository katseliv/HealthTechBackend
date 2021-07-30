package team.healthtech.service.logic;

import team.healthtech.db.entity.enums.Allergy;

import java.util.List;

public interface PatientAllergiesService {
    List<Allergy> getAllAllergies(int patientId);

    // allergy-type or allergy-Dto-type?
    void addAllergy(int allergyId, int patientId);

    void deleteAllergy(int allergyId, int patientId);
}
