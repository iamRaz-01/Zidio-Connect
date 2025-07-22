package com.example.zidio_connect_spring.controller;

import com.example.zidio_connect_spring.dto.request.AuthenticateRequest;
import com.example.zidio_connect_spring.dto.request.UserRegister;
import com.example.zidio_connect_spring.dto.response.AuthToken;
import com.example.zidio_connect_spring.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthToken> register(
            @RequestBody UserRegister request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthToken> authenticate(
            @RequestBody AuthenticateRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
