package com.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by yueran.lyr on 2016/10/7.
 */
public class RMIServer {
    public final static void main(String args[]){
        try {
            PersonService personService = new PersonServiceImpl();
            LocateRegistry.createRegistry(8889);
            Naming.bind("rmi://localhost:8889/person", personService);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
