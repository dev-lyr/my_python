# 一 概述:
## (1)背景:
- HTTP协议是无状态协议, 为了标记一个用户和存放用户相关信息, 需要很多session跟踪(tracing)技术用来识别用户.

## (2)session跟踪机制:
- Cookie: 最常用的session跟踪技术, 所有servlet容器都要求支持.
- SSL Sessions
- URL Rewriting

## (3)相关接口:
- javax.servlet.http.HttpSession
- javax.servlet.http.Cookie

## (4)相关实现:
- Jetty Session: https://www.eclipse.org/jetty/documentation/9.4.x/session-management.html
- Spring session: https://spring.io/projects/spring-session

## (5)备注:
- SSO
- token

# 二 cookie:
## (1)概述:
- cookie的值可以唯一标识一个client, 所以cookie通常用于session管理.
- servlet容器创建并将cookie发送给web浏览器保存, 浏览器随后发送回给servlet服务器.

## (2)属性:
- name
- value
- maxAge
- 等等.

## (3)相关方法:
- HttpServletResponse.addCookie: servlet用户发送cookie到浏览器.
- HttpServletRequest.getCookies: 获取cookie.

# 三 session affinity:
## (1)概述

## (2)实现:
- nginx: http://nginx.org/en/docs/http/ngx_http_upstream_module.html.
- k8s: https://kubernetes.io/docs/concepts/services-networking/service/

# 四 分布式共享:
## (1)概述

## (2)实现:
- 基于redis: Spring Session Data Redis.
- 基于DB或文件系统.
