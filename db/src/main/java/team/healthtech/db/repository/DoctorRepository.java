package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, Integer> {
}
