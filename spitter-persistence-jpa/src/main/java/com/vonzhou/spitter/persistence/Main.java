package com.vonzhou.spitter.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/5.
 */
public class Main {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
        SpitterDao dao = (SpitterDao)context.getBean("spitterDao");

        Spitter s = new Spitter();
        s.setFullName("冯周2");
        s.setUsername("von");
        s.setEmail("2332123@qq.com");
        s.setPassword("123456");

        dao.addSpitter(s);

//        Spitter spitter = dao.getSpitterById(1);
//        System.out.println(spitter.getUsername());
    }


}
