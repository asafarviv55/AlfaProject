package com.example.ivory.controllers;


import com.example.ivory.exceptions.LoginFailedException;
import com.example.ivory.models.User;
import com.example.ivory.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ivory")
public class Controller {


    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    UserService userService;


    @GetMapping("register")
    public void Register(@RequestParam String username, @RequestParam String password) {
        logger.info("Register enter.. username: " + username + " password: " +password);
        userService.saveUser(username,password);
    }


    @GetMapping(path = "login" )
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="was Not Found")
    public ResponseEntity<List<User>> login(@RequestParam String username, @RequestParam String password) {
        logger.info("login enter.. username: " + username + " password: " +password);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<User> users = userService.login(username,password);
        if( users.isEmpty())
            throw new LoginFailedException();
        return ResponseEntity.ok(users);
    }

    @GetMapping("user/{id}")
    public void getUserById(@PathVariable  Long id) {
        logger.info("getUserById enter.. : ");
         userService.findById(id);
    }






}
