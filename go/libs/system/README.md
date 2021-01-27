# 一 os:
## (1)概述:
- 提供一些平台独立(platform-independent)接口来操作系统功能, os接口可以通过一致的方式来访问所有操作系统.
- 备注: https://golang.google.cn/pkg/os/

## (2)子目录:
- exec: exec包用来执行外部命令.
- signal: 实现对进来信号的访问.
- user: 允许通过name或id来查询用户账号信息.

## (3)常量:

## (4)变量:
- os.Args: 一个slice.
- os.Stdin, os.Stdout, os.Stderr.
- 常用系统调用错误: ErrInvalid, ErrPermission, ErrExist, ErrNotExist, ErrClosed, ErrNoDeadline.

## (5)函数
- StartProcess

## (6)类型

# 二 runtime:
## (1)概述:
- runtime包提供与go runtime系统交互的操作, 比如:控制goroutine的函数.

## (2)环境变量

## (3)函数:
- GOMAXPROCS
- GCROOT
- GC

# 三 syscall
## (1)概述:

## (2)备注:
- https://godoc.org/golang.org/x/sys 

# 四 context
## (1)功能:
- Package context defines the Context type, which carries deadlines, cancelation signals, and other request-scoped values **across API boundaries and between processes**.
- 将Context显式作为参数传递给需要它的函数的, 通常是第一个参数且命名为ctx.
- 只有在需要request-scoped数据时候才使用context value. 
- 同一个context是线程安全的, 同一个context可传递给多个goroutines中的函数.

## (2)类型
- Context接口: 方法(Value(), Err(), Done(), Deadline()).
- cancelCtx(struct)
- timerCtx(struct)
- valueCtx(struct)
- CancalFunc类型: 让一个操作放弃工作, 不会等待工作结束, 可以被多个goroutines并行调用, 在第一个调用后的其它调用不做任何事情.

## (3)创建Context方式:
- Background: 返回一个非nil的空context, 该context不能被取消, 没有值和deadline, 通常用于main函数, 初始化, tests和请求进入时的顶层context.
- TODO: 返回一个非nil的空context, 当代码不清楚使用哪个context或者它不是可用时应以使用Context.TODO.
- (4)-(7)各种With创建parent的副本.
- background和todo: 底层都是一个emptyCtx.

## (4)WithCancel:
- 格式: WithCancel(parent Context)(ctx Context, cancel CancelFunc).
- 返回一个parent的副本, 该副本有一个新的Done channel. 
- Done channel close情况: 返回的cancel函数被调用; parent Done chennel被关闭.

## (5) WithDeadline
- 格式: WithDeadline(parent Context, d time.Time)(Context, CancelFunc)
- 返回一个带有一个deadline的parent context的副本, 若parent的context的deadline早于d, 则等同于parent.
- Done channel close情况: deadline到期; 返回的cancel函数被调用; parent Done chennel被关闭.

## (6) WithTimeout:
- 返回的是WithDeadline(parent, time.Now().Add(timeout)).

## (7)WithValue:
- WithValue(parent Context, key, val interface{}) Context: 返回一个parent的副本, 指定其中key关联的值.

## (8)备注:
- 取消该context会释放它关联的资源, 所有代码在该context中操作完成后就应该调用取消函数.
- The WithCancel, WithDeadline, and WithTimeout functions take a Context (the parent) and return a derived Context (the child) and a CancelFunc.
- 备注: https://golang.google.cn/src/context/context.go

# 五 time:
## (1)功能:
- 提供时间相关的功能,例如:sleep等.

## (2)函数:
- Sleep
- Tick
