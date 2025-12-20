package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    // POST /auth/register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {

        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .role(req.getRole())
                .build();

        User saved = userService.register(user);
        return ResponseEntity.ok(saved);
    }

    // POST /auth/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        User user = userService.findByEmail(req.getEmail());
        if (user == null ||
                !encoder.matches(req.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        String token = jwtUtil.generateToken(claims, user.getEmail());

        AuthResponse response = AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();

        return ResponseEntity.ok(response);
    }
}
