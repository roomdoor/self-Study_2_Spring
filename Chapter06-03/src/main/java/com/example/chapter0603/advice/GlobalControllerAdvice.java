package com.example.chapter0603.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//(basePackages = "패키지 주소") // basePakage 지정하면 그 패키지에서만 동작   //RestController  기준이기 때문에 RestControllerAdvice 사용 view resolver 를 사용하면 ControllerAdvice 사용
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class) // 모든 예외 잡는 경우
    public ResponseEntity exception(Exception e) {

        System.out.println(e.getClass().getName());
        System.out.println("----------------------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("----------------------------------");
        System.out.println(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)    // 특정 예외만 잡는 경우 ( 이게 있으면 이 Exception 이 발생했을때 위의 모든 예외를  잡는 경우는 실행되지 안음
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
