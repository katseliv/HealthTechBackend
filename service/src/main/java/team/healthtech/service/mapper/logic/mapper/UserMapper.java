package team.healthtech.service.mapper.logic.mapper;

import team.healthtech.db.entity.UserEntity;
import org.mapstruct.Mapper;
import team.healthtech.service.mapper.logic.model.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromEntity(UserEntity entity);

    UserEntity toEntity(UserDto dto);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);
}
