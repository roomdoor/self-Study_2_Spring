package com.example.chapter0604.controller;

import com.example.chapter0604.dto.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;


@RestController
@RequestMapping("/api/user")
@Validated
public class ApiController {

    @GetMapping("")
    public User get(

            @Size(min = 2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);

        return user;

    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
