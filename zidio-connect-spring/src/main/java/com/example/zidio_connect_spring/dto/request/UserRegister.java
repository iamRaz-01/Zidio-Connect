package com.example.zidio_connect_spring.dto.request;

import com.example.zidio_connect_spring.Enum.Role;
import lombok.Data;

@Data
public class UserRegister {
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private String phoneNumber;
}
