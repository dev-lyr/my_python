# 一 处理器映射(HandlerMapping)：
## (1)概述：
- spring自带多个处理器映射，均继承HandlerMapping接口.
- BeanNameUrlHandlerMappping和DefaultAnnotationHandlerMapping是默认的.

## (2)两种使用方法：
- 只需在xxx-servelt.xml中配置一个bean；若没有配置，DispatcherServlet将创建并使用BeanNameUrlHandlerMapping和DefaultAnnotationHandlerMapping(3.2后使用RequestMappingHandlerMapping).
- 在xxx-servlet.xml中直接使用<mvc:annotation-driven/>.


# 二 控制器(controller)：
## (1)功能：
- 逻辑处理完后需返回数据(model)和视图名称给DispatcherServlet.

## (2)两种使用方法：
- RequestMappingHandlerAdapter和RequestMappingHandlerMapping配合使用.
- 在xxx-servlet.xml中直接使用<mvc:annotation-driven/>.

## (3)HTTP Message Conversion:
- StringHttpMessageConverter.
- MappingJackson2HttpMessageConverter.
- 等等.