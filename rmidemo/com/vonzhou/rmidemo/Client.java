package com.vonzhou.rmidemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.vonzhou.rmidemo.GreetService;

public class Client {

    public static void main(String[] args) {
        try {
                        GreetService greetService = (GreetService) Naming.lookup("rmi://localhost:1099/GreetService");
                                    System.out.println(greetService.sayHello("Jobs"));

        } catch (MalformedURLException e) {
                        e.printStackTrace();

        } catch (RemoteException e) {
                        e.printStackTrace();

        } catch (NotBoundException e) {
                        e.printStackTrace();

        }

    }


}
