# 一 概述:
## (1)概述:
- Collection接口extends Iterable, 因此默认支持for-each循环.

## (2)子接口:
- List
- Set
- Queue

## (3)相关类:
- RandomAccess: Lists使用的标记接口, 表示支持快速的随机访问, 主要目的是允许算法遇到可随机访问的队列时改变行为从而提高更好的性能.


# 二 List(Collection，Iterable):
## (1)概述:
- ArrayList: 随机访问元素性能好，但中间插入和删除较慢.
- LinkedList: 随机访问较慢，适合插入和删除元素.
- Vector: 实现了一个可增长和缩短的对象数组, 可以通过整数索引访问; 是同步的, 若不需要线程安全, 则推荐使用ArrayList.
- Stack: 实现一个后进先出的栈; 继承Vector.

# 三 Set(Collection，Iterable):
## (1)概述:
- HashSet: 底层是散列表.
- TreeSet: 一个有序的集合，底层红黑树.

## (2)备注:
- multiset: jdk没有, guava有.

# 四 Queue(Collection，Iterable):
## (1)概述:
- 一个根据优先级保存和处理元素的集合.

## (2)子类:
- BlockingQueue: 阻塞队列, 取元素时等待队列不为空, 放元素时等待有空间.
- Deque: 双端队列, 支持队头和队尾的插入和删除.

## (3)SynchronousQueue:
- 没有缓冲的BlockingQueue, 插入元素时必须等待另一个线程的删除操作, 反之一样.
