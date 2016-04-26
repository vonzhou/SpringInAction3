package com.vonzhou.springinaction.messaging;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Receiver {
    public static void main(String[] args) {

        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        new ClassPathXmlApplicationContext("receiver-context.xml");
    }
}
