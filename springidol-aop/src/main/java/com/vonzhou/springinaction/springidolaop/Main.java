package com.vonzhou.springinaction.springidolaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/7/22.
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol-2.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol-around.xml");
        Performer performer = (Performer) context.getBean("eddie");
        try {
            performer.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }

    }
}
