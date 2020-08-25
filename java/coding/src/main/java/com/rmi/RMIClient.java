package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by yueran.lyr on 2016/10/7.
 */
public class RMIClient {
    public final static void main(String args[]){
        String url = "rmi://localhost:8889/person";
        try {
            PersonService personService = (PersonService) Naming.lookup(url);
            System.out.println(personService.getName());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
