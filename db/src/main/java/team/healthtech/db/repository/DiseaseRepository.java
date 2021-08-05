package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.entity.DiseaseEntity;

import java.util.List;

@Repository
public interface DiseaseRepository extends CrudRepository<DiseaseEntity, Integer>, JpaRepository<DiseaseEntity, Integer>, JpaSpecificationExecutor<DiseaseEntity> {
    @Query("SELECT p " +
        "FROM diseases d " +
        "JOIN d.patient p " +
        "WHERE p.id = ?1 ")
    List<DiseaseEntity> getAllDiseasesByPatientId(Integer patientId);

}
