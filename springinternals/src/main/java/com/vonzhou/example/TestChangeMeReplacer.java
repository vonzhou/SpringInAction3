package com.vonzhou.example;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by vonzhou on 16/4/1.
 */
public class TestChangeMeReplacer implements MethodReplacer {
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("I changed changeMe...");
        return null;
    }


}
