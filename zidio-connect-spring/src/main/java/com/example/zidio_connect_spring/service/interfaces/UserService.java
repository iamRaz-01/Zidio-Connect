package com.example.zidio_connect_spring.service.interfaces;
import com.example.zidio_connect_spring.entity.User;
import java.util.*;

public interface UserService {
    User createUser(User user);
    User getUserById(UUID id);
    List<User> getAllUsers();
}
