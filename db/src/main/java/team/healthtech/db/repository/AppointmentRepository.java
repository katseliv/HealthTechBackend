package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AppointmentEntity;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Integer>, JpaRepository<AppointmentEntity, Integer>, JpaSpecificationExecutor<AppointmentEntity> {

    List<AppointmentEntity> getAllByPatientId(Integer patientId);

}


