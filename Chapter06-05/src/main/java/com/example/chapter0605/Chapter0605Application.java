package com.example.chapter0605;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Chapter0605Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter0605Application.class, args);
    }

}
