# 一 相关库:
## (1)sync标准库:
- 提供基本的同步原语, 例如:互斥排它锁.
- 除了Once和WaitGroup类型外, 其它主要用低级别的library routine, 高级别的同步通过channel和communication更好.
- sync/atomic:

## (2)第三方:
- https://godoc.org/golang.org/x/sync

## (3)备注:
- go help build的--race选项.
