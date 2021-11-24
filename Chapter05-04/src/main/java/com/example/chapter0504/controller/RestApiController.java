package com.example.chapter0504.controller;

import com.example.chapter0504.annotation.Decode;
import com.example.chapter0504.annotation.Timer;
import com.example.chapter0504.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{Id}")
    public String get(@PathVariable(name = "Id") Long id, @RequestParam String name) {
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        //db logic
        Thread.sleep(1000 * 2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put");
        System.out.println(user);
        return user;
    }

}
