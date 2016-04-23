package com.vonzhou.rmidemo;

import java.rmi.RemoteException;

public class GreetServiceImpl extends java.rmi.server.UnicastRemoteObject implements GreetService {

        private static final long serialVersionUID = 3434060152387200042L;

        public GreetServiceImpl() throws RemoteException {
                    super();

        }

            @Override
            public String sayHello(String name) throws RemoteException {
                        return "Hello " + name;

            }


}
