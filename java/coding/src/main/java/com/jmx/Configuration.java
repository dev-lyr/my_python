package com.jmx;

/**
 * Created by yueran.lyr on 2016/10/7.
 */
public class Configuration implements ConfigurationMBean{
    private int memory;
    private int cpu;

    public void setMemory(int newMem) {
        memory = newMem;
    }

    public int getMemory() {
        System.out.println("get memory");
        return memory;
    }

    public void setCpu(int newCpu) {
        cpu = newCpu;
    }

    public int getCpu() {
        return cpu;
    }

    public int test(){
        System.out.println("test jmx");
        memory = 10;
        cpu = 10;
        return 100;
    }
}
