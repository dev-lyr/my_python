# 一 概述： 
## (1)概念：
- 基本所以并发模式解决线程冲突问题，都是采用序列化访问共享资源的方案.
- 线程进入(synchronized)同步块前会自动获得锁，退出同步块时会自动释放锁(无论是正常退出还是异常退出).

## (2)多线程优势：
- 发挥多处理器的计算能力.
- 简化建模.
- 使用多线程替代异步处理来接受多个用户请求.

## (3)多线程带来的问题：
- 线程安全性问题
- 线程活跃性问题：包括：死锁、饥饿和活锁等.
- 性能开销：多线程调度时的上下文切换、共享数据的同步等.

# 二 java.util.concurrent： 
## (1)Executors工厂类.

## (2)CountDownLatch类：
- 功能：允许一个或多个线程等待其它线程中的操作完成为止.
- 用法：CountDownLatch用一个指定count初始化，调用对象的await方法会阻塞直至这个count通过countDown函数变为0为止.
- 例如：CountDownLatch latch = new CountDownLatch(10)；latch.countDown()；latch.await().
- 备注: count不能够被reset, 若需要reset count, 可考虑使用CyclicBarrier.

## (3)线程安全集合：
- ConcurrentMap: ConcurrentHashMap和ConcurrentSkipListMap

## (4)Semaphore类：
- 信号量.

## (5)CyclicBarrier类:
- 功能: 让一些线程全部的等待, 直至所有线程都到达一个公共barrier点.
- 使用: 初始化一个parties(线程数), 调用**await**阻塞直至所有线程都在该barrier上调用await方法.

# 三 java.util.concurrent.atomic：
## (1)概述：
- 支持单个变量上的**无锁(lock-free)的线程安全(thread-safe)**编程.
- 对单个变量的原子操作类.
- 使用高效的机器级指令来保证操作的原子性.

## (2)机器指令：
- 测试并设置(Test-and-Set)
- 获取并递增(Fetch-and-Increment)
- 交换(Swap)
- 比较并交换(CAS：Compare-and-Swap)：
- 关联加载/条件存储(Load-Linked/Store-Conditional)

## (3)类： 
- AtomicBoolean
- AtomicInteger
- AtomicIntegerArray
- AtomicIntegerFieldUpdater
- AtomicLong
- AtomicLongArray
- AtomicLongFieldUpdater
- AtomicMarkableReference
- AtomicReference
- AtomicReferenceArray
- AtomicReferenceFieldUpdater
- AtomicStampedReference
- DoubleAccumulator
- DoubleAdder
- LongAccumulator
- LongAdder

# 四 java.util.concurrent.locks： 
## (1)概述：
- 提供一个区别于内置同步和监听器(monitor)的同步工具类，主要包含互斥锁和条件变量.
- Condition结合Lock使用.

## (2)接口：
- Condition：用于等待, 调用awaitXXX、signalXXX前必须获得该条件变量对应的锁，调用await时会自动释放绑定的锁.
- Lock: 用于互斥, lock、unlock和newCondition(返回和lock绑定的条件变量).
- ReadWriteLock：读写锁.

## (3)常用类：
- ReentrantLock
- ReentranReadWriteLock
- StampedLock(1.8才有)