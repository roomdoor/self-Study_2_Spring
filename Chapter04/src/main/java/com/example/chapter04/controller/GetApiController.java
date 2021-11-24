package com.example.chapter04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping("/hello")
    public String hello() {
        return "get hello";
    }


}