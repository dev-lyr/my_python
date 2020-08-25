# 一 概述(org.springframework.web.servlet).
## (1)MVC：
- View视图
- Controller控制器
- Model模型

## (2)工作过程：
- Spring MVC的核心是DispatcherServlet，充当Spring MVC的前端控制器，请求离开浏览器后，将到达DispatcherServlet。
- 接着，DispatchServlet根据处理器映射(handler mapping, 请求携带的URL来决策)，将请求发送给相应的Spring MVC控制器(controller).
- 控制器在完成逻辑处理后通常需返回一些信息给用户在浏览器显示，这些信息称为模型(model)，还需返回视图名称给DispatcherServlet.
- DispatcherServlet使用视图解析器来根据视图名称匹配一个特定的视图实现.
- 知道哪个视图渲染结果后，DispathcerServlet向视图交付模型数据，视图将模型数据渲染输出。

## (3)备注：
- DispatcherServlet继承HttpServlet，在web.xml中配置.

# 二 配置:
## (1)web.xml(配置DispatcherServlet)：
- `<servlet-name>`：默认情况，DispatcherServlet会加载一个基于Servlet名字的xml文件来加载spring上下文，例如：servlet名字为spitter，则文件名为spitter-servlet.xml，可通过init-param配置contextConfigLocation来配置其它文件路径，默认路径为WEB-INF/spitter-servlet.xml.
- `<servlet-class>`：org.springframework.web.servlet.DispatcherServlet.

## (2)xxx-servlet.xml：
- `<mvc:resources>`：处理对静态资源的请求.
- `<mvc:interceptors>`：配置拦截器.
- `<mvc:annotation-driven/>`：结合注解使用.
- 备注：http://www.springframework.org/schema/mvc/spring-mvc.xsd

## (3)在web.xml中配置spring-context.xml：
- 应用级别：context-param和listenner(ContextLoaderListenner).

## (4)备注：
- contrller的bean需配置在xxx-servlet.xml中，其余的在spring-context.xml中.

# 三 相关注解:
## (1)综合:
- @Controller
- @RequestMapping

## (2)请求参数:
- @RequestParam：处理器方法参数是HTTP request 参数, RequestParam可以接收url中参数和post请求中form中的数据(content-type为application/x-www-form-urlencoded), 默认就是使用该注解, 因此若无需设置required属性则无需声明.
- @PathVariable: method argument to bind it to the value of a URI template variable.
- @RequestBody：处理器方法参数是HTTP request body的值.

## (3)响应参数:
- @ResponseBody：表示方法的返回类型直接被写到HTTP响应中(不存放在Model中，且不视图解析).
