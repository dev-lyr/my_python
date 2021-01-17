# 一 概述:
## (1)概述:
- **net**: 为网络I/O提供一个可移植的接口, 包括: TCP/IP, UDP, 域名解析和unix域套接字.
- **net/http**: 提供HTTP client和server的实现.
- **net/rpc**: provides access to the exported methods of an object across a network or other I/O connection, 该包已冻结, 不接收新需求.
- url
- mail
- smtp
- textproto

## (2)第三方web库:
- gin: https://github.com/gin-gonic/gin
- iris: https://github.com/kataras/iris
- beego: https://github.com/astaxie/beego

# 二 url:
## (1)概述:
- parses URLs and implements query escaping.

## (2)类型:
- URL(struct):
- Value(struct): Values maps a string key to a list of values, 通常表示一个查询参数和form值.

## (3)函数:
- PathEscape
- PathUnescape
- QueryEscape
- QueryUnescape
- Parse
