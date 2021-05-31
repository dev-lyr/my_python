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

## (4)debug

# 三 syscall
## (1)概述:

## (2)备注:
- https://godoc.org/golang.org/x/sys 

# 四 time:
## (1)功能:
- 提供时间相关的功能,例如:sleep等.

## (2)函数:
- Sleep
- Tick
