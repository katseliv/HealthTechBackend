package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
