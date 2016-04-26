package com.vonzhou.spitter.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/23.
 */
public class StartRmiServer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("remote-service-context.xml");

        System.out.println("Waiting for Request from Client ...");

    }
}
