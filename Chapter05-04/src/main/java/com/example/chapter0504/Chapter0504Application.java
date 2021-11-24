package com.example.chapter0504;

import com.example.chapter0504.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@SpringBootApplication
public class Chapter0504Application {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(Chapter0504Application.class, args);
        System.out.println(Base64.getEncoder().encodeToString("sigea95@naver.com".getBytes()));

    }
}
