# 一 ReentrantLock:
## (1)概述:
- **可重入**互斥锁, 最后一个锁成功的线程拥有该reentrantLock锁, 当调用lock方法时成功获得锁或调用线程已经是当前锁的owner时立即返回.
- 注意: lock多少次就需要unlock多少次.

## (2)原理:
- 通过一个int类型state字段来表示锁的状态, 当state=0时表示没有被锁, 线程调用lock将state设置为1(原子操作:compareAndSwapInt), 当state>=1时表示被锁, 只有拥有该锁的线程可以继续lock成功,并且每次lock讲state增加1, 直至Integer.MAX_VALUE(即最大可重入次数).

## (3)参数:
- faieness: 默认为false, 当为true时, 优先让长时间等待的线程获得锁, 公平锁的性能比默认的慢, 但可以避免starvation.

## (4)Condition

# 二 ReentrantReadWriteLock

# 三 StampedLock:
## (1)概述:
- A capability-based lock with three modes for controlling read/write access.
- 优化版的读写锁.
