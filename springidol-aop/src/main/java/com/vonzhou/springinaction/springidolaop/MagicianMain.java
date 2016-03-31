package com.vonzhou.springinaction.springidolaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * P99  sneaky : 卑鄙的
 * Created by vonzhou on 16/3/31.
 */
public class MagicianMain {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("sneaky-magician.xml");
        Thinker volunteer = (Thinker)context.getBean("volunteer");
        volunteer.thinkOfSomething("I want to play basketball, en");
    }
}
