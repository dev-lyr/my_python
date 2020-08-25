# 一 org.springframework.web.client:
## (1)RestTemplate:
- Spring's central class for **synchronous** client-side HTTP access.
- 简化了与Http服务器的通信, 并且强制使用RESTFul规则.

## (2)AsyncRestTemplate:
- Spring's central class for **asynchronous** client-side HTTP access.
- 与RestTemplate类似, 但是返回ListenableFuture封装而不是RestTemplate返回的具体结果.