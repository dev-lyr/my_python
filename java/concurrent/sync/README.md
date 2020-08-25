# 一 概述： 
## (1)同步的功能：
- 互斥：当对象被一个线程修改时候，阻止另外一个线程观察到对象内部不一致状态.
- 保证可见性：可以保证进入同步方法或者同步代码块的每个线程，都看到由同一个锁保护的之前所有的修改效果.

## (2)同步机制：
- synchronized关键字(临界区和同步方法)
- 显式Lock对象和显式Condition，java.util.concurrent.locks.
- volatile变量
- 原子变量(无锁同步).

## (3)显式锁(Lock)和内置锁(synchronized)：
- 内置锁和条件变量不能中断一个正在等待锁的线程，获取锁不能设置超时，每个锁仅有一个条件变量.
- 显式锁可以设置等待锁时间、每个锁可以创建多个显式条件变量.

## (4)原子变量和volatile变量：
- 原子变量是一种"更好的volatile变量"，提供了与volatile类型变量相同的内存语义，还支持原子的更新操作.

## (5)备注：
- 无状态对象：不包含任何field和对其它类中field的引用, 无状态对象一定是线程安全的.
- **无锁同步(lock-free)**: 原子变量.
- 非阻塞同步.

# 二 悲观锁和乐观锁：
## (1)概述:
- 悲观锁：独占锁，例如：显式锁和内置锁等.
- 乐观锁：借助冲突检查机制，在更新过程中判断是否有其它线程的干扰，若有，则更新失败，并可以重试. 例如: CAS.
- 备注: **乐观锁适用于数据冲突比较少情况, 即读多写少.**

## (2)悲观锁的缺点:
- 资源在首次访问时就被锁住, 直至事务结束, 若其它大多数事务都市简单的查询资源并不修改, 则排它锁会导致锁竞争.

## (3)乐观锁机制:
- 首次访问资源时记录下资源的状态, 并不会锁资源, 在提交时候(即资源打算在持久化存储中更新)时, 从存储中再次读取资源的状态并和首次访问的状态比较, 若不同则当前事务被回滚.

## (4)乐观锁的实现:
- 使用version.
- CAS.
- 待补充.

# 三 内置锁和内置条件变量： 
## (1)synchronized关键字两种用法：
- synchronized(lock) {访问或修改由锁保护的共享状态}：临界区或同步控制块, lock必须是引用类型.
- public synchronized void methodName(){}：同步方法, synchronized修饰的是实例方法则对于**对象实例**作为锁定和解锁对象；若是类方法，则**Class对象**作为锁对象.
- **同步块**: synchronized关键字经过编译之后，会在**同步块**前后分别形成**monitorenter**和**monitorexit**两个字节码指令，这两个字节码都需要一个引用类型的参数来指明要锁定和解锁的对象.
- **同步方法**: 同步方法不是使用指令实现, 而是利用运行时常量池的**ACC_SYNCHRONIZED** flag来进行区分, 方法调用指令检查该flag.

## (2)wait和notify和notifyAll：
- wait：导致当前线程阻塞直至别的线程调用该对象notify或notifyAll方法、或者达到设置的wait时间、该线程必须拥有该对象的monitor，否则执行时候会抛异常:IllegalMonitorStateException.
- notify
- notifyAll
- 备注：调用对象的这三个方法的线程必须拥有该对象的monitor.

## (3)线程变成对象monitor的owner的三种方法：
- 执行该对象的同步方法：在该方法中调用上述三个方法.
- 执行该对象同步语句块：synchronize(obj){}
- 执行该对象静态同步方法：在该方法中调用上述三个方法.

## (4)备注：
- 内置锁只有一个相关条件变量.
- 每个java对象都可以作为实现同步的锁.

# 四 显式锁(java.util.concurrent.locks)： 
## (1)概述：
- 提供一个区别于内置同步和监听器(monitor)的同步工具类，主要包含互斥锁和条件变量.
- Condition结合Lock使用.

## (2)接口：
- Condition：调用await、signal时必须获得该条件变量对应的锁，调用await时会自动释放绑定的锁.
- Lock：lock、unlock和newCondition(返回和lock绑定的条件变量).
- ReadWriteLock：读写锁.

## (3)常用类：
- ReentrantLock: 可冲入锁.
- ReentranReadWriteLock
- StampedLock(1.8才有)


# 五 volatile关键字(原子性和易变性)：
## (1)功能：
- 保证该变量对所有线程的可见性，线程修改了该变量的值，新值对其它线程来说都是立即可知的，原理：在每个线程使用之前都先从内存中刷新下最新值到线程的工作内存.
- 禁止指令重排序优化.
- ACC_VOLATILE: 属性的flag, 表示不要在寄存器cache(hotspot/share/prims/jvm.h).

## (2)适用情况(满足下列条件)：
- 运算结果不依赖变量的当前值，或者能够保证只有单一的线程修改变量的值.
- 变量不需要与其它的状态变量共同参与不变约束.
- 一个线程写多个线程读的场景.
 
## (3)备注：
- 首选还是使用synchronized关键字.
- 并不保证变量是线程安全的，只保证可见性.

# 六 原子变量： 
## (1)概述：
- java.util.concurrent.atomic：支持单个变量**无锁**的线程安全.
- 使用高效的机器级指令来保证操作的原子性.
- AtomicStampedReference可解决ABA问题.

## (2)机器指令：
- 测试并设置(Test-and-Set)
- 获取并递增(Fetch-and-Increment)
- 交换(Swap)
- 比较并交换(CAS：Compare-and-Swap): 存在ABA问题.
- 关联加载/条件存储(Load-Linked/Store-Conditional)

# 七 内存一致性(happen-before).