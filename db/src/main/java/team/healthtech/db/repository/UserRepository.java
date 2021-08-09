package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>, JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {

    UserEntity findByLoginEqualsIgnoreCase(String login);

    boolean existsByLoginIgnoreCase(String value);

    boolean existsByEmailIgnoreCase(String value);

    boolean existsByIdIsNotAndEmailIgnoreCase(Integer id, String login);

    boolean existsByIdIsNotAndLoginIgnoreCase(Integer id, String login);

}
