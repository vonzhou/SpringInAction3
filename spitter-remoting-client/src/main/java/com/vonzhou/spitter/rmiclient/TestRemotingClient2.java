package com.vonzhou.spitter.rmiclient;

import com.vonzhou.spitter.common.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/23.
 */
public class TestRemotingClient2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("httpinvoker-client-context.xml");
        SpitterService spitterService = (SpitterService) context.getBean("spitterService");
        Spitter spitter = spitterService.getSpitter("fengzhou");
        System.out.println(spitter);
    }
}
