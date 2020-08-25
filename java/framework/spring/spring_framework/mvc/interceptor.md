# 一 拦截器：
## (1)概述：
- 允许用户自定义handler执行链，应用可以针对特定的handler注册一些拦截器，可以在不修改每个handler实现的基础上增加一些预处理能力.

## (2)实现方法：
- handler mapping中使用的拦截器(interceptor)必须实现HandlerInterceptor接口.
- HandlerInterceptorAdapter：抽象类，提供pre-only或post-only拦截器的简单实现.

## (3)方法：
- preHandler：handler执行的拦截器，在HandlerMapping映射到handler对象之后，和HandlerAdapter调用该handler之前.
- postHandler：handler执行的拦截器，在HandlerAdapter调用handler之后，但在DispatcherServlet触发view之前.
- afterCompletion：在整个请求完成后调用.

# 二 用法：
## (1)概述：
- 应用可以注册一些已存在的或者用户自定义的拦截器到指定hanlers中，可以在不改变handler实现的前提下增加一些公共预处理行为.

## (2)两种配置方式：
- 方式1：在xxx-servlet.xml中配置<mvc:interceptors>...</mvc:interceptors>, 可以指定某些url请求使用该拦截器.
- 方式2：直接声明两个bean(RequestMappingHandlerAdapter和RequestMappingHandlerMapping)，然后配置interceptors属性.

# 三 Interceptor和Filter(Servlet)：
## (1)相同点：
- 有点类似，但Filter功能更强大.

## (2)不同点：
- HandlerInterceptor是在application context中配置(例如：xxx-servlet.xml)；filter是在web.xml中配置.
- interceptor是基于Java反射实现，filter是基于函数回调.
- interceptor只对action起作用，可以访问action的上下文；filter可以对所有请求起作用.
- interceptor可以在action的生命周期内被多次调用；filter只能在容器初始化时被初始化一次.
- interceptor就是在调用某个方法前或后调用一个方法；filter就是传入的request或response前过滤掉一些信息，或设置一些参数，然后再传入servlet的action进行业务逻辑处理.

## (3)使用经验(选自spring api文档)：
- Fine-grained handler-related preprocessing tasks are candidates for HandlerInterceptor implementations, especially factored-out common handler code and authorization checks.
- A Filter is well-suited for request content and view content handling, like multipart forms and GZIP compression. This typically shows when one needs to map the filter to certain content types (e.g. images), or to all requests.