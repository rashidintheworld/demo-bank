package com.example.bankdemoproject.exception;

public class ResourceNotFoundException extends RuntimeException{
    private int code;
    private String message;
    public ResourceNotFoundException(Integer code, String message) {
        this.message = message;
        this.code= code;
    }
}
