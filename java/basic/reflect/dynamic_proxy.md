# 一 概述：
## (1)相关类(java.lang.reflect)：
- Proxy类：提供创建代理类和实例的静态方法，同时是所有通过此种方法创建的代理类的父类.
- InvocationHandler接口：被proxy实例的调用处理程序(invocation handler)实现.
- ClassLoder抽象类：负责加载类，每个Class对象有一个指向定义的ClassLoader的引用.

## (2)备注：
- 其它代理实现：CGLIB.
- spring aop使用了这个代理或cglib来实现.
- JDK动态代理只能对实现了接口的类生成代理.

# 二 Proxy类：
## (1)功能：
- 提供创建动态代理类或代理类对象的static方法，同时还是通过这些方法创建的代理类的父类.

## (2)getProxyClass(ClassLoader loader, Class<?>...interfaces)：
- 返回一个给定了classloader和接口数组的代理类的Class对象.

## (2)newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)：
- 返回一个代理类的实例对象.

# 三 InvocationHandler接口：
## (1)功能：
- 每个代理对象的调用处理程序(invocation handler)需实现的接口.

## (2)invoke(Object proxy, Method method, Object[] args)：
- 处理代理对象的方法调用并返回结果.