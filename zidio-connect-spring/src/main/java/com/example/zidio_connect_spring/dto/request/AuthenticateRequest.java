package com.example.zidio_connect_spring.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticateRequest {
    private String email;
    private String password;
}