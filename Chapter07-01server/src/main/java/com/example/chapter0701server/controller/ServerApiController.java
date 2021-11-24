package com.example.chapter0701server.controller;

import com.example.chapter0701server.dto.Req;
import com.example.chapter0701server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    //    https://openapi.naver.com/v1/search/local.json
    //    ?query=\xea\xb0\x88\xeb\xb9\x84\xec\xa7\x91
    //    &display=10
    //    &start=1
    //    &sort=random
    @GetMapping("/naver")
    public String naver() {

        String query = "중국집";

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "PwXwgWendO09edlq9X7k")
                .header("X-Naver-Client-Secret", "BkJqVmzvtH")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();

    }


    @GetMapping("/hello")
    public User helle() {
        User user = new User();
        user.setName("get name");
        user.setAge(30);
        return user;
    }

    @PostMapping("/user1/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName) {
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("client req : {}", user);
        return user;
    }

    @PostMapping("/user2/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization,
                     @RequestHeader("custom-header") String customHeader) {
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization : {}, custom : {}", authorization, customHeader);
        log.info("client req : {}", user);
        return user;
    }

    @PostMapping("/user3/{userId}/name/{userName}")
    public Req<User> post(
            @RequestBody Req<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader) {

        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization : {}, custom : {}", authorization, customHeader);
        log.info("client req : {}", user);

        Req<User> response = new Req<>();
        response.setResBody(user.getResBody());
        response.setHeader(new Req.Header());
        return response;
    }
}
