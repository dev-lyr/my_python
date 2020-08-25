# 一 概述:
## (1)功能:
- 允许Java programming language agents to instrument programs running on the JVM, 可以用来监控和收集性能数据.
- The mechanism for instrumentation is modification of the byte-codes of methods, 通常在方法的字节码中插入额外的字节码来执行一些命令.

## (2)备注:
- java.lang.instrument包.

# 二 JavaAgent:
## (1)概述:
- Agent以jar包形式部署, jar包的manifest指定agent类, 该类会在启动agent时候被加载.
- Agent类实现: 包含指定的premain/agentmain方法的类就可以, 自己实现.

## (2)使用方式1(命令行接口):
- java -javaagent:jarpath[-options]: jarpath是agent jar包的路径, options是agent选项, 可指定多个agent.
- Agent Jar文件的manifest需包含熟悉Premain-class, 值是agent类的名字.
- Agent类必须实现一个public static premain方法, 在JVM初始化后, 每个premain方法会被按序调用, 然后应用的main方法才会被调用.

## (3)使用方式2(在JVM启动后启动Agents):
- Agent JAR文件必须包含属性Agent-Class, 值是agent类的名字.
- Agent类必须实现一个public staitc agentmain方法.
- 系统类loader必须支持添加Agent JAR文件到系统类路径.

## (4)备注:
- -agentlib和-agentpath选项: native agent库.
- JVMTI: https://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html

# 三 Instrumentation接口
## (1)功能:
- This class provides services needed to instrument Java programming language code.
- Instrumentation is the addition of byte-codes to methods for the purpose of gathering data to be utilized by tools. Since the changes are purely additive, these tools do not modify application state or behavior.
- Examples of such benign tools include monitoring agents, profilers, coverage analyzers, and event loggers.

## (2)获得Instrumentation对象方法:
- JVM启动时候指定Agent类, Instrumentation实例被传递给agent类的premain方法.
- 当Agent类在JVM启动后启动, Instrumentation对象呗传递给agent类的agentmain方法.

# 四 ClassFileTransformer接口:
## (1)概述:
- An agent provides an implementation of this interface in order to transform class files. The transformation occurs before the class is defined by the JVM.
- 通过Instrumentation的addTransformer方法注册.

## (2)transform方法:
- transform the supplied class file and return a new replacement class file.