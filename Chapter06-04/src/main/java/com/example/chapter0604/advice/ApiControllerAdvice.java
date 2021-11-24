package com.example.chapter0604.advice;

import com.example.chapter0604.controller.ApiController;
import com.example.chapter0604.dto.Error;
import com.example.chapter0604.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestControllerAdvice(basePackageClasses = ApiController.class)
class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(error -> {
            FieldError field = (FieldError) error;

            String fieldName = field.getField();
            String message = field.getDefaultMessage();
            String value = field.getRejectedValue().toString();

            Error errorMessage = new Error();
            errorMessage.setMessage(message);
            errorMessage.setField(fieldName);
            errorMessage.setInvalidValue(value);

            errorList.add(errorMessage);

        });

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setResultCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setStateCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException(ConstraintViolationException e, HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        e.getConstraintViolations().forEach(error -> {
            Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);
            List<Path.Node> list = stream.collect(Collectors.toList());

            String field = list.get(list.size() - 1).getName();
            String message = error.getMessage();
            String invalidValue = error.getInvalidValue().toString();
            System.out.println(field);
            System.out.println(message);
            System.out.println(invalidValue);

            Error errorMessage = new Error();
            errorMessage.setMessage(message);
            errorMessage.setField(field);
            errorMessage.setInvalidValue(invalidValue);

            errorList.add(errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setResultCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setStateCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity MissingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        String fieldName = e.getParameterName();
        String invalidValue = e.getMessage();

        Error errorMessage = new Error();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setField(fieldName);

        errorList.add(errorMessage);

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setResultCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setStateCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
