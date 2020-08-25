# 一 概述： 
## (1)两种代理机制：
- 基于JDK 动态proxy(优先选择).
- 基于CGLIB(ASM)

## (2)设置：
- 若被代理的目标对象没有实现接口，则只能使用CGLIB.
- 使用proxy-target-class属性；默认为false使用JDK动态代理；设置为true则使用CGLIB代理.