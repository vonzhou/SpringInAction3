package com.vonzhou.springinaction.springidolaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Stutter {
  public Object stutter(ProceedingJoinPoint call) throws Throwable {
    call.proceed();
    call.proceed();
    call.proceed();
    call.proceed();
    call.proceed();
    call.proceed();
    call.proceed();
    call.proceed();
    return call.proceed();
  }
}
