package com.jmx;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Created by yueran.lyr on 2016/10/7.
 * Connect MBeanServer
 */
public class Client {
    public static final void main(String []args){
        try {
            JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8888/server");
            JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceURL);
            MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();
            ObjectName objectName = new ObjectName("lyr:name=hello");
            ConfigurationMBean configurationMBean = MBeanServerInvocationHandler.newProxyInstance(mBeanServerConnection, objectName, ConfigurationMBean.class, false);
            System.out.println(configurationMBean.test());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }
}
