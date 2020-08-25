# 一 概述:
## (1)概述:
- CMS(Concurrent Mark Sweep): 适用于优先需要**更短垃圾回收暂停时间**并且愿意与垃圾回收器共享cpu资源的应用, 主要通过使用多个**单独**的垃圾回收线程**并发**的跟踪可达对象(reachable objects).
- 适用于有大量的长时间存活的数据(大的tenured generation(老年代))并且有2个或多个处理器的应用.
- 与其他回收器类似, CMS也是分代的, 使用方式-XX:+UseConcMarkSweepGC.

## (2)阶段:
- **Initial Mark**: **Stop all application threads**, identify the set of objects reachable from roots, and then resume all application threads.
- **Concurrent Marking**: Concurrently trace the reachable object graph, using one or more processors, while the application threads are executing. Concurrently retrace sections of the object graph that were modified since the tracing in the previous step, using one processor.
- **Remark**: **Stop all application threads** and retrace sections of the roots and object graph that may have been modified since they were last examined, and then resume all application threads.
- **Concurrent Sweep**: Concurrently sweep up the unreachable objects to the free lists used for allocation, using one processor.
- **Resetting**: Concurrently resize the heap and prepare the support data structures for the next collection cycle, using one processor.

## (3)特点:
- 对CPU资源比较敏感, 并发阶段, 虽然不会stw, 但是占用线程, 默认启动回收线程数为(CPU数量+3)/4.
- 无法处理浮动垃圾(Floating Garbage)
- 基于标记-整除算法, 会产生大量内存碎片, 可使用-XX:+UseCMSCompactAtFullCollection在Full GC之后附加一个碎片整理过程, 但碎片整理需要STW, 会造成STW变大, 可可使用-XX:CMSFullGCsBeforeCompaction设置多少次Full GC后进行一次碎片整理.

## (4)相关实现:
- concurrentMarkSweepGeneration.hpp: CMSCollector.
- CollectorState: 收集器的状态, InitialMarking, Marking, FinalMarking等.
- VM_CMS_Operation: 需要STW的操作类的Base抽象类, 子类包括: VM_CMS_Initial_Mark和VM_CMS_Final_Mark.

## (5)备注:
- https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/cms.html

# 二 Initial Mark:
## (1)概述:
- 会STW.
- 标记GC Roots直接可达的对象.
- 实现:  vmCMSOperations.hpp的VM_CMS_Initial_Mark类.

# 三 Remark:
## (1)概述:
- 会STW.
- 实现:  vmCMSOperations.hpp的VM_CMS_Final_Mark类.