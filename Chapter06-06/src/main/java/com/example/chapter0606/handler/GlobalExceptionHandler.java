package com.example.chapter0606.handler;


import com.example.chapter0606.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity authException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
