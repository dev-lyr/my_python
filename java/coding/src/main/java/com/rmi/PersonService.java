package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by yueran.lyr on 2016/10/7.
 * Note: remote interface must extends Remote and method must throw RemoteException.
 */
public interface PersonService extends Remote{
    public String getName() throws RemoteException;
}
