package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer>, JpaRepository<CommentEntity, Integer>, JpaSpecificationExecutor<CommentEntity> {

    List<CommentEntity> getAllByDoctorId(Integer doctorId);

}
