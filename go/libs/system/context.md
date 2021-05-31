# 一 概述:
## (1)功能:
- Package context defines the Context type, which carries deadlines, cancelation signals, and other request-scoped values **across API boundaries and between processes**.
- 将Context显式作为参数传递给需要它的函数的, 通常是第一个参数且命名为ctx.
- 只有在需要request-scoped数据时候才使用context value. 
- 同一个context是线程安全的, 同一个context可传递给多个goroutines中的函数.

## (2)创建Context方式:
- Background: 返回一个非nil的空context, 该context不能被取消, 没有值和deadline, 通常用于main函数, 初始化, tests和请求进入时的顶层context.
- TODO: 返回一个非nil的空context, 当代码不清楚使用哪个context或者它不是可用时应以使用Context.TODO.
- 各种WithXXX创建parent的副本.
- 备注: background和todo: 底层都是一个emptyCtx.

## (3)类型
- Context接口
- cancelCtx(struct)
- timerCtx(struct)
- valueCtx(struct)
- CancalFunc类型: 让一个操作放弃工作, 不会等待工作结束, 可以被多个goroutines并行调用, 在第一个调用后的其它调用不做任何事情.

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

# 二 Context接口:
## (1)概述:

## (2)方法:
- Deadline
- Done
- Value
- Err

# 三 cancelCtx结构体:
## (1)概述:

## (2)属性:
- Context
- children map[canceler]struct{}
- done
- err

## (3)方法:
- Deadline
- Done
- Value
- Err
- cancel: 创建时候返回.


# 四 timeCtx:
## (1)概述:

## (2)属性:
- cancelCtx
- timer
- deadline

## (3)方法:

# 五 valueCtx:
## (1)概述:

## (2)属性:
- Context
- key,val interface{}
