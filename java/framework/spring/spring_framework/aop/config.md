# 一 使用方式：
## (1)基于xml配置方式:
- `<aop:config>...</aop:config>`
- http://www.springframework.org/schema/aop/spring-aop-4.1.xsd

## (2)基于注解方式(需<aop:aspectj-autoproxy/>开启):
- @Aspect：声明一个切面.
- 5种通知：@Before、@AfterReturnning、@AfterThrowing、@After、@Around.
- 切点：@Pointcut.
- https://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/overview-summary.html

## (3)JoinPoint:
- https://www.eclipse.org/aspectj/doc/next/progguide/index.html

## (4)备注:
- https://www.eclipse.org/aspectj/sample-code.html#library-pointcutIdioms

# 二 xml配置元素：
## (1)<aop:config>：
- 顶层的AOP配置元素，大多数<aop:*>包含在<aop:config>中.

## (2)<aop:aspect>：
- 定义切面.

## (3)<aop:pointcut>：
- 定义切点.

## (4)通知相关：
- <aop:before>
- <aop:around>
- <aop:after>：定义AOP后置通知，不管被执行方法是否执行成功.
- <aop:after-returning>
- <aop:after-throwing>

# 三 注解:
## (1)概述:
- 注解是AspectJ的注解, http://www.eclipse.org/aspectj/.

## (2)@Aspect:
- 属性value:  默认为"".
- 切面(使用@Aspect注解的类)可以和其它类一样, 包含属性和方法; 也可以包含pointcut, advice.

## (3)@Pointcut:
- 属性value: 切点表达式, 允许""作为默认值表示抽象的切点.
- 属性argNames.

## (4)@After:
- 功能: 无论方法如何退出(正常结束, 异常退出等)都会执行.
- 属性value: 绑定到通知的切点表达式.
- 属性argNames.

## (5)@AfterReturning:
- 功能: after return advice.
- 属性pointcut: 绑定到通知的切点表达式, 若指定则忽略value.
- 属性value: 绑定到通知的切点表达式.
- 属性returning: advice signature中的绑定返回值的参数的名字.
- 属性argNames.

## (6)@AfterThrowing:
- 功能: after throwing advice.
- 属性pointcut: 绑定到通知的切点表达式, 若指定则忽略value.
- 属性value: 绑定到通知的切点表达式.
- 属性returning: advice signature中的绑定抛出异常的参数的名字.
- 属性argNames.

## (7)@Before:
- 功能: before advice.
- 属性value: 绑定到通知的切点表达式.
- 属性argNames.

## (8)@Around:
- 功能: Around advice.
- 属性value: 绑定到通知的切点表达式.
- 属性argNames.

## 四 切点表达式：
## (1)备注：
- spring借助Aspect的切点表达式.

## (2)Aspect指示器：
- execution()：匹配是连接点.
- arg()：限制连接点匹配参数为指定类型
- @args()：限制连接点匹配参数由指定注解标注
- this()：限制连接点匹配AOP代理的Bean引用为指定类型
- target()：限制连接点匹配目标对象为指定类型
- @target()：限制匹配连接点匹配执行的特定对象，这些对象对于的类具备指定类型的注解
- within()：限制连接点配置指定的类型
- @within()：限制连接点匹配指定注解所标准的类型
- annotation：限制匹配带有指定注解的连接点，即带有指定注解的函数的指定才会执行aop.

# 五 选择:
## (1)Spring AOP或AspectJ(功能齐全):
- Spring AOP比AspectJ简单, 若只需advise Spring beans的执行, 则Spring AOP是正确的选择.
- 若需要advise不是Spring容器管理的对象, 则需要使用AspectJ.
- 若需要advice的join point不仅仅是简单方法的执行(例如:属性的set方法等), 则需要AspectJ.

## (2)注解或XML文件:
- 若不能使用Java 5+, 则xml是合适的选择.
- 当AOP作为一个配置企业服务的工具时, XML是更好的选择; XML格式更为清晰.
- 注解: 支持更丰富的pointcut组合; 支持额外的instantiation models(默认, 每个aspect是单例模式).
- 建议: 优先使用注解.