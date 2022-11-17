package com.example.ivory.services;

import com.example.ivory.models.User;

import java.util.List;

public interface IUserService {

    User findById(Long id);

    User findByCredentials(String username, String password);

    void saveUser(String username,String password);
    List<User> findAll();

}
