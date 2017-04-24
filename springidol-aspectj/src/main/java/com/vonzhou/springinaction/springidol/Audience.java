package com.vonzhou.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* com.vonzhou.springinaction.springidol.Performer.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }

    @Around("performance()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("before around ====");
        try {
            proceedingJoinPoint.proceed();
            System.out.println("after around ===");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}