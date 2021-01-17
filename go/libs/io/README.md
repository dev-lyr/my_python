# 一 fmt:
## (1)功能:
- 提供格式化(formatted)IO函数, 类似C的printf和scanf.

## (2)函数:
- Print,Printf,Println
- Sprint, Sprintf, Sprintln
- Scan,Scanf,Scanln
- Sscan,Sscanf,Sscanln
- Fprint,Fprintf,Fprintln
- Fscan,Fscanf,Fscanln

## (3)format:
- 常规: %v:值的默认格式(default format), %#v:值的Go语法表示, %T:值的类型的Go语法表示. 
- Boolean: %t
- Integer: %d(10进制)等等
- 字符串: %s,%q,%x和%X.
- slice: %p.
- point: %p.

## (4)备注:
- 非f的都是使用默认format(%v).
- 打印struct时,%+v会打印属性名字.
- https://golang.google.cn/pkg/fmt/

# 二 io
## (1)功能:
- 封装基本的IO原语, 提供一些高级别抽象的公共接口.

## (2)类型:
- Reader(interface): 封装基本读方法.
- Writer(interface): 封装基本写方法.
- 等等.

## (3)Reader常用实现类:
- File指针: os.Open返回.
- strings.Reader: string.NewReaderc创建.
- net.Conn

#  三 io/ioutil:
## (1)概述:
- 功能: 实现一个I/O工具函数.

## (2)相关函数:
- ReadAll(r io.Reader): 从r中读取直至error或EOF, 并返回读到的数据.
- ReadFile
- WriteFile
- ReadDir
- TempDir
- TempFile

# 四 bufio:
## (1)概述:
- 功能: 实现buffer IO.

## (2)类型:
- Reader(struct): 给io.Reader对象的提供buffering.
- Writer(struct): 给io.Writer对象的提供buffering.
- Scaner(struct)

## (3)Reader:
- ReadLine

# 五 flag:
## (1)功能:
- 实现命令行flag解析, 可以定义多种类型的flag, 所有类型定义好后, 需调用flag.Parse(). 
- 命令行flag语法: -flag,-flag=x,-flag x(非boolean), 其中-/--都可以.
