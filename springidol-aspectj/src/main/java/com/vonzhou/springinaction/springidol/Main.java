package com.vonzhou.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Caused by: java.lang.IllegalArgumentException: error at ::0 can't find referenced pointcut performance
 *  因为aspectjrt 1.6.4 版本太低, 换成最新的就OK了,为何?
 * Created by vonzhou on 16/7/22.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer)context.getBean("eddie");
        try {
            performer.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }

    }
}
