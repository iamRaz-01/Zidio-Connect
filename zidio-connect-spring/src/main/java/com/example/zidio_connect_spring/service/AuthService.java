package com.example.zidio_connect_spring.service;

import com.example.zidio_connect_spring.dto.request.AuthenticateRequest;
import com.example.zidio_connect_spring.dto.request.UserRegister;
import com.example.zidio_connect_spring.dto.response.AuthToken;
import com.example.zidio_connect_spring.entity.User;
import com.example.zidio_connect_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthToken register(UserRegister request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user.getEmail());
        return new AuthToken(jwtToken);
    }

    public AuthToken authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        String jwtToken = jwtService.generateToken(user.getEmail());
        return new AuthToken(jwtToken);
    }
}
