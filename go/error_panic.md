# 一 error类型:
## (1)概述:
- Go预先声明一个**error**类型来一个错误条件, 其中nil表示没有错误.

## (2)error接口

## (3)相关方法:
- errors.New 
- fmt.Errorf: 常用.
- syscall.Errno

# 二 panic:
## (1)概述:
- 执行时错误(例如:数组越界)会触发一个**runtime panic**, 等同于调用内置函数**panic**.
- 默认情况下, panic发生时, 程序会被中断执行, 然后执行该goroutine中的defer函数.

## (2)runtime.ERROR

# 三 recover:
## (1)概述:
- 语法: recover() interface{}
- 若在defer函数中调用了recover函数, 且定义该defer函数的函数发生了panic异常, 则recover函数会使得程序从panic中恢复, 并返回panic值; 不会退出程序, 函数会从发生panic之处返回.
- 若在其它任何情况下调用recover, 没有效果且返回nil.

## (2)经验:
- 要选择的使用recover, panic后不是所有情况都需要恢复; 可使用一个明确的,非导出类型作为panic值, 之后检查recover的返回值来判断, 若是再恢复, 若不是继续调用panic触发宕机.
- 同一包内发生的panic进行recover有助于简化复杂和未知的错误, 但不应该尝试去恢复其他包内发生的panic.

