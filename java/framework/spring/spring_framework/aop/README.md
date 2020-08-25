# 一  相关概念： 
## (1)横切关注点(cross-cutting concerns)：
- 分布于应用中多处的功能被称为横切关注点，比如日志,事务,锁等。
- 与应用的业务逻辑相分离(但往往直接嵌入业务逻辑之中)。
- AOP要解决的就是讲横切关注点和业务逻辑相分离。

## (2)切面(aspect)：
- 切面是横切关注点的模块化表示，由`通知(Advice)和切点(PointCut)`的构成。
- Advice is associated with a pointcut expression and runs at any join point matched by the pointcut.
- Spring Aop只支持**方法连接点**，不支持构造器连接点，其它如AspectJ和Jboss同时还支持字段连接点和构造器连接点.
- 切面与类类似，只是关注点不一样，类是物体的抽象，切面是横切关注点的抽象。

## (3)代理实现机制：
- JDK动态代理(首选)
- CGLIB代理

## (4)常用AOP框架：
- AspectJ
- Spring AOP
- Jboss AOP

## (5)应用场景：
- 日志记录，性能统计，安全控制，权限管理，事务处理，异常处理，资源池管理.

# 二 切面相关术语：
## (1)Aspect(切面): 
- a modularization of a concern that cuts across multiple classes. 
- Transaction management(事务管理) is a good example of a crosscutting concern in enterprise Java applications. 

## (2)Join point(连接点): 
- 连接点：a point during the execution of a program, such as the execution of a method or the handling of an exception. 
- In Spring AOP, a join point always represents a method execution.
- 备注: 可通过Advice函数传递JointPoint参数的形式来获得连接点对象, 从而获得一些被拦截方法的信息.

## (3)Advice(通知): 
- 通知：action taken by an aspect at a particular join point. 
- Many AOP frameworks, including Spring, model an advice as an interceptor, maintaining a chain of interceptors around the join point.

## (4)Pointcut(切点): 
- 切点：a predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by the pointcut (for example, the execution of a method with a certain name). 
- The concept of join points as matched by pointcut expressions is central to AOP, and Spring uses the AspectJ pointcut expression language by default.

## (5)Introduction: 
- declaring additional methods or fields on behalf of a type. Spring AOP allows you to introduce new interfaces (and a corresponding implementation) to any advised object. For example, you could use an introduction to make a bean implement an IsModified interface, to simplify caching. (An introduction is known as an inter-type declaration in the AspectJ community.)

## (6)Target object: 
- object being advised by one or more aspects. Also referred to as the advised object. Since Spring AOP is implemented using runtime proxies, this object will always be a proxied object.
- AOP proxy: an object created by the AOP framework in order to implement the aspect contracts (advise method executions and so on). In the Spring Framework, an AOP proxy will be a JDK dynamic proxy or a CGLIB proxy.

## (7)Weaving: 
- linking aspects with other application types or objects to create an advised object. This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime.

# 三 通知的类型：
## (1)Before advice(aop:before): 
- Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).

## (2)After returning advice(aop:after-returning): 
- Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception.
 
## (3)After throwing advice(aop:after-throwing): 
- Advice to be executed if a method exits by throwing an exception.

## (4)After (finally) advice(aop:after): 
- Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).

## (5)Around advice(aop:around用的最多): 
- Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception.
- 环绕通知方法需要ProceedingJoinPoint作为方法入参，通知方法可以完成需要做的事情，然后调用ProceedingJoinPoint的proceed方法来将控制权转给被通知方法.
- 注意，必须调用ProceedingJoinPoint的proceed()方法，否则被通知方法不会被调用.