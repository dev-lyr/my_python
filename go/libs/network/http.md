# 一 概述:

# 二 net.http:
## (1)相关类型:
- Handler(interface): 响应http请求, 用于ListenAndServe函数.
- Request(struct): 表示一个http请求, 可通过http.NewRequest创建.
- ResponseWriter(interface): 被Http handler用于构造response.
- Client(struct): 一个http client, 提供一个DefaultClient作为默认值, http.Get使用的就是DefaultClient, 当需要配置header或其他配置时需创建一个Client.
- Server(struct): 一个http server, 提供一个

## (2)封装的函数:
- http.ListenAndServe(服务端)
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

## (4)Server:
- ListenAndServe
- ListenAndServeTLS
- 备注: 需更多自定义则创建Server对象.
