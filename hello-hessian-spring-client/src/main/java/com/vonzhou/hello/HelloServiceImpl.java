package com.vonzhou.hello;

/**
 * Created by vonzhou on 16/4/24.
 */
public class HelloServiceImpl implements HelloService{
    public String sayHi(String name) {
        return "Hello " + name + ", Hessian.";
    }

    public Dog getDog() {
        Dog d = new Dog();
        d.setName("DogHuang");
        return d;
    }
}
