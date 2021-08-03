package team.healthtech.service.security;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import team.healthtech.db.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile toProfile(UserEntity userEntity);
}
