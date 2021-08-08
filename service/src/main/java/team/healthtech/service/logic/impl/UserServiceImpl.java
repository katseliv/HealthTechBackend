package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.logic.UserService;
import team.healthtech.service.mapper.UserMapper;
import team.healthtech.service.model.UserDto;
import team.healthtech.service.security.Profile;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(TimeRecordServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(
        ObjectProvider<Profile> profileProvider,
        UserRepository userRepository,
        UserMapper userMapper
    ) {
        this.profileProvider = profileProvider;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (profileProvider.getIfAvailable() == null) {
            logger.info("Create new user by anonymous");
        } else {
            logger.info("Create new user by {}", profileProvider.getIfAvailable());
        }
        return Optional.of(userDto)
            .map(userMapper::toEntity)
            .map(userRepository::save)
            .map(userMapper::fromEntity)
            .orElseThrow();
    }
}
