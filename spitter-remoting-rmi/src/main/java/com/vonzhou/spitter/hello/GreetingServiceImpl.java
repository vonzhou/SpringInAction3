package com.vonzhou.spitter.hello;

/**
 * Created by vonzhou on 16/4/23.
 */
public class GreetingServiceImpl implements GreetingService{

    public String getGreeting(String name) {
        return "Hello " + name + "!" + " I am the Remote Server.";
    }

}
