package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.healthtech.db.entity.User;
import team.healthtech.db.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    List<User> findUsers() {
        return StreamSupport.
            stream(userRepository.findAll().spliterator(), false).
            collect(Collectors.toList());
    }

    @PostMapping
    User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    User updateUser(@RequestBody User user, @RequestParam int id) {
        user.setId(id);
        return userRepository.save(user);
    }
}
