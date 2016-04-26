package com.vonzhou.hello;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sun.org.apache.xerces.internal.util.URI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;

/**
 * Created by vonzhou on 16/4/24.
 */
public class TestHessianClient2 {
    public static void main(String[] args) throws MalformedURLException{

        String url = "http://localhost:8080/hessian/remote/helloService.htm";
        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService hello = (HelloService) factory.create(HelloService.class, url);

        System.out.println(hello.sayHi("Hessian"));
    }
}
