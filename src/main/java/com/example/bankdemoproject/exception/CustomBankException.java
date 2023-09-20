package com.example.bankdemoproject.exception;


import lombok.Getter;

@Getter
public class CustomBankException extends RuntimeException {
    Integer code;

    public CustomBankException(String message) {
        super(message);
    }

    public CustomBankException(Integer code, String message) {
        super(message);
        this.code= code;
    }

}
