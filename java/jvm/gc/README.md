# 一 垃圾回收器：
## (1)HotSpot的内存被管理分为三代：
- 新生代(**young** generation)
- 老年代(old generation, **tenured** generation)
- 永久代(permanent generation)：HotSpot特有，HotSpot将方法区作为永久代对待并将垃圾回收扩展到方法区. 永久代回收主要两部分: 废弃常量和无用的类.
- 备注：新生代内存由1个**Eden区域**和**2个survivor区域**，大部分对象初始分配在eden区域，survivor区域保存至少经历一轮新生代收集存活下来的对象，有机会进入老年代区域. HotSpot默认Eden区域和Survivor区域面积比例为8:1.

## (2)垃圾回收类型：
- young collection(又称**minor** collection)：新生代回收.
- full collection(又称**major** collection)：老年代和永久代回收.
- 备注: Minor GC非常频繁且回收速度快; Full GC一般比较会比Minor GC慢十倍以上.

## (3)常用垃圾回收收集器：
- 线性收集器：Serial collector(新生代)，Serial Old Collector(老年代)
- 并行收集器：Parallel new(新生代)，Parallel Scavenge Collector(新生代)，Parallel old Collector(老年代)
- 并发收集器：CMS(Concurrent Mark-Sweep Collector，老年代)和G1(老年代).
- 备注：Parallel new是唯一可以和CMS一起使用的新生代收集器.

## (4)备注：
- 大部分对象初始分配在yong generation；old generation包含一些直接分配在里面的大的对象，以及一些经过多次young generation收集存活下来的对象；permanent generation存在一些类和方法的描述信息以及其本身，主要是为了方便进行垃圾回收管理.
- 通常young generation会首先被收集(young generation收集算法)；然后才对old generation和permanent generation进行收集(old generation收集算法).

## (5)相关配置:
- -XX:newRatio=ratio：设置新生代和老年代的大小比例，默认是2.
- -XX:SurvivorRatio=ratio：设置新生代中eden空间和survivor空间的比例，默认为8.
- -XX:MaxGCPauseMillis=time：设置垃圾回收暂停时间的软目标，JVM尽力实现，默认没有设置, 部分gc器实现会考虑.
- -XX:ParallelGCThreads=threads：设置并行进行新生代和老年代垃圾回收的线程数量.
- -XX:+printGC：默认关闭，每次GC时候打印相关信息，还有很多类似开关.
- -XX:+UseConcMarkSweepGC：开启则使用CMS对老年代进行垃圾回收.
- -XX:+UseG1GC.
- -XX:+UseParallelGC: 开启Parallel Scavenge Collector, 若开启则-XX:+UseParallelOldGC自动被开启, 除非显式关闭.
- -XX:+UseParallelOldGC
- -XX:+UsePraNewGC
- -XX:+UseSerialGC: 使用serial new和serial old.
- -XX:+UseTLAB：在新生代空间内使用thread-local allocation block(TLABs)，默认开启.
- -XX:+HeapDumpOnOutOfMemory：当发生OOM异常时使用heap profiler(HPROF)来dump Java堆内存，默认关闭.
- -XX:HeapDumpPath=path：设置dump文件的地址，默认当前工作目录.

## (6)实现:
- openJDK/src/hotspot/share/gc.


# 二 线性回收器(serial collector):
## (1)概述:
- 使用单个线程来执行垃圾回收工作, 适用于单处理器机器, 不能利用多核的优势.
- 在特定硬件和系统配置是中默认的回收方法, 也可以使用-XX:+UserSerialGC来设置(使用serial new和serial old).

## (2)serial new(新生代)
- 采用复制算法.

## (3)serial old(老年代):
- 采用标记-整理算法.

# 三 并行回收器(parallel collector):
## (1)概述:
- 并行的执行垃圾回收, 大大减少垃圾回收的开销.
- 适用于运行在多核硬件上的中到大型的数据集的应用.

## (2)ParNew(新生代):
- 是Serial收集器的多线程版本, 才有复制算法.
- 当老年代使用CMS时, 新生代只能选择Serial收集器或ParNew, 默认是Parnew.

## (3)Parallel Scavenge(新生代):
- 才有复制算法的并行新生代收集器, 其它收集器目标是尽可能缩短垃圾回收时用户现场的停顿时间, 该收集器关注是达到一个可控制的吞吐量(throughput).
- 吞吐量=运行用户代码时间/(运行用户代码时间+垃圾回收时间).
- 停顿时间越短越适合需要和用户交互的程序; 高吞吐量则可以高效率利用CPU时间尽快完成程序的运算任务, 主要适合后台计算任务.

## (4)Parallel Old(老年代):
- Parallel Scavenge对应的老年代版本, 使用多线程和标记-整理算法.
- 在注重吞吐量和CPU资源敏感的情况下, 优先考虑Parallel Scavenge和Parallel Old收集器.

## (5)cms收集器(老年代):
- 以获得最短停顿时间为目标的收集器.

## (6)g1收集器

## (7)ZGC

# 四 经验:
## (1)衡量标准:
- 吞吐量
- 垃圾回收开销
- 暂停时间
- 收集的频繁度
- 等等.
