# 一 概述：
## (1)相关概念:
- **缓冲区**(buffer): 本质就是封装了一块堆内存(数组)或堆外内存(unsafe.allocateMemory或文件map)并包括其它属性的类.
- **通道**(channel): 本质就是封装了文件描述符fd或socket套接字并包含其它属性的类.
- **选择器**(selector): 本质就是I/O复用.
- 备注：通道是I/O传输发生时通过的入口，而缓冲区是这些数据传输的来源或目标.

# 二 缓冲区(Buffer)：
## (1)概述：
- 一个基本类型(primitive type)的数据容器.
- Buffer是一个线性(linear),有限的基本类型元素的序列.
- 每一个基本类型都有一个Buffer子类, 除了boolean.
- Buffer不是线程安全的, 若被多线程访问需要注意同步.

## (2)属性:
- capacity: buffer包含的元素的数量, 非负且不能改变.
- limit: 第一个不能被读/写的元素的索引, 非负且不能大于capacity.
- position: 下一个可被读/写的元素的索引, 非负且不能大于limit.
- mark

## (3)方法:
- get和put操作由继承子类自定义.
- isDirect: 返回该buffer是不是direct.

## (4)类层次：
- 顶层：Buffer抽象类.
- 子类：ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer, ShortBuffer.

## (5)备注：
- **Channel只能在字节缓冲区(ByteBuffer)上操作**, ByteBuffer提供向其他类型转化的方法.
- 直接buffer(unsafe.allocateMemory分配的内存或把FileChannel的map方法将fd映射到进程的内存空间); 非直接buffer(即heap buffer, 利用数组来描述内容).

# 三 通道(Channel)：
## (1)概述：
- 表示一个打开的到实体的连接, 例如:硬盘、文件、socket或其他有能力执行IO操作的程序组件.
- Channel是双向的, 可以读和写, Stream是单向的.

## (2)常用Channel类：
- FileChannel：调用RandomAccessFile、FileInputStream等类的getChannel方法获得.
- SocketChannel
- ServerSocketChannel

## (3)例子：
- RandomAccessFile file = new RandomAccessFile("D://person.txt", "r");
- FileChannel fileChannel = file.getChannel();
- ByteBuffer byteBuffer = ByteBuffer.allocate(10);
- fileChannel.read(byteBuffer);

## (4)SelectableChannel：
- 只有继承该抽象类的Channel才能被选择器(Selector)I/O复用, 调用register方法把注册到一个选择器上.
- 在被选择器使用时，通过需要先调用configureBlocking设置为非阻塞状态，否则register()方法抛出IllegalBlockingModeException.
- 子Channel包括: DatagramChannel, Pipe.SinkChannel, Pipe.SourceChannel, ServerSocketChannel, SocketChannel.

# 四 选择器(Selector)：
## (1)概述：
- 提供确定一个或多个通道当前状态的机制，可实现就绪选择.
- 使用选择器，通过一个线程，就可以对多个I/O通道实施监控和维护，类似linux中select、epoll等.
- 选择器就是对底层系统select、epoll的封装.
- 一个通道可以被注册到多个选择器上，对每个选择器而言只能注册一次.
- 选择器是水平触发(level-triggered)模式.

## (2)组成：
- 选择器类(Selector)：管理一个被注册的通道的集合和它们的就绪状态.
- 可选择通道(SelectableChannel)：实现通道可选择性所需的公共方法，支持就绪检查的通道类的父类，FileChannel对象时不可选择的(不能注册)，因为没有继承SelectableChannel.
- 选择键(SelectionKey)：封装了特定通道与特定选择器的注册关系，由SelectableChannel.register()返回.

## (3)选择器(Selector)API：
- isOpen()
- keys()：与选择器关联的已经注册的选择键的集合，返回Set<SelectionKey>.
- selectedKeys()：被选择器判断状态已准备好的通道的选择键的集合，返回Set<SelectionKey>.
- select()：没有通道就绪线程则阻塞.
- select(long timeout)：指定线程阻塞的超时时间.
- selectNow()：不阻塞.

## (4)可选择通道(SelectableChannel)API：
- register(Selector sel, int ops)：把通道注册到一个选择器上.
- isRegistered()：判断该通道是否被注册到选择器上.

## (5)选择键(Selectionkey)：
- 属性(int)：OP_ACCEPT、OP_CONNECT、OP_READ和OP_WRITE.
- interestOps()：指定通道/选择器所关心的操作的集合.
- readyOps()：获取相关通道已ready的操作的集合.
- isAcceptable()、isConnectable()、isReadable()、isWritable()
- selector()：返回关联的SelectableChannel对象.
- channel()：返回

# 五 ByteBuffer:
## (1)类型:
- ByteBuffer是Direct(allocateDirect, DirectByteBuffer)
- No-Direct(allocate: HeapByteBuffer).

## (2)直接buffer优点:
- Given a direct byte buffer, the Java virtual machine will make a best effort to perform native I/O operations directly upon it. That is, it will attempt to avoid** copying the buffer's content to (or from) an intermediate buffer** before (or after) each invocation of one of the underlying operating system's native I/O operations.

## (3)直接buffer创建方式:
- A direct byte buffer may be created by invoking the **allocateDirect** factory method of this class. The buffers returned by this method typically have somewhat **higher allocation and deallocation costs** than non-direct buffers. 
- A direct byte buffer may also be created by **mapping a region of a file directly into memory(FileChannel的map())**. An implementation of the Java platform may optionally support the creation of direct byte buffers from native code via JNI.

## (4)经验:
- The contents of direct buffers may **reside outside of the normal garbage-collected heap**, and so their impact upon the memory footprint of an application might not be obvious. It is therefore recommended that direct buffers be allocated primarily for large, long-lived buffers that are subject to the underlying system's native I/O operations. 
- In general it is best to allocate direct buffers only when they yield a measureable gain in program performance.

