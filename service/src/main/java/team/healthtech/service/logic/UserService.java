package team.healthtech.service.logic;

import org.springframework.stereotype.Service;
import team.healthtech.service.model.UserDto;

public interface UserService {

    UserDto createUser (UserDto userDto);

}
