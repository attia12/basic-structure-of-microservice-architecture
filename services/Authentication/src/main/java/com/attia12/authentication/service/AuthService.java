package com.attia12.authentication.service;

import com.attia12.authentication.entity.User;
import com.attia12.authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public String saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return "user added to the system";
    }
    public String generateToken(String username)
    {
        return jwtService.generateToken(username);
    }
    public void validateToken(String token)
    {
        jwtService.validateToken(token);
    }
}
