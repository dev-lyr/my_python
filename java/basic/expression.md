# 一 Lambda表达式:
## (1)概述:
- lambda表达式类似函数, 提供常规参数列表和一个body(一个**表达式**或**块(block)**).
- Java语法: 参数->body.

## (2)常见:
- `()->42`: 无参数, body是表达式.
- `()->{return 42;}`: 无参数, body是有return的块.
- `()->{System.out.println("hello world");}`: 无参数, body是有return的块.
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

## (4)相关:
- FunctionalInterface注解: 标记一个**接口**是函数接口(functional interface).
- java.util.function包.

# 二 运算符(Operator):
## (1)关系运算符:
- <, <=, >, >=, ==, !=.

## (2)位运算符:
- &
- |
- ^
- ~
- >>
- >>>
- <<

## (3)条件运算符:
- &&
- ||

