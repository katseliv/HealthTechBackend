package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.TimeRecordEntity;

@Repository
public interface TimeRecordsRepository extends CrudRepository<TimeRecordEntity, Integer>, JpaRepository<TimeRecordEntity, Integer>, JpaSpecificationExecutor<TimeRecordEntity> {

    TimeRecordEntity getTimeRecordEntityByDoctorId(Integer doctorId);

}
