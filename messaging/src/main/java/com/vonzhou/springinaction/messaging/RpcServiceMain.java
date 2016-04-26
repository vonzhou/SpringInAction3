package com.vonzhou.springinaction.messaging;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RpcServiceMain {
    public static void main(String[] args) {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        new ClassPathXmlApplicationContext("rpc-service-context.xml");
    }
}
