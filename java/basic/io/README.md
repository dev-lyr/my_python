# 一 概述：
## (1)java.io(面向流，阻塞I/O):
- 输入流：InputStream(面向字节)和Reader(面向字符).
- 输出流：OutputStream(面向字节)和Writer(面向字符).
- 功能: Provides for system input and output through data streams, serialization and the file system.

## (2)java.nio核心内容(面向缓冲，异步非阻塞I/O)：
- 缓冲区(buffer)
- 通道(channel)
- 选择器(selector)
- 备注：通道是I/O传输发生时通过的入口，而缓冲区是这些数据传输的来源或目标.

## (3)其他:
- File类: An abstract representation of file and directory pathnames.
- RandomAccessFile: 支持文件的随机访问.
- DataInput: The DataInput interface provides for reading bytes from a binary stream and reconstructing from them data in any of the Java primitive types. 
- DataOutput: The DataOutput interface provides for converting data from any of the Java primitive types to a series of bytes and writing these bytes to a binary stream. 

# 二 InputStream:
## (1)功能:
- This abstract class is the superclass of all classes representing an input stream of bytes.

## (2)子类:
- FileInputStream: 从文件系统中的文件获取字节, 用来读取原始字节流(例如:图像数据). 若需读字符流, 考虑使用FileReader.
- ObjectInputStream: deserializes primitive data and objects previously written using an ObjectOutputStream.
- 等等.

