package team.healthtech.db.provider;

import team.healthtech.db.entity.UserEntity;

public interface UserSecurityProvider {
    UserEntity findByLogin(String username);
}
