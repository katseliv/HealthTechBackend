package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.DoctorSpecialityId;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;

@Repository
public interface DoctorsSpecialitiesRepository extends CrudRepository<DoctorsSpecialitiesEntity, DoctorSpecialityId> {
}
