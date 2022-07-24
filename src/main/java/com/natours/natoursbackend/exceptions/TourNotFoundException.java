package com.natours.natoursbackend.exceptions;

import java.util.function.Supplier;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
