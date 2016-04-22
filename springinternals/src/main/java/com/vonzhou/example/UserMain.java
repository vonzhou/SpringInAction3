package com.vonzhou.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/1.
 */
public class UserMain {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        GetBeanTest test = (GetBeanTest)context.getBean("getBeanTest");
        test.showMe();

        TestChangeMe test2 = (TestChangeMe)context.getBean("testChangeMe");
        test2.changeMe();

        Car car = (Car)context.getBean("car");
//        Car car2 = (Car)context.getBean();
        System.out.println(car.getBrand());

    }
}
