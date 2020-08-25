# 一 web service:
## (1)类型:
- **Service-oriented**: 面向服务的web应用实现一个web服务的终端, presentation-oriented通常是面向服务web应用的client. 例如: JAX-WS(Java API for XML Web Services)和JAX-RS(Java API for RESTful Web Services).
- **Presentation-oriented**: 面向表现层的web应用用来产生交互式web页面, 包含多种类型的标记语言(HTML, XML等等)和对请求响应的动态内容. 例如:JSF.

# 二 SOA:
## (1)概述:
- 面向服务架构(Service-oriented architecture): 服务通过网络使用一个交互协议来提供给其它组件, SOA可通过web service来实现.
- 服务间通过定义的接口交互, 接口是中立方式定义, 独立于硬件平台, os和编程语言.

## (2)特性:
- 逻辑上代表一种有特定输出的商业活动.
- 自包含.
- 对于它的消费者是黑盒的.
- 可能有其他的底层服务组成.

## (3)JAX-WS与JAX-RS：
- **JAX-WS**：use XML messages that follow the Simple Object Access Protocol (**SOAP**) standard, an XML language defining a message architecture and message formats.
- **JAX-RS**: provides the functionality for Representational State Transfer (RESTful) web services. **REST is well suited for basic, ad hoc integration scenarios.** RESTful web services, often better integrated with HTTP than SOAP-based services are, do not require XML messages or WSDL service–API definitions.