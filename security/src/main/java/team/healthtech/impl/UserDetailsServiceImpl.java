package team.healthtech.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import team.healthtech.db.entity.UserEntity;
import team.healthtech.db.repository.UserRepository;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity x = userRepository.findByUsernameEqualsIgnoreCase(username);
        return new User(x.getFirstName(), x.getPassword(), List.of());
    }
}
