# 一 概述：
## (1)网址：
- http://hc.apache.org/

## (2)组成部分：
- HttpComponents Core
- HttpComponents Client(HttpClient)
- HttpComponents AsyncClient
- Commons HttpClient(遗留):建议使用HttpClient.

## (3)备注:
- demo: http://hc.apache.org/httpcomponents-client-ga/quickstart.html.
- demo: http://hc.apache.org/httpcomponents-asyncclient-dev/quickstart.html.

# 二 HttpCore:
## (1)概述:
- a set of low level HTTP transport components that can be used to build custom client and server side HTTP services with a minimal footprint. 
- HttpCore supports **two I/O models:** **blocking I/O** model based on the classic Java I/O and **non-blocking, event driven I/O** model based on Java NIO.
- The **blocking I/O** model may be more appropriate for **data intensive, low latency scenarios**, whereas the **non-blocking model** may be more appropriate for **high latency scenarios where raw data throughput is less important than the ability to handle thousands of simultaneous HTTP connections in a resource efficient manner**.

# 三 HttpClient:
## (1)概述:
- a HTTP/1.1 compliant HTTP agent implementation based on HttpCore.
- It also provides reusable components for **client-side authentication**, **HTTP state management**, and **HTTP connection management.**
- 备注: https://hc.apache.org/httpcomponents-client-ga/tutorial/html/index.html

## (2) HttpClient相关类:
- HttpClient接口: 基本的Http请求执行的约定.
- HttpClients: CloseableHttpClient实例的工厂类, 用来创建HttpClient, 底层是对HttpClientBuilder的封装.
- HttpClientBuilder: CloseableHttpClient实例的生成器, 可配置连接管理器等熟悉.
- HttpClient实例是被多**个线程**使用的, 维护者连接池等资源.

## (3)方法类:
- HttpGet, HttpPost, HttpPut等, 顶层都是HttpRequest接口.
- 其中HttpPost,HttpPut继承HttpEntityEnclosingRequestBase, 表示可以带实体(entity)的请求.
- 备注: HttpXXX.addHeader来增加头部字段, 其中core的HTTP类定义了头部字段的常量.


## (4)实体(HttpEntity):
- HttpEntity: 在HTTP message中发送和接收, 可选.
- UrlEncodedFormEntity:表示包含url-encoded对列表的实体(form表单), 通常用来HTTP POST请求, 适用于content-type为:application/x-www-form-urlencoded(实现代码里已写死), 无需额外指定header.
- StringEntity: 包含字符串的实体, 发送json时, 需指定content-type为application/json, 默认为text/plain.
- 备注: ContentType类提供常用ContentType.

## (5)响应(CloseableHttpResponse):
- 扩展HttpResponse并extends Closeable, 可以获得状态码、实体等, 通过EntityUtils.consume消费实体, 并且执行完需调用close方法.
- 备注: 在HttpClient.execute方法中也可以指定ReponseHandler作为处理类, 例如: BasicResponseHandler当成功时(2xx)时以字符串方式返回响应body,当返回码>=300时抛出HttpResponseException.

## (6)连接管理(HttpClientConnectionManager):
- 功能: 新Http连接的创建工厂, 管理持久连接, 同步对持久连接的访问保证同一时刻只有一个执行线程可以访问一个连接.
- BasicHttpClientConnectionManager: 单个连接的管理器, 只维护一个活跃连接.
- PoolingHttpClientConnectionManager: 维护一个HttpClientConnections池, 服务多个线程的连接请求, 链接是根据route来pool的, 访问一个route时从pool中释放一个可用的, 若没有则新建. 包含两类最大限制:一个route的限制和全部的限制, 默认每个route会创建不超过2个的连接, 总共不超过20个连接, 对于生产环境的应用数量太小, 需配置.
- **注意: 新版client的HttpXXX方法的releaseConnection以及响应类对象的close都是将连接丢弃, 而不是放回连接池; 正确的放回连接池是使用将响应body的entity的InputStream close掉(老版client的releaseConnection采用这种方法), 一些BasicResponseHandler类就是这么做, 所以使用ResponseHandler类则不用关心连接放回连接池的问题.**

## (7)其它:
- URIBuilder:  Builder for URI instances.

# 四 AsyncClient:
## (1)概述:
- a HTTP/1.1 compliant HTTP agent implementation based on **HttpCore NIO** and HttpClient components. 
- It is a complementary module to Apache HttpClient intended for special cases where ability to handle a great number of concurrent connections is more important than performance in terms of a raw data throughput.

## (2)HttpAsyncClient类
