package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.DoctorSpecialityId;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;

@Repository
public interface DoctorsSpecialitiesRepository extends CrudRepository<DoctorsSpecialitiesEntity, DoctorSpecialityId>, JpaRepository<DoctorsSpecialitiesEntity, DoctorSpecialityId>, JpaSpecificationExecutor<DoctorsSpecialitiesEntity> {

}
