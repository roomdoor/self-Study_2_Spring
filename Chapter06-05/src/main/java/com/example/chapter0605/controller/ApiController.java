package com.example.chapter0605.controller;

import com.example.chapter0605.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j  // lombok 사용하면 sout 대신 사용 할 수 있는 것
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        log.info("User : {}", user); // 중괄호는 뒤에 들어가는 객체의 toString 이 매칭된다

        return user;
    }


}
