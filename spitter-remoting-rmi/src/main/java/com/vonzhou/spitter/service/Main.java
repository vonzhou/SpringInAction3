package com.vonzhou.spitter.service;

import com.vonzhou.spitter.common.Spitter;
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
        SpitterService spitterService = (SpitterService)context.getBean("spitterService");

        Spitter s = new Spitter();
        //让他出现错误,看事务是否回滚
        s.setFullName("冯周5");
        s.setUsername("chownvon");
        s.setEmail("2332123@qq.com");
        s.setPassword("123456");

        spitterService.saveSpitter(s);

//        Spitter spitter = dao.getSpitterById(1);
//        System.out.println(spitter.getUsername());
    }


}
