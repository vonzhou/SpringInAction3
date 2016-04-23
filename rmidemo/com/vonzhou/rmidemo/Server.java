package com.vonzhou.rmidemo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.vonzhou.rmidemo.GreetServiceImpl;

public class Server {

    public static void main(String[] args) {
        try {
                        LocateRegistry.createRegistry(1099);
                                    Naming.bind("rmi://localhost:1099/GreetService", new GreetServiceImpl());
        } catch (RemoteException e) {
                        e.printStackTrace();
        } catch (MalformedURLException e) {
                        e.printStackTrace();
        } catch (AlreadyBoundException e) {
                        e.printStackTrace();
        }

    }


}
