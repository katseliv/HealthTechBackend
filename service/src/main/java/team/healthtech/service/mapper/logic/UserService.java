package team.healthtech.service.mapper.logic;

import team.healthtech.service.mapper.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto findById(int id);

    List<UserDto> find(String search, Integer pageSize, Integer pageNumber);

    List<UserDto> findAll();

    UserDto updateUser(UserDto userDto);

    void deleteUserById(int id);
}
