package com.example.demo.exception;

import com.example.demo.exception.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}



