# 一 JMX(Java Management Extensions)： 
## (1)功能：
- 提供一种**远程访问**管理接口的标准措施.
- 查看和改变应用的**配置**.
- 对系统运行情况进行**监控**.
- 通知状态**改变**等信息.

## (2)相关包: 
- java.lang.management
- javax.management

## (3)组成：
- MBean.
- MBean Server.

# 二 MBean： 
## (1)功能：
- MBean必须注册到一个MBean Server才能使用.
- JDK提供一些内部实现的MBean, 一些应用也提供了自定义的MBean给客户使用, 例如:kafka等.

## (2)类型：
- 标准MBeans.
- MXBeans.
- Dynamic MBeans.
- Open MBeans.
- Model MBeans.

## (3)创建MBean的两种方法：
- 创建一个接口，名字为"类名+MBean"，然后创建一个类实现该接口.
- 使用StandardMBean类.

## (3)生命周期： 
- MBean可以实现MBeanRegistration接口来记录注册和解绑MBean Server的时间.

## (4)Notifications.

# 三 MBean Server： 
## (1)功能：
- MBean Server是MBean的仓库，MBean只有被注册到MBean Server时才有用, 通常只通过MBean Server来访问MBean.
- 每个MBean在MBean Server中有一个唯一的名字，该名字通过ObjectName类来定义, 提供这个名字给MBean Server来访问MBean.
- MBean Server是一个实现了MBeanServer接口的对象, 使用MBean Server最方便的方式是使用Platform MBean Server，该MBean Server被同一个JVM中运行的不同的管理组件共享，访问方法为ManagementFactory.getPlatformMBeanServer().
- 应用也可以通过MBeanServerFactory创建一个MBean Server或访问一个已经创建的MBean Server.

## (2)在MBean Server中创建MBeans的两种方法：
- 创建一个MBean对象，然后使用registerMBean方法注册到MBean Server：只适用于本地，不能远程使用.
- 使用createMBean方法，可以远程使用，但是有时需要关注类加载的问题.

## (3)远程访问MBeans：
- 应用可以使用一个connector(javax.management.remote.JMXConnector)来远程访问MBean Server，就像本地一样.

