package com.example.ivory.controllers;


import com.example.ivory.models.User;
import com.example.ivory.services.IvoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ivory")
public class IvoryController {


    private static final Logger logger = LoggerFactory.getLogger(IvoryController.class);

    @Autowired
    IvoryService ivoryService;


    @GetMapping("register")
    public void Register(@RequestParam String username, @RequestParam String password) {
        logger.info("Register enter.. username: " + username + " password: " +password);
        ivoryService.register(username,password);
    }


    @GetMapping("login")
    public List<User> login(@RequestParam String username, @RequestParam String password) {
        logger.info("login enter.. username: " + username + " password: " +password);
        List<User> users = ivoryService.login(username,password);
        return users;
    }







}
