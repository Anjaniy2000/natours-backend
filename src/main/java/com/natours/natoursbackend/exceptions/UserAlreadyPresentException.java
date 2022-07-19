package com.natours.natoursbackend.exceptions;

public class UserAlreadyPresentException extends RuntimeException{
    public UserAlreadyPresentException(String exceptionMessage){
        super(exceptionMessage);
    }//throw new RuntimeException()
}
