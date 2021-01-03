# 一 函数:
## (1)语法:
- **格式**: `func 函数名(参数1, 参数2...) 返回类型 {}`, 签名(signature)包含参数和返回类型.
- **参数**: 可以接收0到n个参数, 当参数同一类型时, 除了最后一个类型, 其它都可以省去.
- **返回值**: 可以返回任意数量的返回值, 返回值可指定变量的名字.
- 函数也是值, 也有类型, **函数可以作为函数的参数或返回值**, 例如: v := func()T{}和fmt.Println(func(...))
- 函数体的左括号{必须和func函数声明在同一行.

## (2)参数传递:
- 实参是**按值**传递的, 函数接收到的是实参的副本.
- 若实参包含引用类型, 例如: 指针,slice,map,函数或channel, 则使用形参变量就可能会间接修改实参变量.
- 可变参数: 在最后一个参数类型之前添加..., 表示可接收任意数量的该类型参数(当做slice看待); 调用该函数若已经是slice类型, 则在参数后加上...
- interface{}参数可以接收任意类型.

## (3)匿名函数:
- func后面没有函数名, 是一个表达式.

## (4)延迟执行函数(defer):
- 语法: `defer 函数/方法调用.`
- 跟在defer后面的函数会被延迟调用, 在包含defer语句的**函数结束后才调用**, 无论函数是正常结束(return或执行完毕)还是不正常结束(宕机).
- defer语句没有使用次数限制, 执行时候以defer语句的**逆序**执行.
- 应用场景: 常用语成对的操作, 例如: 打开/断开连接, 获得/释放锁等, 保证在函数执行路径下资源会被释放.

## (5)没有body的函数声明:
- go:linkname
- 汇编实现

## (6)备注:
- main函数是一个特殊的函数, 是程序开始的地方. 语法:func main(){}
- 使用:=赋值时, 左边至少要有一个新的变量(非空), 否则编译不过.

# 二 内置函数:
## (1)概述:
- Built-in functions are predeclared. They are called like any other function but some of them accept a type instead of an expression as the first argument.
- The built-in functions do not have standard Go types, so they can only appear in call expressions; they cannot be used as function values.

## (2)len和cap:
- len(type): 返回指定类型的长度. 例如:string的字节数; array的长度; slice的长度; map的长度和channel buffer中元素数量.
- cap(type): 返回指定类型的容量. 例如: array的长度; slice的容量和channel buffer的容量.

## (3)new:
- new(T): 在运行时创建指定类型的变量, 为其分配内存, 并返回一个`*T`指定指向它.

## (4)make:
- 用来创建slice, map或channel类型, 返回该类型的值, 值以零值初始化.
- make(T, n)       slice      slice of type T with length n and capacity n
- make(T, n, m)    slice      slice of type T with length n and capacity m
- make(T)          map        map of type T
- make(T, n)       map        map of type T with initial space for approximately n elements
- make(T)          channel    unbuffered channel of type T
- make(T, n)       channel    buffered channel of type T, buffer size n

## (5)append和copy:
- append: 添加0个或多个值到slice.
- copy: 将src slice的元素copy到dst slice并返回copy的元素数量.

## (6)delete:
- delete(m, k): 从map中删除key k.

## (7)操作复杂数字:
- complex
- real
- imag

## (8)处理panic:
- func panic(interface{})
- func recover() interface{}

## (9)Bootstrapping:
- print
- println

# 三 错误处理:
## (1)习惯:
- 当函数调用发生错误时, 习惯返回一个附加的结果作为错误值, 该错误值通常作为最后一个结果返回.
- 若错误只有一种情况, 结果通常设置为布尔型; 若错误原因多种, 则结果类型通常是error(内置接口类型).
- Go使用普通的值而非异常来报告错误, Go的异常只用于程序bug导致的预料外的错误, 而不是常规的处理方法出现在程序中.
- 函数内检测失败的代码在成功之前, 若检测到失败则函数返回; 成功的逻辑一般不放在else块而是在外层作用域.

## (2)处理策略:
- 将错误传递下去, 使被调用函数发生的错误变为调用函数的错误.
- 对于不固定或者不可预测的错误, 可以短暂间隔后重试, 超过重试次数或限定时间再报错退出.
- 若依旧不能顺利执行下去, 调用者输出错误然后优雅的停止程序(os.Exit(1)), 通常这样处理由main函数执行.
- 记录下错误信息让程序继续执行.
