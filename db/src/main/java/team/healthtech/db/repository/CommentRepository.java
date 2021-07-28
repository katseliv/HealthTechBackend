package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
