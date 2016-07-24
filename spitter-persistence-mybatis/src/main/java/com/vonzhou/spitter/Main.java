package com.vonzhou.spitter;

import com.vonzhou.spitter.domain.Spitter;
import com.vonzhou.spitter.service.SpitterService;
import com.vonzhou.spitter.service.SpitterService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by vonzhou on 16/4/5.
 */
public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //JdbcSpitterDao dao = (JdbcSpitterDao)context.getBean("jdbcSpitterDao");

//        SpitterService spitterService = (SpitterService) context.getBean("spitterService");
        SpitterService2 spitterService = (SpitterService2) context.getBean("spitterService2");


        Spitter s = new Spitter();
        s.setFullName("vonzhou");
        s.setUsername("chown");
        s.setEmail("2332123@qq.com");
        s.setPassword("123456");

       // dao.addSpitter(s);

        //Spitter spitter = dao.getSpitterById(1);
        List<Spitter> list = spitterService.findAllSpitters();
        System.out.println(list.size());
    }
}
