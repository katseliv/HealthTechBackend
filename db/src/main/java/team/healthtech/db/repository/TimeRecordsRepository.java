package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.TimeRecordEntity;

@Repository
public interface TimeRecordsRepository extends CrudRepository<TimeRecordEntity, Integer> {
}
