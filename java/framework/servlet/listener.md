# 一 概述：
## (1)功能：
- 支持**事件**驱动编程，Servlet提供了一整套事件类和监听器接口.

## (2)监听器的三个级别：
- ServletContext
- HttpSession
- ServletRequest

## (3)使用方法：
- 注解：@WebListener
- 部署描述符(web.xml)

## (4)备注:
- 参考servlet手册Application Lifecycle Events.

# 二 Listener的配置:
## (1)概述:
- 开发者通过实行Servlet API中定义的Listener接口来提供不同类型的监听类.
- Listener类在web.xml中通过listener元素来声明.
- Web容器(例如jetty)创建和注册(依据在web.xml中的声明顺序)每个listener类的实例来等待事件通知, 该操作在应用的处理第一个请求之前. 
- 在应用运行时, 事件的根据注册顺序来通知listener.
- 在应用关闭时, listener以注册顺序的逆序来通知listener.
- 容器维持到每个listener实例的引用, 直至web应用执行完最后一个请求.

# 三 Servlet Context监听器：
## (1)两个监听接口:
- ServletContextListener
- ServletContextAttributeListener

# 四 Session监听器：
## (1)4个监听器接口：
- HttpSessionListener
- HttpSessionActivationListener
- HttpSessionAttributeListener
- HttpSessionBindingListener

# 五 ServletRequest监听器：
## (1)3个监听接口：
- ServletRequestListener
- ServletRequestAttributeListener
- AsyncListener