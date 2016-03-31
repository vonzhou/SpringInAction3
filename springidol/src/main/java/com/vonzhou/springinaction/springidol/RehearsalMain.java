package com.vonzhou.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * 排练
 * Created by vonzhou on 16/3/31.
 */
public class RehearsalMain {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer)context.getBean("carl2");
        performer.perform();
    }
}
