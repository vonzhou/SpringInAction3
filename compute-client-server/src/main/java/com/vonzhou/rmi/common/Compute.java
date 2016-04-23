package com.vonzhou.rmi.common;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by vonzhou on 16/4/23.
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
