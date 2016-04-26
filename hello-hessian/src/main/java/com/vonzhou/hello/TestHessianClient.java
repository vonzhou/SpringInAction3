package com.vonzhou.hello;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Created by vonzhou on 16/4/24.
 */
public class TestHessianClient {
    public static void main(String[] args) {
        String url = "http://localhost:8080/hello-hessian/Hello";
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            HelloService hello = (HelloService) factory.create(HelloService.class, url);
            System.out.println(hello.sayHi("vonzhou"));

            Dog c = hello.getDog();
            System.out.println(c.getName());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
