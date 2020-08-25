# 一 概述:
## (1)相关包：
- mockit：classes and annotations used when writing tests with the Jmockit mocking APIs.
- mockit.integration.junit4：integration with Junit4.x test runners, for version4.5 or newer. 

## (2)相关注解：
- @Tested
- @Mocked
- @Injectable
- @Capturing
- @Mock

## (3)mock工具的原理：
- record阶段(Expectations)：录制期望，即数据准备阶段.
- replay阶段：调用被测代码，执行测试.
- verify阶段(Verifications)：验证阶段.

## (4)备注:
- http://jmockit.github.io/

# 二 常用注解：
## (1)三个mock属性或参数的注解:
- **@Mocked**: 用来mock一个测试类的属性域、测试方法的参数; mock all methods and constructors on all existing and future instances of a mocked class, 备注：默认情况下@mocked会将对象的所有的方法都mock掉.
- **@Injectable**: constrains mocking to the instance methods of a single mocked instance, 并会注入到@Tested的对象.
- **@Capturing**: extends mocking to the classes implementing a mocked interface, or the subclasses extending a mocked class.

## (2)@Tested:
- 测试类中带有@Tested的非final实例属性(被测试类)需要在测试方法执行之前被**实例化**(instantiation)和**注入**(injection).
- 为了向被测试类的对象**注入**mocked的实例, 测试类必须包含一个或多个@Injectable的属性或参数(用在测试方法上), @Mocked和@Capturing不是注入.

## (3)@Mock：
- 在mock-up类中使用，用临时mock方法替换真正的方法.
- 要求：mock的方法必须和真实方法具有相同名字、参数和返回类型.

# 三 录制(Expectations):
## (1)Expectations的类型：
- Expectations：Expecations中录制的方法至少调用一次(除非指定不用调用)，否则会导致MissingInvocation异常.
- StrictExpectations：在replay过程中，调用必须满足要求的顺序和调用数量，否则导致UnexpectedInvocation异常，不能使用Verification进行验证.
- NonStrictExpectations(已废弃)：record non-strict expectations on mocked types and their instances.

## (2)Expectations使用方法1(@Mocked + Expectations):
- `@Mocked A a;`
- `new Expectations(a){{`
- `a.method1; result="test";//可指定返回值、执行次数等条件.`
- `}};`
- 备注:此种录制方法，对象a中其它方法都被@Mocked注解mock掉了，因此只有method1使用的是录制的实现.

## (3)Expectations使用方法2：
- `A a = new A();`
- `new Expectations(a) {{`
- `a.method1; result="test";//可指定返回值、执行次数等条件.`
- `}};`
- 备注：此种录制方法，对象a中其它方法任然是原来的实现，method1使用的是录制的实现.

## (4)使用MockUp：
- `A a = new AImpl();`
- `new MockUp(T) {`
- `@Mock`
- `public void method1(){}`
- `};`
- 备注：method1是录制的实现，其它方法还是原始实现，不能和@Mocked搭配使用.

## (5)备注:
- 可在expectation或verification块使用anyXXX属性或withXXX(...)方法来进行参数的模糊匹配.

# 四 Verifications：
## (1)功能：
- 用来验证实际测试过程的行为是否满足录制时的要求，比如执行顺序和执行次数等，verifications出现只能在测试执行完后出现.
- StrictExpectations不能使用Verifications.
- 这个功能用的不多，暂不介绍.