package team.healthtech.db.repository;

import org.springframework.data.repository.CrudRepository;
import team.healthtech.db.entity.CommentEntity;

public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
