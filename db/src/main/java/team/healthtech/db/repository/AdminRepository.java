package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.AdminEntity;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Integer> {
}
