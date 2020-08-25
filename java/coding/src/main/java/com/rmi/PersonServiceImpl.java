package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by yueran.lyr on 2016/10/7.
 */
public class PersonServiceImpl extends UnicastRemoteObject implements PersonService{
    public PersonServiceImpl() throws RemoteException {
        super();
    }
    public String getName() {
        System.out.println("query name");
        return "lyr";
    }
}
