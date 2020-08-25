# 一 概述:
## (1)名词:
- Servlet：a Java technology-based Web component, managed by a container, that generates dynamic content.
- Servlet Container：a part of Web server or appilication server that provides the network services over which requests and responses are sent, decodes MIME-based requests, and formats MIME-based response. A servlet container also contains and manager servlets through their lifecycle.
- JSP(JavaServer Pages)：a jee technology for building applications dynamic web content.

## (2)参考文档：
- http://www.oracle.com/technetwork/java/javaee/tech/index.html.

## (3)Servlet和JSP关系:
- JSP其实就是一个Servlet，第一次请求JSP时，Servlet/JSP容器将JSP页面转换为一个JSP页面实现类(Servlet)并编译该类。
- 区别：JSP页面不用编译；一般扩展名为.jsp；不用在部署描述符(web.xml)中标注和映射，可以在浏览器直接输入页面路径来调用。

# 二 servlet并发问题：
## (1)两种servlet模式:
- Single Thread Model：servlet类需实现SingleThreadModel接口，这种模式下会为每个请求创建一个servlet实例，已废弃，不建议使用，开销太大.
- Multi Thread Model：默认模式，只有一个servlet实例会被创建，这个实例会为所有连接服务.

## (2)解决Multi Thread Model并发问题的方法：
- 继承SingleThreadModel接口，不推荐.
- 同步对共享数据的操作，严重影响性能.
- 避免使用实例变量或static成员是最佳选择：推荐.

## (3)备注：
- log4j是线程安全的.