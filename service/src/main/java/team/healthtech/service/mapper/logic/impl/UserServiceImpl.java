package team.healthtech.service.mapper.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.UserRepository;
import team.healthtech.service.mapper.logic.model.UserDto;
import team.healthtech.service.mapper.logic.mapper.UserMapper;
import team.healthtech.service.mapper.logic.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        return Optional.of(userDto)
            .map(userMapper::toEntity)
            .map(repository::save)
            .map(userMapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public UserDto findById(int id) {
        return repository.findById(id)
            .map(userMapper::fromEntity)
            .orElse(null);
    }

    @Override
    public List<UserDto> find(String search, Integer pageSize, Integer pageNumber) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.fromEntities(repository.findAll());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }
}
