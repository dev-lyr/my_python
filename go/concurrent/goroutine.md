# 一 概述:
## (1)概述:
- 在go中每个并发执行的单元称为: **goroutine**, 当程序启动时, 之后一个goroutine来调用main函数, 称为主goroutine.
- 新的goroutine通过go语句创建, **语法: go 方法/函数**.
- 当从main函数返回, 所有goroutine都暴力的直接终结, 然后程序直接退出.
- Goroutines are multiplexed onto multiple OS threads so if one should block, such as while waiting for I/O, others continue to run. 
- Goroutines不是协程, **M个Goroutines对应系统上N个线程**.

## (2)go语句:
- A "go" statement starts the execution of a function call as an independent concurrent thread of control, or goroutine, within the same address space.

## (3)相关配置:
- **GOMAXPROCS**: limits the number of operating system threads that can execute user-level Go code simultaneously, 可通过runtime.GOMAXPROCS来设置或查询.

## (4)停止方法:
- 自己终止: 例如,执行完或者外界和它通信让它终止(使用channel).
- main函数返回: 所有goroutine直接终止.
- 程序退出.

## (5)goroutine与线程:
- 线程由kernel调度, go运行时有自己的调度器来调度Goroutine, 不需要进入内核态, 因此调度成本小很多.
- 线程有特殊标识, 一个整数或指针, 可用于构建线程的局部存储; goroutine没有程序员可访问的标识, go鼓励影响函数的参数应当显式指定.

## (6)相关:
- https://golang.org/pkg/runtime/debug/#SetMaxThreads
