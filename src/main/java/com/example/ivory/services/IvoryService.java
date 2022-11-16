package com.example.ivory.services;


import com.example.ivory.models.User;
import com.example.ivory.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IvoryService {


    @Autowired
    UserRepository userRepository;

    public void register(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public List<User> login(String username, String password) {
        return userRepository.login(username,password);
    }

}
