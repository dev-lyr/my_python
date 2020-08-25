# 一 概述：
## (1)功能：
- 拦截请求，并对请求资源的ServletRequest或ServletResponse(控制响应)进行处理.
- 对HTTP请求、响应的内容或头部信息进行转换.
- 过滤器用于：登陆，加密和解密，会话检查，图片转换等待.
- 默认Servlet只给每一类过滤器创建一个实例，因此要处理好多线程访问的问题.

## (2)相关接口:
- Filter：所有过滤器必须实现的接口，提供了init，doFilter和destroy三个方法.
- FilterConfig：Filter配置类.
- FilterChain：过滤器链，一个资源可与多个过滤器关联.

## (3)使用方法：
- 注解：@WebFilter
- 部署描述符配置(web.xml)：若需要管理过滤器调用顺序，必须使用部署描述符，在web.xml声明顺序调用.

# 二 相关方法：
## (1)Filter接口：
- init：只调用一次，包含过滤器的初始化代码.
- doFilter：调用与过滤器相关资源时，Servlet容器会调用过滤器的doFilter方法，最后一行代码应是调用FilterChain的doChain方法，若没在doFilter中调用FilterChain.doFilter方法，那么程序处理会停在这里，并且不会处理请求.
- destroy：过滤器即将终止服务之前，由Servlet容器调用.

## (2)FilterChain接口：
- doFilter：引发调用链中下一个过滤器被调用；若是链中最后一个元素调用则资源本身会被调用.