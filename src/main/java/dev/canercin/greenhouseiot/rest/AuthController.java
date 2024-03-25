package dev.canercin.greenhouseiot.rest;

import dev.canercin.greenhouseiot.dto.JwtResponse;
import dev.canercin.greenhouseiot.dto.LoginRequest;
import dev.canercin.greenhouseiot.dto.SignupRequest;
import dev.canercin.greenhouseiot.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authService.signup(signupRequest).toString());
    }
}
