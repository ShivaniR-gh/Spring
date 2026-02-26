package com.example.authservice.service;

import java.util.Optional;

import com.example.authservice.exception.UnauthorizedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.entity.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.security.JwtUtil;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // REGISTER
    public void register(RegisterRequest request) {

        // 1. Check if email already exists
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // 2. Encrypt password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 3. Create user entity
        User user = new User(
                request.getName(),
                request.getEmail(),
                encodedPassword,
                "USER"
        );

        // 4. Save user
        userRepository.save(user);
    }

    // LOGIN (credential check only for now)

    public String login(LoginRequest request) {

        // LOGIN
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT
        return JwtUtil.generateToken(user.getEmail(), user.getRole());
    }

}
