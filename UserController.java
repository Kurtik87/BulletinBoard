package bulletinboardapp.controllers;

import bulletinboardapp.dto.UserDto;
import bulletinboardapp.entities.User;
import bulletinboardapp.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//@RequestMapping("/user")
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto) {
        System.out.println(":::::::::::::::");
        log.info("create user");
        return userService.createNewUser(userDto);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        log.info("get user id={}", userId);
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("++++++++++++");
        log.info("get all users");
        return userService.getAllUsers();
    }

    @GetMapping("/x")
    public String x() {
        log.info("hello, Kurt!");
        return "hello!";
    }

}
