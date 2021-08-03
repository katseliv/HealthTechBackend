package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.DiseaseEntity;

@Repository
public interface DiseaseRepository extends CrudRepository<DiseaseEntity, Integer> {
    // get all disease by patient id
}
