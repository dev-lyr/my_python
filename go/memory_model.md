# 一 概述:
## (1)概述:
- Go内存模型指出在一个goroutine中读取一个变量时保证可以看到同一变量在其它goroutine中写入值的条件.
- 程序修改的数据被其它goroutines并行访问时必须串行化访问.
- 为了串行化访问, 可通过**channel操作**或**其他同步原语(例如:sync和sync/atomic)包来保护数据.

## (2)备注:
- https://golang.org/ref/mem
- https://en.wikipedia.org/wiki/Happened-before

# 二 Happened-Before:
## (1)概述:
- 在不改变语言规范定义的行为情况下, 编译器和处理器会重排(reorder)一个goroutine中的读写执行顺序.
- 由于重排, 一个goroutine观察到的执行顺序可能和其它goroutine的感知顺序不一致, 例如:一个goroutine执行a=1;b=2, 其它goroutine可能看到b先更新a后更新.
- 通过**happen-before**来指定读和写的要求, 若e1 happen before e2, 则称e2 happen after e2; 若e1不happen before e2且e2不happen before e1, 则称e1和e2并发.
- 当多个goroutine访问一个共享变量时, 必须使用同步事件来建立happens-before条件, 从而确保读取到期望的写.

# 三 同步:
## (1)初始化:

## (2)goroutine创建

## (3)goroutine销毁

## (4)channel通信

## (5)Locks

## (6)Once