package team.healthtech.service.security;

import org.springframework.context.annotation.Bean;
import team.healthtech.db.entity.UserEntity;
public interface ProfileMapper {

    @Bean
    Profile toProfile(UserEntity userEntity);
}
