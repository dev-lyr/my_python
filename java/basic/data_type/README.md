# 一 概述：
## (1)基本类型(primitive type)
- 数值类型：byte, short, int, long, char, float和double.
- boolean类型.

## (2)引用类型(三种)：
- class类型
- array类型
- interface类型
- 备注：特殊的null类型，枚举类型.

## (3)类型转换:
- 强制类型转换: `(目标类型)obj`, 转换失败会抛出ClassCastException异常, 强制转换前先使用instanceOf判断下, 避免异常.
- **instanceof**: 对象不为null且可以被转换为指定引用类型, 不抛出ClassCastException, 否则返回false, 即判断某对象的运行时类型是不是某种引用类型或其子类型.

## (3)备注：
- 经常使用object == null判断对象是否为null，避免NullPointException.
- 除非是基本类型，其它都尽量使用equal来比较，用==比较对象是个坑坑坑.

# 二 引用:
## (1)种类(强度由强到弱):
- 强引用(strong reference): 代码中普遍存在的Object a = new Object(), 强引用存在则垃圾回收器永远不会回收该对象.
- 软引用(soft reference): 在JVM内存不足时才会被回收，适合用来做内存敏感的缓存.
- 弱引用(weak reference): 当JVM进行垃圾回收时，不管内存是否足够，都会回收掉只被弱引用关联的对象.
- 虚引用(phantom reference): 对象是否有虚拟引用存在，对其生存时间没有影响，也无法通过虚引用来获得对象实例，唯一目的就是在对象被回收时受到一个系统通知.
- 备注: 每种类型对应不同的可达性水平.

 ## (2)java.lang.ref:
- 提供引用对象类，支持和垃圾回收器间有限的交互.
- 程序能在回收器决定对象的可达性改变时被通知


# 三 相等性比较：
## (1)基本类型(除float和double)：
- "=="

## (2)float和double：
- Float.compare
- Double.compare

## (3)对象引用：
- 递归调用equals方法.

## (4)备注：
- 对于对象类型，==检查是否为对象的引用.
- instanceof：检查参数是否为正常类型.

# 四 数组:
## (1)定义和初始化:
- 方法1: 类型 [] array = new 类型[size]
- 方法2: 类型 [] array = new 类型[size]{元素}
- 方法3: 类型 [] array = {元素}

## (2)特点:
- 每个数组都关联一个Class对象, 该对象的直接父类为Object, 并实现了Cloneable和Serializable接口.
- 在运行时, 若数组的赋值的类型是assignment-compatible时, 会抛出ArrayStoreException.

# 五 Class类:
## (1)概述:
- Class类的一个实例对象表示运行的Java应用中的类和接口.
- enum是一种类, 注解是一种接口, 数组和Java基本类型以及关键字void都表示为一个Class对象.

## (2)构造和获取:
- Class没有public构造函数, JVM在类加载是通过调用class loader的defineClass方法自动构造Class对象.
- 获得对象的方法: obj.getClass()或类.class.

