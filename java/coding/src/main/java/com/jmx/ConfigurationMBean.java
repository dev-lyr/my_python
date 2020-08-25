package com.jmx;

/**
 * Created by yueran.lyr on 2016/10/7.
 */
public interface ConfigurationMBean {
    public void setMemory(int newMem);
    public int getMemory();
    public void setCpu(int newCpu);
    public int getCpu();
    public int test();
}
