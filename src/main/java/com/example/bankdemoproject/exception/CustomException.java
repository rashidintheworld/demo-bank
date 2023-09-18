package com.example.bankdemoproject.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    Integer code;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Integer code, String message) {
        super(message);
        this.code= code;
    }

}
