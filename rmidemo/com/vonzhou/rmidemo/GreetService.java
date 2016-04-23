package com.vonzhou.rmidemo;

import java.rmi.RemoteException;

public interface GreetService extends java.rmi.Remote {

    String sayHello(String name) throws RemoteException;
}
