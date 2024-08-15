package com.example.security_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security_service.entity.AuthRequest;
import com.example.security_service.entity.User;
import com.example.security_service.repository.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String saveUser(User user) {
        // Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        // if (existingUser != null) {
        //     return "User already exists";
        // }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User saved successfully";
    }

    public String generateToken(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));    
                     
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        }
        return "Invalid credentials";
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
