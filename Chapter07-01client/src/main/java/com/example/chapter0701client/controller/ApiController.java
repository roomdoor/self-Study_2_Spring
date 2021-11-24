package com.example.chapter0701client.controller;

import com.example.chapter0701client.dto.Req;
import com.example.chapter0701client.dto.UserRequest;
import com.example.chapter0701client.dto.UserResponse;
import com.example.chapter0701client.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello/get")
    public UserResponse getHello() {

        return restTemplateService.hello();
    }

    @GetMapping("/hello/post")
    public UserResponse postHello() {
        return restTemplateService.post();
    }

    @GetMapping("/hello/exchange")
    public UserRequest exchange() {
        return restTemplateService.exchange();
    }


    @GetMapping("/hello/generic-exchange")
    public Req<UserResponse> genericExchange() {
        return restTemplateService.genericExchange();
    }
}

