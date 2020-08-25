# 一  IoC容器(又称DI): 
## (1)概述：
- beans和context包是Spring IoC容器的基本包.
- Bean工厂(BeanFactory)：最简单容器，提供基本DI支持，过于低级别; 应用上下文(ApplicationContext)：基于Bean工厂实现，提供更丰富功能，建议使用.
- ApplicationContext接口代表偶一个IoC容器，负责实例化、配置和组装beans.

## (2)备注：
- 在容器中，用一个BeanDefinition对象代表一个bean的定义.
- 在一个容器中bean的标识符必须唯一.
- 默认bean是在IoC容器启动时候创建bean实例，可将bean配置为lazy-initialized，此时在首次请求该对象时才创建.

# 二 依赖注入(DI)： 
## (1)概述： 
- 依赖注入：对象定义自己的依赖(其它对象)，通过构造函数参数、属性的setter方法或工厂方法参数.
- IoC容器创建对象时注入对象的相关依赖.

## (2)依赖注入的两种方式：
- 基于构造函数的依赖注入.
- 基于setter的依赖注入.

# 二 ApplicationContext:
## (1)功能:
- 访问应用组件(components)的Bean工厂方法, 继承自ListableBeanFactory.
- 以指定格式加载文件资源, 继承自ResourceLoader接口.
- 向注册的listeners发布时间, 继承自ApplicationEventPublisher接口.
- 解析messages, 支持国际化, 继承自MessageSource.
- 除了标准BeanFactory生命周期(Lifecycle), ApplicationContext会检测和调用ApplicationContextAware Beans.

## (2)常用子类:
- ClassPathXmlApplicationContext: 从类路径下的XML配置文件中加载上下文。
- FileSystemXmlApplicationContext: 读取文件系统中的xml文件作为配置文件并加载上下文。
- XmlApplicationContext: 读取Web应用下的XML配合文件并加载上下文定义。
- WebApplicationContextUtils: Convenience methods for retrieving the root WebApplicationContext for a given ServletContext.

## (3)AbstractAllicationContext.refresh:
- spring启动时的初始化函数.

# 三 相关问题汇总:
## (1)循环依赖:
- 使用构造函数和set方法相结合的注入方式也可以解决循环依赖.