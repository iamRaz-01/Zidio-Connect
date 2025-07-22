package com.example.zidio_connect_spring.controller;

import com.example.zidio_connect_spring.entity.User;
import com.example.zidio_connect_spring.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userServices.createUser(user), HttpStatus.CREATED);
    }
}
