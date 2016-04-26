package com.vonzhou.springinaction.messaging;

public class EchoServiceImpl implements EchoService {

    public void echo(String message) {
        System.out.println("ECHO:  " + message);
    }

}
