package dev.canercin.greenhouseiot.service.auth;

import dev.canercin.greenhouseiot.dao.UserRepository;
import dev.canercin.greenhouseiot.dto.JwtResponse;
import dev.canercin.greenhouseiot.dto.LoginRequest;
import dev.canercin.greenhouseiot.dto.SignupRequest;
import dev.canercin.greenhouseiot.entities.Role;
import dev.canercin.greenhouseiot.entities.User;
import dev.canercin.greenhouseiot.service.Jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @Override
    public User signup(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setRole(Role.valueOf(signupRequest.getRole()));
        //user = userRepository.save(user); debug ile bak ne döndürüyor
        userRepository.save(user);
        return user;
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.generateToken(user);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(token);
        return jwtResponse;
    }
}
