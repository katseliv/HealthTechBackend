package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import team.healthtech.db.entity.DoctorSpecialityId;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;

public interface DoctorSpecialitiesRepository extends CrudRepository<DoctorsSpecialitiesEntity, DoctorSpecialityId> {
}
