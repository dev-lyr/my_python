# 一 概述:
## (1)种类:
- void类型
- 基本类型
- 枚举类型
- 派生类型(derived types): 数组类型, struct类型, union类型, 函数类型, 指针类型, 原子类型(atomic types).

## (2)相关限定符(qualifiers):
- const
- volatile
- restrict: linux中是__restrict.

## (3)类型转换(cast):
- 语法: (type-name) expression

## (4)变量与对齐

# 二 基本类型:
## (1)种类:
- bool: true/false, c++中的.
- char: 字符型, 一个字节.
- int: 整型.
- float: 单精度浮点数.
- double: 双精度浮点型, long double表示高精度的浮点数.

## (2)相关限定符:
- short和long:用于提供满足实际需要的不通长度的整型数, 编译器根据硬件特性自主选择合适的类型长度, 但遵循以下限制: short至少16位, long至少为32位, short不长于int, int不长于long.
- signed和unsigned: 用于限定char类型或任何整型.

## (3)备注:
- http://en.cppreference.com/w/c/language/type

# 三 结构体(struct):
## (1)概述:
- struct声明了一种数据类型.

## (2)最后一个成员是char buf[0/1]的用法:
- gcc的常用技巧, 用来构建可变长度的缓冲区. struct * A = malloc(sizeof(struct A) + buf_len).
- 相对于使用指针的优点是: 一次性分配内存(避免两次分配内存, 若第二次失败还要释放第一次), 释放也是一次释放; 一次性分配的内存也是连续的; buf不占空间, 若是指针则占空间.

# 四 联合(union)

# 五 枚举(enum)