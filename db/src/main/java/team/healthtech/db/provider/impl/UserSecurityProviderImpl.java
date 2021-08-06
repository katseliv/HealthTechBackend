package team.healthtech.db.provider.impl;

import org.springframework.stereotype.Component;
import team.healthtech.db.entity.UserEntity;
import team.healthtech.db.provider.UserSecurityProvider;
import team.healthtech.db.repository.UserRepository;

@Component
public class UserSecurityProviderImpl implements UserSecurityProvider {

    private final UserRepository repository;

    public UserSecurityProviderImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity findByLogin(String username) {
        return repository.findByLoginEqualsIgnoreCase(username);
    }
}
