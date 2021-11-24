package com.example.chapter0603.controller;

import com.example.chapter0603.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) { //(required = false) RequestParam 이 없어도 동작하지만 그 값이 null 이됨
        User user = new User();
        user.setAge(age);
        user.setName(name);

        int a = 10 + age;           // nullPoint Exception 발생할것임
        return user;

    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)    // Controller 에 지정된 ExceptionHandler 가 우선적으로 동작하게되고 Global Handler 동작 x
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("api Controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
