# 一 概述:
## (1)类型:
- 基本类型: 数字,字符串和布尔型.
- 聚合类型(aggregate type): array和struct.
- 引用类型: point, slice, map, function和channel.
- 接口类型

## (2)零值:
- 数值类型为0
- 布尔类型为false
- 字符串为""
- 对于接口和引用类型(slice, 指针, map, function和channel)零值为nil.
- struct的零值就是所有成员的对应的零值, struct不能和nil比较, 也不能被赋值nil.

## (3)方法集:
- A type may have a method set associated with it. 
- The method set of an interface type is its interface. 
- The method set of any other type T consists of all methods declared with receiver type T. 
- The method set of the corresponding pointer type *T is the set of all methods declared with receiver *T or T (that is, it also contains the method set of T). 
- Any other type has an empty method set. In a method set, each method must have a unique non-blank method name.
- The method set of a type determines the interfaces that the type implements and the methods that can be called using a receiver of that type.

## (4)Type Declaration:
- 功能: 绑定一个表示(类型名字)到一个类型, 有两种形式: **别名**和**类型定义(类似typedef)**.
- 别名: type myString = string, myString和string是**同一**类型.
- 类型定义: type 类型名词 底层类型, 创意一个**新的,不同**的类型, 新的类型被创作defined类型, 与其它类型不同, 包含它被创建的类型, defined类型可以有方法关联到它.

## (5)predeclared identifiers:
- **Types**: bool byte complex64 complex128 error float32 float64 int int8 int16 int32 int64 rune string uint uint8 uint16 uint32 uint64 uintptr
- **Constants**: true false iota
- **Zero value**: nil
- 各种内置函数.

## (6)类型转换:
- 显式类型转换: T(v)将v转换为类型T.
- 备注: https://golang.google.cn/ref/spec#Conversions

## (7)相关包:
- sort

# 二 整型:
## (1)类型:
- 有符号: int, int8, int16, int32, int64.
- 无符号: uint, uint8, uint16, uint64
- byte: 等价于uint8.
- uintptr: 没指定具体大小但足以容纳指针, 主要用于底层编程.
- 备注: int和uint是和CPU字大小相关.

# 三 字符串:
## (1)概述: 
- string
- 字符串是不可变的, 不可通过下标进行修改.
- 字符串可通过比较运算符比较, 例如: ==和<.
- 内置函数len返回字节数; 可通过下标访问子串: s[i], s[:i], s[i:], s[i:j].

## (2)相关包:
- bytes: 提供操作字节slice的函数, 与strings类似.
- strings: 提供一些操作UTF-8字符串的简单函数(比较,判断是否存在等).
- strconv: 提供string和其它基本数据类型(int,bool等)的转换.
- unicode

## (3)类型转换:
- bytes的slice-string: string([]byte{'h','e'})
- string-byte的slice: []byte("hello")
- 数字->string: fmt.Sprintf或strconv.XXX.
- string->数字: strconv.XXX
- strconv包.

## (4)strings:
- Builder(struct): 用于高效构建字符串,减少内存复制.
- Reader(struct): 实现io.Reader,io.ReaderAt,io.Seeker,io.WriteTo,io.ByteScanner和io.RuneScanner接口.

# 四 浮点数
- float32 
- float64

# 五 复数
- complex64
- complex128

# 六 布尔型:
- true
- false

