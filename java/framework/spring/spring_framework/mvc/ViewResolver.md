# 一 概述：
## (1)功能：
- 将控制器返回的逻辑视图的名称与org.springframework.web.servlet.View的实现相匹配.
- 返回名称方法：返回一个String、View对象或ModelAndView对象.
- DispatcherServlet会查找一个视图解析器来将控制器返回的逻辑视图名转化为渲染结果的实际视图.

## (2)spring自带多个视图解析器：
- BeanNameViewResolver：查找bean id与逻辑视图名称相同View的实现.
- InternalResourceViewResolver：在web应用程序等war包中查找视图模板，模板的路径根据视图名称加上前缀和后缀名称来确定.
- VelocityViewResolver：解析基于Velocity的视图，Velocity的模板名称根据视图名称加上前缀和后缀确定.
- VelocityLayoutViewResolver：VelocityViewResolver的子类，增加对VelocityLayoutView的支持.
- 等等.

## (3)备注：
- 两个重要接口：ViewResolver和View.
- 视图实现：JSP，Velocity和FreeMaker等.

## (4)ModelMap和ModuleAndView区别：
- ModuleAndView：model数据和view数据的持有者，可以通过返回一个该类对象直接返回model和view，可作为参数或在方法内自己创建.
- ModelMap：一个Map实现，创建前端使用的Model数据，需作为controller的参数，不能自己在函数内部创建.

## (5)重定向：
- 方法一：return "redirect:url"，注意使用时不能使用@ResponseBody.
- 方法二：return ModelAndView("redirect:url").
- 方法三：return RedirectView(url)
- 参数相关：RedirectAttributes

# 二 Velocity：
## (1)配置：
- VelocityConfigurer：配置Velocity，属性：configLocation，velocifyProperties和resourceLoaderPath.
- Resolver类：VelocityViewResolver，VelocityLayoutViewResolver等.