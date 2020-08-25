# 一 部署脚本(/WEB-INF/web.xml)：
## (1)包含元素(web-app是web.xml的root，以下包含在web-app内)：
- ServletContext初始化参数
- Session配置.
- Servlet声明
- Servlet映射(Mappings)
- JSP相关配置：jsp-config
- Application Lifecyle Listener类
- Filter定义和Filter映射
- MIME Type Mappings
- Welcome File list
- Error Pages
- Locale and Encoding Mappings
- Security配置：包括login配置, security-contraint, security-role, security-role-ref 和run as.

## (2)Servlet和Servlet Mapping：
- `<servlet>...</servlet>`：声明一个servlet.
- `<servlet-mapping>...</servlet-mapping>`：定义一个servlet和url patern的映射.

## (3)Filter和Filter-Mapping：
- `<filter>...</filter>`：声明一个filter，filter实现javax.servlet.Filter接口.
- `<filter-mapping>...</filter-mapping>`：container用来决定filter如何应用到一个request.

## (4)Listener：
- `<listener>...</listener>`：indicates the deployment properties for an application listener bean.

## (5)context-params(Servlet Context初始化参数)：
- `<context-param>...</context-param>(应用级别)`：contains the declaration of a Web application’s servlet context initialization parameters.
- Javax.servlet.ServletContext提供了getInitParameter和getInitParameterNamers来获取这些初始化参数.

## (6)web应用部署到容器在接收请求之前需要做的: 
- Instantiate an instance of each event listener identified by a <listener> element in the deployment descriptor.
- For instantiated listener instances that implement ServletContextListener, call the contextInitialized() method.
- Instantiate an instance of each filter identified by a <filter> element in the deployment descriptor and call each filter instance’s init() method.
- Instantiate an instance of each servlet identified by a <servlet> element that includes a <load-on-startup> element in the order defined by the load-on- startup element values, and call each servlet instance’s init() method.

## (7)备注:
- 详见servlet手册.

# 二 Servlet元素：
## (1)init-param(servlet级别)：
- 只能在servlet的init方法中使用，通过this.getInitParameter来获取值.
- 注意与context-params区别.