package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.mapper.UserDto;
import team.healthtech.service.mapper.logic.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    UserDto createUser(@RequestBody UserDto user) {
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    UserDto updateUser(
        @RequestBody UserDto user,
        @PathVariable int id
    ) {
        user.setId(id);
        return service.updateUser(user);
    }

    @GetMapping
    List<UserDto> findUsers(
        @RequestParam(required = false) String search,
        @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
        @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
    ) {
        return service.find(search, pageSize, pageNumber);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable int id) {
        service.deleteUserById(id);
    }

}
