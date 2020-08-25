# 一 概述：
## (1)备注：
- Struts在web.xml中定义FilterDispatcher，该类初始化Struts框架和处理所有请求.
- Struts的核心控制器设计为Filter而不是Servlet.

## (2)例子：

<web-app id="WebApp_9" version="2.4"
    xmlns="http://java.sun.com/xml/ns/j2ee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">

    <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.filter.ng.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- ... -->
</web-app>

# 二 StructsPrepareAndExecuteFilter类：
## (1)功能：
- Handles both the preparation and execution phases of the Struts dispatching process.
- 放到所有filter的最后.