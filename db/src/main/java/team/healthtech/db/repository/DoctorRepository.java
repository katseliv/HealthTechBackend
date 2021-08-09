package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, Integer> {
}
