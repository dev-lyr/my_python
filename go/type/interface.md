# 一 概述:
## (1)概述:
- 接口定义了一个方法的集合, 接口可以包含**具体的方法或者其它接口**.
- 一个类型**实现**了接口: 该类型的方法集是该接口的超级(superset), 即实现了该接口的所有方法.
- 一个类型可以实现多个接口.
- 接口类型的零值为nil.
- **interface{}**: 表示空接口, 所有类型实现了该接口.

## (2)实现接口:
- 格式1: `type myInterface1 interface { method1 method2}`, 具体方法.
- 格式2: `type myInterface2 interface {interface1 interface2}`, 组合其它接口.
- 格式3: 格式1和格式2混用.

## (3)实现:
- func(t T) method1{}: T实现了接口, 可用T实例初始化接口变量.
- `func(t *T) method1{}: *T实现了接口, 可以*T实例初始化接口变量, 注意和上面的区分`.

## (4)接收者:
- A receiver base type cannot be a pointer or interface type and it must be defined in the same package as the method.
- 当接收者是一个值时, 方法接收到的是该值的拷贝, 所有修改会被丢弃.
- 接收者是指针类型时只能通过通过指针调用方法; 接收者是值时可以通过指针或值来调用; 例外: 当值是**可寻址时**可以调用指针的方法, 编译器会自动给值增加去地址操作符(&).
- 区别: https://golang.google.cn/doc/effective_go.html#pointers_vs_values
- 不可寻址: const变量, 基本类型的字面值等.

## (5)经验:
- 若一个类型仅仅为了实现某个接口而存在并且不会export接口以外的方法, 则不需要export该类型, 可以提供一个NewXXX方法返回接口类型.
- 若每个接口只有一个实现, 则不需要定义接口, 因为接口也有运行是开销.

# 二 类型assertions:
## (1)概述:
- 格式: x.(T), x是**接口类型**, T是**具体类型**或者**接口类型**.
- 功能: 检查它所指对象的类型是不是和断言的类型匹配, 判断x不是nil且存储在x中的值是类型T.

## (2)使用:
- 若assertion是false, 则发生一个运行时panic; 若断言出现在有两个结果的赋值操作中, 例如: v, ok := x.(T), 则断言为false时不会抛出一样, 而是会通过ok返回一个boolean值表示是否成功, 若ok是false, 则第一个值是被断言类型的零值.
- 常用: if v,ok := x.(T); ok{}
- 指针类型判断为: `指针.(*T)`.

## (3)用途:
- 识别特定类型, 例如: 用于error识别或者新特性判断等.
- 类型分支.
