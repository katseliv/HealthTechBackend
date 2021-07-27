package team.healthtech.service.mapper;

import team.healthtech.db.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromEntity(UserEntity entity);

    UserEntity toEntity(UserDto dto);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);
}
