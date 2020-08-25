# 一 概述:
## (1)概述:
- 继承Collection接口, 除了基本的collection的操作外, 提供额外的插入,获取和检查操作.
- 队列通常是**FIFO**方式排序元素, 其它: **优先级队列**根据指定的comparator或者元素的natural ordering进行排序; LIFO队列(或stack)以后进先出顺序.
- 不管使用何种order规则, 队列的头部元素通过poll或remove来删除; 插入时, FIFO队列将元素放入队列末尾, 其它类型队列则使用不同的位置规则放置.

## (2)相关操作:
- element: 返回但不删除队列的头部元素, 若队列为空则抛出NoSuchElementException.
- peek: 同element, 只是在队列为空时返回null而不是抛出异常.
- remove: 返回并删除队列头部元素, 若队列为空, 则抛出NoSuchElementException.
- poll: 同remove, 若队列为空, 则返回null.
- offer: 插入元素到队列, 当使用容量限制的队列时, 优先使用该方法.
- add: 插入元素到队列, 由于队列capacity限制插入失败时会抛出异常.

## (3)类型:
- 阻塞队列
- 延迟队列
- 线程安全队列
- 优先级队列

# 二 阻塞队列:
## (1)概述:
- BlockingQueue的实现需要是线程安全的, 但是addAll,containsAll,retainAll和removeAll等集合操作不要求是原子的.