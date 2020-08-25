# 一概述:
## (1)功能:
- 提供线程本地变量, 每个线程访问(get/set)自己的变量的初始化副本.
- 通常ThreadLocal实例作为需要和线程关联状态的类的**private static成员变量**.

## (2)方法:
- get
- set
- initialValue
- remove
- withInitial(Supplier<? extends S> supplier>

## (3)内存泄露:
- 清理方法: 调用remove; 线程死亡等.