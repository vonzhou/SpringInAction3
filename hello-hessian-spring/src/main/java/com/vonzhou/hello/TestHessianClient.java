package com.vonzhou.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/24.
 */
public class TestHessianClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("remoting-client-context.xml");
        HelloService hello = (HelloService) context.getBean("helloService");
        System.out.println(hello.sayHi("Chown Von"));

        Dog c = hello.getDog();
        System.out.println(c.getName());
    }
}
