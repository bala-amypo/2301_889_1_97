package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}


