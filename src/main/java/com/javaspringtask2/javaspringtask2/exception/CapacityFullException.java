package com.javaspringtask2.javaspringtask2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CapacityFullException extends RuntimeException{
    public CapacityFullException(String message){
        super(message);
    }
}