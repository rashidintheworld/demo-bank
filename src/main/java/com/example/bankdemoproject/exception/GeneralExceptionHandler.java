package com.example.bankdemoproject.exception;

import com.example.bankdemoproject.dto.respond.RespStatus;
import com.example.bankdemoproject.dto.respond.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public Response handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        Response response = new Response();
        response.setRespStatus(new RespStatus(HttpStatus.NOT_FOUND.value(), "Resource not found!"));
        return response;
    }

    @ExceptionHandler(CustomBankException.class)
    public Response handleCustomException(CustomBankException customException) {
        Response response = new Response();
        response.setRespStatus(new RespStatus(customException.getCode(), customException.getMessage()));
        return response;
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception exception) {
        Response response = new Response();
        response.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal server exception"));
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
        public Response handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        Response response = new Response();
        response.setRespStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA,methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage()));
        return response;
    }
}
