# 一 组成： 
## (1)核心容器(core container)：
- 核心容器包括：Core、Beans、Context和Expression Language modules.
- Core和Bean提供Spring框架的基础部分，包括**控制反转(IoC)和依赖注入(DI)**.
- Context模块是在Core和Beans的基础上，提供了一种使用框架类型访问对象的方法，继承了Beans模块的特性，并增加了对以下功能的支持: 国际化、事件传递(event-programmatoc)、resource-loading等.

## (2)spring AOP模块：
- 提供面向切面的编程方法.
- AOP是对OOP的补充, 在OOP中关键的单元是类, 在AOP中是切面(aspect).
- 对面向切面编程提供了丰富的支持，与依赖注入一样，AOP可以帮助应用对象解耦.
- Aspects模块提供对AspectJ的集成.

## (3)数据访问：
- 数据访问包括：JDBC、ORM(Object-Relational Mapping)和事务模块.
- JDBC模块: 提供了一个JDBC的抽象层，避免了编写JDBC代码和解析数据库供应商的错误代码.
- ORM模块: 提供了对常用的ORM的支持，包括JPA、JDO、Hibernate和MyBatis等, spring没有自己的ORM解决方案.
- 事务模块：支持显式编程和基于注解的事务管理.

## (4)web和远程调用：
- web层包括：Web、Web-Servlet、Web-Struts和Web-Portlet模块.
- Web-Servlet模块: Spring MVC.
- Web-Structs模块: 在Spring应用中提供对Struts Web层的支持.
- spring远程服务调用还集成了RMI，Hessian等远程服务框架。

## (5)Test模块：
- Spring支持使用JUnit或TestNG进行测试，还支持mock对象功能.

## (6)集成模块:
- 使用Spring的远程服务和web服务
- EJB集成.
- JMS模块：提供了消息的产生和消费功能.
- JMX
- JCA CCI
- Email
- 任务的执行和调度
- 动态语言支持.
- cache抽象

# 二 控制反转(依赖注入):
## (1)背景:
- A Java application — a loose term that runs the gamut from constrained, embedded applications to n-tier, server-side enterprise applications — typically consists of objects that collaborate to form the application proper. Thus the objects in an application have dependencies on each other.
- Although the Java platform provides a wealth of application development functionality, it lacks the means to organize the basic building blocks into a coherent whole, leaving that task to architects and developers. Although you can use design patterns such as Factory, Abstract Factory, Builder, Decorator, and Service Locator to compose the various classes and object instances that make up an application, these patterns are simply that: best practices given a name, with a description of what the pattern does, where to apply it, the problems it addresses, and so forth. **Patterns are formalized best practices that you must implement yourself in your application.**
- The Spring Framework Inversion of Control (IoC) component addresses this concern by providing a formalized means of composing disparate components into a fully working application ready for use. The Spring Framework codifies formalized design patterns as first-class objects that you can integrate into your own application(s). Numerous organizations and institutions use the Spring Framework in this manner to engineer robust, maintainable applications.

## (2)IoC容器:
- In Spring, the objects that form the backbone of your application and that are managed by the **Spring IoC container** are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected in the configuration metadata used by a container.
- The interface **org.springframework.context.ApplicationContext** represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the aforementioned beans.
- The configuration metadata is represented in XML, Java annotations, or Java code. It allows you to express the objects that compose your application and the rich interdependencies between such objects.
