package com.natours.natoursbackend.exceptions;

public class InvalidRefreshTokenException extends RuntimeException{
    public InvalidRefreshTokenException(String exceptionMessage){
        super(exceptionMessage);
    }
}
