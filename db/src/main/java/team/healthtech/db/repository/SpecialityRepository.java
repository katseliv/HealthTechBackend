package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.SpecialityEntity;

@Repository
public interface SpecialityRepository extends CrudRepository<SpecialityEntity, Integer> {
}
