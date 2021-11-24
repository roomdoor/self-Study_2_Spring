package com.example.chapter09.controller;

import com.example.chapter09.dto.UserReq;
import com.example.chapter09.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @RequestParam int y) {
        return x + y;
    }


    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 method")
    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/post/user")
    public UserRes userPost(@RequestBody UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

}
