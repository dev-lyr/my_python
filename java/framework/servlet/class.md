# 一 ServletRequest:
## (1)功能:
- 定义一个可以为servlet提供**用户请求信息**的对象, servlet容器创建一个ServletRequest对象并把它作为参数传递给servlet的service方法.
- ServletRequest对象提供参数名字和值, 属性和一个输入流(input stream).
- 继承该接口的类提供和具体协议相关的数据, 例如:Http的HttpServletRequest.

## (2)常用方法:
- getReader: 使用BufferedReadered以字符方式读取请求的body.
- getInputStream: 使用ServletInputStream以二进制数据来接收请求body中的数据.

# 二 ServletResponse:
## (1)功能:
- 一个协助servlet发送响应信息给client的对象, Servlet容器创建一个ServletResponse对象并把它作为service方法的一个参数.
- 发送二进制的MIME响应时, 使用getOutputStream()函数返回的ServletOutputStream.
- 发送字符响应时, 使用getWriter返回的PrintWriter.