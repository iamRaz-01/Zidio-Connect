package com.example.zidio_connect_spring.service;

import com.example.zidio_connect_spring.entity.User;
import com.example.zidio_connect_spring.repository.UserRepository;
import com.example.zidio_connect_spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices implements UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(UUID userId){
        return userRepository.findById(userId).orElse(null);

    }
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
}
