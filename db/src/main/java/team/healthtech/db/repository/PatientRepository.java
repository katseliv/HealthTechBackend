package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import team.healthtech.db.entity.PatientEntity;

public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
}
