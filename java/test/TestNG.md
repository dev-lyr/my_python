# 一 概述:
## (1)功能:
- TestNG is a testing framework designed to simplify a broad range of testing needs, from unit testing (testing a class in isolation of the others) to integration testing (testing entire systems made of several classes, several packages and even several external frameworks, such as application servers).

## (2)执行测试的三个步骤:
- 首先使用TestNG注解标记需要测试的业务逻辑.
- 把需要测试的相关信息写入testng.xml(或build.xml),比如:类名,组等.
- 运行TestNG.

## (3)参考文档:
- http://testng.org/doc/documentation-main.html.

# 二 常用注解:
## (1)@Test:
- 功能：标记需要测试的类或方法，使用时候注意不要用成junit的Test注解了.
- dependsOnMethods属性：该方法执行时依赖其它测试方法先执行.
- 其它等等属性都很有用.

## (2)@BeforeTest/@AfterTest:
- 功能:被标记的方法将在该类中所有测试方法执行之前/所有方法执行完成后执行.

## (3)@AfterClass/@BeforeClass:
- 功能: 同上,不同之处:若没有测试方法则不执行被标记的方法.

## (4)@AfterMethod/@BeforeMethod:
- 功能：每个被测试方法执行前/后执行被标记方法.

## (5)@BeforeGroups和@AfterGroups

## (6)@BeforeSuite和@AfterSuite

## (7)@Parameters

## (8)@Listeners

# 三 testng.xml:
## (1)概述:
- DTD文件：http://testng.org/testng-1.0.dtd

# 四 执行TestNG:
## (1)命令行:
- java org.testng.TestNG testng1.xml [testng2.xml] ...

## (2)idea:
- http://testng.org/doc/idea.html.