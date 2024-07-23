package com.hello_event.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("user not found !");
    }
}
