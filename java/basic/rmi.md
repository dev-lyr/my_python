# 一 概述： 
## (1)功能：
- 远程方法调用.

## (2)与rpc区别：
- rpc基于c是过程化编程语法，只能调用暴漏在serever上的方法.
- rmi基于java是面向对象的，通过远程对象的引用调用它们的方法.
- 备注：都是用来调用其它机器上的方法.

# 二 服务端： 
## (1)相关接口和类：
- Remote接口：标示接口，所有远程对象必须实现该接口，只有这样对象的方法才是可见的.
- 自定义的调用类：需实现Remote接口，可使用一些包装类如：UnicastRemoteObject类.
- LocationRegistry类.
- Naming类.

# 三 客户端： 
## (1)相关类：
- Naming类.
