# 一 概述：
##  (1)引言：
- Java虚拟机在执行Java程序时会把管理的内存分为多个区域，分为两类：线程私有和线程共享.
- 部分内存区域随着虚拟机进程的启动和退出而创建和销毁；部分随着用户线程的启动和终止而创建和销毁.

##  (2)线程共享(虚拟机启动时创建)：
- 堆(heap)：最大一块内存，垃圾回收的主要区域，**用来存储所有创建的类对象和数组**.
- 方法区(method area).
- 常量池(Run-time Constant Pool): 规范上有,是方法区的一部分.

##  (3)线程私有(生命期和线程一样)：
- 程序计数器(pc, program counter register).
- Java虚拟机栈(VM Stack).
- 本地方法栈(Native Method Stack):调用本地方法使用，HotSpot将本地方法栈和虚拟机栈合二为一.

# 二 堆内存(Heap)：
##  (1)概述：
- 所有线程共享，在虚拟机启动时创建，对象的堆存储被自动内存管理系统(即垃圾回收，garbage collector)负责回收.
- 堆的大小可以是固定尺寸或动态扩展和缩小.
- 当堆内存无法再扩展时，抛出OutOfMemoryError异常.
- 线程共享的堆内存中可以划分出多个线程私有的分配缓冲区(Thread Local Allocation Buffer, TLAB)，默认使用.

##  (2)分类：
- 新生代：分为1个Eden和2个Survivor(幸存者: From Space和To Space)区域，HotSpot中默认Eden:Survivor比例为8:1.
- 老年代
- 永久代(备注：HotSpot将方法区称为永久代，其它JVM并没有永久代).

## (3)异常：
- OutOfMemoryError：Java Heap space.

## (4)溢出的解决方法：
- 首先dump出堆转储快照，然后进行分析，确定是内存泄露还是内存溢出.
- 若是内存泄露，则查看泄露对象到GC Root的引用链，知道为什么垃圾回收器无法回收.
- 若是对象必须活着，则需增大虚拟机参数(-Xmx和-Xms).

## (5)相关设置(size的单位是bytes，可以使用k,m,g等)：
- -Xms<size>：设置jvm的init heap size，例如：-Xms256m.
- -Xmx<size>或-XX:MaxHeapSize=<size>：设置jvm的max heap size.
- -Xmn<size>或-XX:NewSize=size：设置年轻代init heap size.
- -XX:MaxNewSize=<size>：设置年轻代的最大尺寸.
- -XX:newRatio=ratio：设置新生代和老年代的大小比例，默认是2.
- -XX:SurvivorRatio=ratio：设置新生代中eden空间和survivor空间的比例，默认为8.
- -XX:+UseTLAB：开启；-XX:-UseTLAB关闭.
- -XX:TLABSize=size：设置TLAB init size，若为0则jvm自动选择大小.

## (6)备注:
- 新生代对象大部分都是很快死掉,所以新生代内存分为一个较大的Eden空间和两个Survivor空间, 每次使用Eden和一个Survior空间, HotSpot默认Eden:Survior=8:1, 即每次使用新生代可用内存的90%.
- 当回收时将Eden和Survivor中存活的对象全部复制到另外一个Survivor区域, 然后清理掉Eden和Survivor.
- 当Survivor不足以存放存活的对象时, 就需要依赖其它内存(老年代)进行分配担保(Handle Promotion), 这些对象直接进入老年代.

# 三 方法区：
## (1)概述：
- 由所有线程共享的内存区域.
- 用于存储每个类的结构，包括类的常量池、域和方法数据、方法或构造函数代码等，类似操作系统中进程的文本段(text segment).
- 虚拟机规范允许对方法区不进行垃圾回收，但HotSpot把方法区作为永久代对待，并进行垃圾回收.

## (2)异常：
- OutOfMemoryErrror：PermGen space

## (3)相关设置：
- -XX:PermSize：设置初始化永久代内存，1.8后被-XX:MaxMetaspaceSize取代.
- -XX:MaxPermSize：设置最大允许的永久代内存的大小，1.8后被-XX:MetaspaceSize取代.

# 四 运行时常量池：
## (1)概述：
- 是每个类或接口的class文件中constant_pool表的运行时表示, 从**JVM的方法区**分配出来.
- 存放编译器生成的各种字面量和符号引用.
- 运行时常量缓冲池是方法区的一部分，当类或结构被虚拟机创建时会构造该类或接口的运行时常量池.

## (2)异常：
- OutOfMemoryErrror：PermGen space，当创建一个类或接口时，当运行时常量池需要大于虚拟机的方法区中可用内存时抛出.

# 五 pc寄存器：
## (1)概述：
- 每个线程有自己的pc寄存器.
- 任何时刻线程都是执行单个方法中的某行代码(称作线程的当前方法)，当该方法不是native时，pc寄存器包含当前被执行的JVM指令的地址，若是native方法，pc寄存器的值未定义.
- 唯一不会抛出OutOfMemoryError的区域，当执行本地方法时，pc寄存器的值未定义.

# 六 虚拟机栈：
## (1)概述：
- 线程私有，与线程声明周期相同，线程创建时被创建.
- 包含元素为**栈帧**(stack frame)，每个方法执行时入栈，执行完出栈.
- 存放局部变量，函数调用参数和返回值等，与C类似.
- 虚拟机栈的大小可以是固定尺寸或根据需要扩展或伸缩.
- JVM实现可能会为用户提供控制初始虚拟机栈大小、限制扩展或收缩时的最大尺寸和最小尺寸的方法.
- 备注：HotSpot将本地方法栈和虚拟机栈合二为一.
- 局部变量包含: **boolean, int等基本类型; 引用类型自身(注意:不是指向的对象); returnAddress类型**.

## (2)frame:
- 帧用来存储数据和部分结果, 还可以执行动态链接, 返回方法的返回值和分发异常(dispatch exceptions).
- 在方法被调用时创建一个新的帧, 在方法调用完成(正常或抛出未捕获异常)时被销毁.
- 每个frame有自己的局部变量(local variables), 操作栈(operand stack)和一个到当前方法的类的运行时常量池的引用.

## (3)异常：
- StackOverflowError：线程请求的虚拟机栈大于允许的尺寸.
- OutOfMemoryError：扩展时无法申请到足够的内存；或没有足够内存为新线程分配初始虚拟机栈.

## (4)溢出解决方法：
- -Xss<size>或-XX:ThreadStackSize=<size>：设置栈容量.

# 七 直接内存(Direct Memory)：
## (1)概述：
- New I/O direct-buffer allocations, 性能高, netty用的比较多.
- 不是虚拟机运行时数据区的一部分，也不是虚拟机规范中定义的内存区域，但是这部分被频繁调用，并可能导致OOM异常.
- 直接内存分配不受Java堆大小限制，但是受到本机总内存限制.

## (2)相关设置：
- -XX:MaxDirectMemorySize=size.

## (3)回收:
- 这段内存只有等待JVM需要进行full gc时回收, 或主动调用System.gc来触发full gc(例如:netty分配直接内存失败时会调用, Bits.reserveMemory()).
- System.gc会导致长时间STL(stop the world), 可使用CMS和-XX:+ExplicitGCInvokesConcurrent优化.

# 八 TLAB：
## (1)概述：
- 堆内存中可以划分出多个线程私有的分配缓冲区(Thread Local Allocation Buffer, TLAB)，默认使用TLAB.

## (2)TLAB优点：
- 堆是所有线程共享，分配对象时需要锁，当对象频繁分配时影响效率.
- TLAB是线程私有，**不必同步**，HotSpot中对象通常分配在TLAB上.
- 对象分配在TLAB外的情况：大的对象或TLAB空间不足.
- Java程序中很多小对象并且用后即丢，适合分配在TLAB上.

## (3)相关设置：
- -XX:+UseTLAB：开启；-XX:-UseTLAB关闭.
- -XX:TLABSize=size：设置TLAB init size，若为0则jvm自动选择大小.
