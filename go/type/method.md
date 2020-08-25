# 一 方法:
## (1)概述:
- 定义: oo中的概念, 某种特定类型的函数.
- 语法: 与函数语法类似, 只是在函数名前多了一个参数(receiver), 该参数把这个方法绑定到指定这个参数对应的类型上.

## (2)为类型定义方法:
- 可以对包中的任意类型定义方法, 但不能对基本类型和来自其它包的类型定义.
- 语法: func (接收者类型T) 函数名(参数) 返回类型 {}, T不能为指针类型或接口类型.
- 备注: The receiver is specified via an extra parameter section preceding the method name. That parameter section must declare a **single** non-variadic parameter, the receiver. Its type must be a defined type T or a pointer to a defined type T. A receiver base type **cannot be a pointer or interface type** and it must be defined in the **same package** as the method. 

## (3)接收器的类型:
- T
- * T: 基于指针对象的方法, 当接收器本身对象比较大时, 可以用其指针而不是对象来声明方法.
- 备注: 若类型T有一个指针作为接收器的方法, 则所有T的方法都需要有一个指针接收器(约定).
- 备注: 接收器类型形参和实参不相同, 例如:形参是T,实参是`*T`, 或者反之, 编译器都会执行相关隐式转换, 可以统一使用**变量.方法()**调用对应方法.
- 备注: 可以为任意named type(除了指针和接口)定义方法.
