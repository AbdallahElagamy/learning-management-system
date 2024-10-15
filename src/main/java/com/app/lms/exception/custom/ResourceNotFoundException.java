package com.app.lms.exception.custom;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {}
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
