package com.natours.natoursbackend.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
