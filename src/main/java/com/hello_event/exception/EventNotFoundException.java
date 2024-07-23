package com.hello_event.exception;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(){
        super(("event not found !"));
    }
}
