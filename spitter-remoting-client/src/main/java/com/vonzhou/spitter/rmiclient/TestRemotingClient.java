package com.vonzhou.spitter.rmiclient;

import com.vonzhou.spitter.common.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/23.
 */
public class TestRemotingClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rmi-client-context.xml");
        GreetingService greetingService = (GreetingService) context.getBean("greetingService");
        String greetingMessage = greetingService.getGreeting("Vonzhou");
        System.out.println("The greeting message is : " + greetingMessage);


        System.out.println("[------------------RMI Client-------------]");
        SpitterService spitterService = (SpitterService) context.getBean("spitterService");
        // 我的理解: 在上面的简单GreetingService中, 通过rmi 方法调用返回的是String对象,String显然实现了java.io.java.io.Serializable
        // 在这里问题就出现在远程方法调用返回的是Spitter对象,所以就要牵扯到对象从RMI server传输到本地,所以Spitter要实现Serializable
        Spitter spitter = spitterService.getSpitter("fengzhou");
        System.out.println(spitter);
    }
}
