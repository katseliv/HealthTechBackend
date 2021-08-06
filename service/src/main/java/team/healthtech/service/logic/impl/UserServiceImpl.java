package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.logic.UserService;
import team.healthtech.service.mapper.UserMapper;
import team.healthtech.service.model.UserDto;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return Optional.of(userDto)
            .map(userMapper::toEntity)
            .map(userRepository::save)
            .map(userMapper::fromEntity)
            .orElseThrow();
    }
}
