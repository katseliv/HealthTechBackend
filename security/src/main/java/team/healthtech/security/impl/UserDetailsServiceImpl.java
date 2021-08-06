package team.healthtech.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import team.healthtech.db.entity.UserEntity;
import team.healthtech.db.provider.UserSecurityProvider;;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSecurityProvider userSecurityProvider;

    @Autowired
    public UserDetailsServiceImpl(UserSecurityProvider userSecurityProvider) {
        this.userSecurityProvider = userSecurityProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userSecurityProvider.findByLogin(username);
        return new User(userEntity.getLogin(), userEntity.getPassword(), List.of());
    }

}
