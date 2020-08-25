# 一 概述： 
## (1)JVM版本：
- https://en.wikipedia.org/wiki/List_of_Java_virtual_machines
- 最佳实现：HotSpot.

## (2)规范：
- http://docs.oracle.com/javase/specs/index.html

## (3)Java编译器种类：
- 前端编译器(例如:javac)：把*.java转变为.class文件的过程.
- 后端编译器(JIT，just in time)：把字节码变为机器码的过程，例如hotspot c1、c2编译器.
- AOT编译器：直接把*.java变为机器码的过程，例如：ECJ.

## (4)备注：
- Javac编译器是由java程序实现的.
- Hotspot是使用C++实现的.
- JIT：将运行频率很高的字节码直接编译成机器指令执行来提高效率；即不用二次翻译.
- http://openjdk.java.net/

# 二 HotSpot：
## (1)概述：
- http://www.oracle.com/technetwork/articles/javase/index-jsp-136373.html.
- 实现了Java虚拟机规范.