package com.example.chapter0504.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    // spring AOP PointCut 표현식 아주 많음 인터넷으로 찾아보기 //https://icarus8050.tistory.com/8
    @Pointcut("execution(* com.example.chapter0504.controller..*.*(..))")
    private void cut() {
    }



    // 메소드 실행 전에 어떤 값이 들어가는지(before), 리턴할때 어떤 값이 리턴 되는지(afterReturning)
    @Before("cut()")   // pointcut 가 실행되는 메소드 넣어주면 pointCut 이전에 before 라는 메소드 실행시키겠다 라는 뜻
    public void before(JoinPoint joinPoint) { // JoinPoint 들어가는 지점에 대한 정보를 가진 객체
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());


        Object[] args = joinPoint.getArgs();    // 메소드에 들어가는 매개변수들의 배열
        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj );
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj") // 위와 마찬가지
    public void afterReturn(JoinPoint joinPoint, Object returnObj) { //
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
