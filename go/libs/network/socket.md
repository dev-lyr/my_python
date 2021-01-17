# 一 概述:
## (1)概述:
- **net**: 为网络I/O提供一个可移植的接口, 包括: TCP/IP, UDP, 域名解析和unix域套接字.

# 二 相关函数:
## (1)net.Listen:
- 功能: Listen announces on the local network address.
- 格式: net.Listen(network, address string)(Listener,error). 
- 参数network: "tcp","tcp4","tcp6","unix","unixpacket".
- 参数address: network endpoint地址.
- 相关封装: ListenTCP, ListenUDP, ListenUnix等.

## (2)net.Dial:
- 功能: connects to the address on the named network.
- 格式: net.Dial(network, address string)(Conn,error) 
- 相关封装: DialTCP, DialUDP, DialUnix等.

# 三 socket:
## (1)相关类型:
- Listener(interface): a generic network listener for stream-oriented protocols, 实现: TCPListener,UnixListener等.
- Conn(interface): 一个常用的面向stream的网络连接, 实现: TCPConn,UDPConn,UnixConn等.
- Addr(interface): 表示network endpoint地址, 方法: Network,String.

## (2)Listener接口:
- Accept
- Addr
- Close

## (3)Conn接口:
- Read
- Write
- LocalAddr
- RemoteAddr
- SetDeadline
- SetReadDeadline
- SetWriteDeadline
- Close
