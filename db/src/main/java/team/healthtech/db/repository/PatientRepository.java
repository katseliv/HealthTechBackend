package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.PatientEntity;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
}
