package com.example.chapter0504.aop;


import com.example.chapter0504.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.chapter0504..*.*(..))")
    private void cut() {
    }


    @Pointcut("@annotation(com.example.chapter0504.annotation.Decode)")  // Timer annotation 이 설정된 메소드만
    private void decode() {
    }


    @Before("cut() && decode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof User) {
                User user = (User) obj;
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), StandardCharsets.UTF_8);
                user.setEmail(email);
            }
        }
    }


    @AfterReturning(value = "cut() && decode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if (returnObj instanceof User) {
            User user = (User) returnObj;
            String email = user.getEmail();
            String base6Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base6Email);
        }
    }


}
