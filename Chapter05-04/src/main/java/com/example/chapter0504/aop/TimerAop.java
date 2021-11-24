package com.example.chapter0504.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.chapter0504..*.*(..))")
    private void cut() {
    }


    @Pointcut("@annotation(com.example.chapter0504.annotation.Timer)")  // Timer annotation 이 설정된 메소드만
    private void timer() {
    }


    @Around("cut() && timer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();   // joinPoint 의 proceed 를 호출하면 실질적으로 메소드가 실행되는것  // 또한 메소드에 리턴 타입이 있으면 Object로 들어가게됨

        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }

}
