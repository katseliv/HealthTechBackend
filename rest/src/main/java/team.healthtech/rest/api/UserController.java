package team.healthtech.rest.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping
//    List<UserEntity> findUsers() {
//        return StreamSupport.
//            stream(userRepository.findAll().spliterator(), false).
//            collect(Collectors.toList());
//    }
//
//    @PostMapping
//    UserEntity createUser(@RequestBody UserEntity user) {
//        return userRepository.save(user);
//    }
//
//    @PutMapping
//    UserEntity updateUser(@RequestBody UserEntity user, @RequestParam int id) {
//        user.setId(id);
//        return userRepository.save(user);
//    }
}
