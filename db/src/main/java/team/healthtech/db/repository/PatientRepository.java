package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.entity.PatientEntity;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Integer>{
}
