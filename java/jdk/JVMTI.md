# 一 概述:
## (1)功能:
- JVM Tool Interface: 是一个被部署和监控工具使用的编程接口, 提供一种检测状态和控制JVM中应用执行的途径.
- 可用来profiling, debugging, monitoring, thread analysis和coverage analysis等.

## (2)架构:
- JVM TI is a two-way interface. A client of JVM TI, hereafter called an **agent**, can be notified of interesting occurrences through **events**. JVM TI can query and control the application through many **functions**, either in response to events or independent of them.
- Agents run in the **same process** with and communicate directly with the virtual machine executing the application being examined. This communication is through a **native interface** (JVM TI). The native in-process interface allows maximal control with minimal intrusion on the part of a tool. Typically, agents are relatively compact. They can be controlled by a separate process which implements the bulk of a tool's function without interfering with the target application's normal execution.

## (3)备注:
- https://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html
- java.lang.instrument: 用来实现Java语言版agent.