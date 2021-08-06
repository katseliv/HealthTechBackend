package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import team.healthtech.db.entity.UserEntity;
import team.healthtech.service.model.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromEntity(UserEntity entity);

    UserEntity toEntity(UserDto dto);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);

}
