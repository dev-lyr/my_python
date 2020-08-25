# 一 概述:
## (1)概述:
- **net**: 为网络I/O提供一个可移植的接口, 包括: TCP/IP, UDP, 域名解析和unix域套接字.

## (2)子目录:
- http
- rpc
- url
- mail
- smtp
- textproto

## (3)第三方web库:
- gin: https://github.com/gin-gonic/gin
- iris: https://github.com/kataras/iris
- beego: https://github.com/astaxie/beego

# 二 http:
## (1)相关类型:
- Handler(interface): 响应http请求, 用于ListenAndServe函数.
- Request(struct): 表示一个http请求, 可通过http.NewRequest创建.
- ResponseWriter(interface): 被Http handler用于构造response.
- Client: 一个http client, 提供一个DefaultClient作为默认值, http.Get使用的就是DefaultClient, 当需要配置header或其他配置时需创建一个Client.

## (2)相关函数:
- http.ListenAndServe
- http.Get
- http.Post
- http.PostForm
- http.NewRequest

## (3)Client:
- Get
- Post
- PostForm
- Do
- 备注: 需自定义header则使用NewRequest和Do.

# 三 socket:
## (1)相关类型:
- Listener(interface): 方法Accept, Close, Addr.
- Addr(interface): 表示network endpoint地址, 方法: Network,String.
- Conn(interface): 一个常用的面向stream的网络连接.

## (2)相关函数:
- net.Listen(network, address string)(Listener,error): network("tcp","tcp4","tcp6","unix","unixpacket"),address(network endpoint地址.

# 四 url:
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
