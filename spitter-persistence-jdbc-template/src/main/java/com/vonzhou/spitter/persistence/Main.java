package com.vonzhou.spitter.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vonzhou on 16/4/5.
 */
public class Main {
    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
        SpitterDao dao = (SpitterDao)context.getBean("spitterDao");

        Spitter s = new Spitter();
        s.setFullName("vonzhou2");
        s.setUsername("chown2");
        s.setEmail("2332123@qq.com");
        s.setPassword("123456");

        dao.addSpitter(s);

        Spitter spitter = dao.getSpitterById(1);
        System.out.println(spitter.getUsername());
    }

    public static void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
        SpitterDao dao = (SpitterDao)context.getBean("spitterDao2");

        Spitter s = new Spitter();
        s.setFullName("Yu Luan");
        s.setUsername("Luyna");
        s.setEmail("444444@qq.com");
        s.setPassword("123456");

        dao.addSpitter(s);
    }

    public static void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
        SpitterDao dao = (SpitterDao)context.getBean("spitterDao3");

        Spitter s = new Spitter();
        s.setFullName("Feng zhou");
        s.setUsername("zhou");
        s.setEmail("444333@qq.com");
        s.setPassword("123456");

        dao.addSpitter(s);
    }
}
