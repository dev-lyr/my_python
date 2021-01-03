# 一 sync标准库:
## (1)功能:
- 提供基本的同步原语, 例如:互斥排它锁.
- 除了Once和WaitGroup类型外, 其它主要用低级别的library routine, 高级别的同步通过channel和communication更好.

## (2)类型:
- Cond: 条件变量.
- Locker: 一个interface, 表示一个可以locked和unlocked的对象.
- Mutex: 互斥锁, 一个mutex的零值是一个unlocked mutex, 实现了Locker接口.
- Map: 安全map.
- Once: once对象只会被执行一次, 用于延迟初始化等.
- Pool
- RWMutex: 读写锁.
- WaitGroup

## (3)sync/atomic:
- Package atomic provides low-level atomic memory primitives useful for implementing synchronization algorithms.

## (4)备注:
- https://godoc.org/golang.org/x/sync

# 二 Mutex:
## (1)概述:
- 是互斥锁, 一个Mutex的零值是一个unlocked Mutex.
- 实现了Locker接口.
- go没有可重入锁.

## (2)操作:
- Lock
- Unlock

# 三 Cond:
## (1)概述:
- 条件变量.

# 四 Map:
## (1)概述:
- Map是一个安全map, 类似Go map[interface{}]interface{}, 但可以安全的被多个goroutine使用(无需额外的锁或协调).
- Loads, stores, and deletes run in amortized constant time.

# 五 Once:
## (1)概述:
- 用于执行只执行一次的动作.

## (2)方法:
- Do

# 六 Pool:
## (1)概述:
- A Pool is a set of temporary objects that may be individually saved and retrieved.

# 七 RWMutex:
## (1)概述:
- 读写锁, 该锁被多个读者持有或者被单独一个写者持有.

# 八 WaitGroup:
## (1)概述:
- WaitGroup用于等待指定数量的goroutine结束.
- 主goroutine调用Add指定需等待goroutine的数量, 每个goroutine执行完成后调用Done函数, 主goroutine调用Wait等待goroutine都结束.

## (2)方法:
- Add
- Done: 调用Add(-1).
- Wait
