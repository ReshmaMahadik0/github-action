package com.example.github_actions.controller;

import com.example.github_actions.entity.User;
import com.example.github_actions.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Boot API";
    }

    // POST API
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    // GET API
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
