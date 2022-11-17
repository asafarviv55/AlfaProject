package com.example.ivory.services;


import com.example.ivory.exceptions.NoDataFoundException;
import com.example.ivory.exceptions.UserExistsException;
import com.example.ivory.exceptions.UserNotFoundException;
import com.example.ivory.models.User;
import com.example.ivory.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    UserRepository userRepository;



    public List<User> login(String username, String password) {
        return userRepository.login(username,password);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User findByCredentials(String username, String password) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    public void saveUser(String username,String password) {
        User user = userRepository.findByCredentials(username,password);
        if(user != null)
            throw new UserExistsException(user.getId());
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        userRepository.save(user1);
    }


    @Override
    public List<User> findAll() {
        var users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException();
        }
        return users;
    }
}
