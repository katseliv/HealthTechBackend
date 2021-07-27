package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import team.healthtech.db.entity.AppointmentEntity;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Integer> {
}
