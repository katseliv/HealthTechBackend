package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.PatientEntity;

import java.util.List;

@Repository
public interface AllergyRepository extends CrudRepository<AllergyEntity, Integer>, JpaRepository<AllergyEntity, Integer>, JpaSpecificationExecutor<AllergyEntity> {
    @Query("" +
        "SELECT a " +
        "FROM patients p " +
        "JOIN p.allergies a " +
        "WHERE p.id = ?1")
    List<AllergyEntity> getAllAllergiesByPatientId(Integer patientId);

}
