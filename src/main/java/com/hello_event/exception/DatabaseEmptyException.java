package com.hello_event.exception;

public class DatabaseEmptyException extends RuntimeException{
    public DatabaseEmptyException(){
        super("database is empty ! no data found");
    }
}
