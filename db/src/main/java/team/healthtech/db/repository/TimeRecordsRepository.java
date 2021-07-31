package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.TimeRecordsEntity;

@Repository
public interface TimeRecordsRepository extends CrudRepository<TimeRecordsEntity, Integer> {
}
