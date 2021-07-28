package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Integer> {
}
