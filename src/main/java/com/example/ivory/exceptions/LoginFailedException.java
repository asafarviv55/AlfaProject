package com.example.ivory.exceptions;

public class LoginFailedException extends RuntimeException{

    public LoginFailedException(){
        super("login failed !! invalid username or password");
    }
}
