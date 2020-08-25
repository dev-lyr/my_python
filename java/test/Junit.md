# 一 概述:
## (1)参考:
- http://junit.org/

## (2)packages:
- org.junit包
- org.hamcrest包

# 二 org.junit包:
## (1)注解:
- **@Test**: 标记需要测试的方法.
- **@Before**: 每个测试方法被调用之前调用.
- **@After**: 每个测试方法调用后调用.
- **@BeforeClass**: 类中所有方法调用前调用，被注解的方法需为static.
- **@AfterClass**: 类中所有方法调用后调用，被注解.
- **@RunWith**: 代替Junit内在的执行类，例如：@RunWith(SpringJunit4ClassRunner.class).

## (2)断言:
- assertEquals
- assertTrue
- assertThat:结合org.hamcrest.Matcher使用,功能强大.

## (3)假设机制:
- 功能：在test中不满足条件则不会向下执行.

# 三 org.hamcrest包:
## (1)概述：
- hamcrest提供了一套匹配符的Matcher，结合assertThat，可以实现所有的测试.