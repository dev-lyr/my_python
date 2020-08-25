# 一  概述：
## (1)概述：
- 所有枚举类型是Java中Enum类的子类,枚举类型E的直接父类为Enum<E>.
- 当需要一组固定常量时就需要枚举.

## (2)特点：
- enum的构造函数只能为private，其它函数没有限制，在构造枚举常量时被调用.
- 内嵌枚举类型隐式为static.
- enmu的equal是==.

# 二 java.lang.Enum类： 
## (1)概述：
- 所有枚举类型的公共基类，extend Object类，实现了Serializable和Comparable接口.

## (2)常用方法：
- ordinal
- toString
- name
- valueOf
