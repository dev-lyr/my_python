# 一 概述:
## (1)功能:
- 实现回调函数.

## (2)FunctionalInterface注解:
- 标记一个**接口**意图(intended to)是函数接口(functional interface).
- 函数接口**只能有一个抽象方法**(可以有其它非抽象方法, 但需使用**default**关键字, 因为默认接口不允许方法有body), 该抽象方法被称作功能性方法(functional method).
- 可以自定义函数接口.
- 备注: 该接口是可选, 若使用该注解, 则编译器会检查是否只有一个抽象方法,是编译器错误; 不使用则在运行时检查.

## (3)相关表达式:
- lambda表达式
- 方法引用(method reference)表达式

## (4)相关:
- java.util.function包.
- java.util.stream包.

## (5)effective

# 二 Lambda表达式:
## (1)概述:
- Evaluation of a lambda expression produces an **instance** of a functional interface. Lambda expression evaluation does not cause the execution of the expression's body; instead, this may occur at a later time when an appropriate method of the functional interface is invoked.
- lambda表达式类似函数, 提供常规参数列表和一个body(一个**表达式**或**块(block)**).
- Java语法: `参数->body.`

## (2)常见lambda表达式:
- `()->42`: 无参数, body是表达式.
- `()->{return 42;}`: 无参数, body是有return的块.
- `()->{System.out.println("hello world");}`: 无参数, body是没有return的块.
- `(int x)->x+1`: 单个声明类型参数.
- `(int x)->{return x+1;}`: 单个声明类型参数.
- `(x)->x+1`: 单个引用类型的参数.
- `x->x+1`: 单个引用类型的参数, 无圆括号(单个参数时可去掉).
- `(int x, int y)->x+y`: 多个声明类型.
- `(x, y)->x+y`: 多个引用类型.
- 备注: 注意参数列表不能混用声明类型和引用类型.

## (3)demo:
- `BiFunction<Integer, Integer, Integer> biFunction = (Integer x, Integer y)->x+y; System.out.println(biFunction.apply(10, 20));`.
- 注意:lambda是表达式不是语句, 不能直接执行.

# 三 java.util.function:
## (1)功能:
- Functional interfaces provide target types for lambda expressions and method references.

## (2)Supplier:
- 功能: 表示一个结果的供应商(supplier), 功能性方法为get.
- 函数接口: Supplier, IntSupplier, DoubleSupplier等.
- 优点(个人认为): 可以延迟计算; 可以每次get可以获得不同的值; 类似实现函数传递的策略.

## (3)Function:
- 功能: 表示一个接收一个参数并产生一个结果的函数, 功能性方法为apply.
- 函数接口: Function, IntFunction, DoubleFunction等.

## (4)Predicate:
- 功能: 表示一个参数的predicate(boolean值函数), 功能性方法为test.
- 函数接口: Predicate, IntPredicate, DoublePredicate等.

## (5)其它:
- BinaryOperator
- Consumer

# 四 方法引用表达式:
## (1)概述:
- A method reference expression is used to refer to the invocation of a method without actually performing the invocation.
- Evaluation of a method reference expression produces an **instance** of a functional interface type

## (2)语法:
- 格式: xx::方法名, 
- 备注: 详见语法规范15.13.

# 五 java.util.stream:
## (1)功能:
- Classes to support functional-style operations on streams of elements, such as map-reduce transformations on collections.

## (2)优势:
- 无存储: stream不是一个存储元素的数据结构, 它通过一个计算操作pipeline来传输(convey)数据源(例如:一个数据结构,数据,I/O channel等).
- 不删除源数据: 一个stream上的操作不会修改源数据, 例如:filter一个stream会得到一个新的stream, 而不是从源数据删除元素.
- Laziness-seeking
- Possibly unbounded
- Consumable: stream中的元素只能在stream的生命周期内访问, 类似iterator.

## (3)创建方式:
- Collection的stream()和parallelStream()方法.
- Arrays.stream(Object[])
- Stream类的静态方法, 例如:Stream.of(Object[]), IntStream(int, int)等.
- BufferedReader.lines()
- 等等.

