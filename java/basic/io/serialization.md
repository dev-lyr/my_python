# 一 Java Serializable：
## (1)功能：
- 把Java对象转换为字节序列，并从字节序中转换为Java对象的过程.
- 对象持久化.
- 实现对象深拷贝的一种方法.
- RMI和网络中传输对象.
- 需实现Serializable接口.

## (2)序列号：
- private static final long serialVersionUID = xxxx;

## (3)transient关键字：
- 标记某些域是不可序列化的.

## (4)备注：
- 对象重新加载时，它可能占据与原来不同的内存地址，因此不能用地址来表示对象，每个对象都用一个序列号来保存，使用该对象的对象引用都关联一个序列号.
- serialver命令.
- **只能在Java程序之间使用**.
- 其它: JSON序列化, 可以与其他语言一起使用, 但可能性能没有Java序列化好.

## (5)相关:
- ProtoBuf
- Thrift
- JSON
- Netty
- Hessian

# 二 序列号：
## (1)概述：
- 序列号ID是数据域类型和方法签名的指纹，是通过对类、超类、接口、域类型和方法签名按照规范方式排序，然后进行安全散列算法(SHA)得到的.
- 序列化机制只使用SHA码前八个字节作为类的指纹.
- 类变化对应的SHA也会变化，为了对早期版本保持兼容，就必须知道早期版本的SHA码.
- 若类具有serialVersionUID，则不需要再计算指纹，这样序列化系统可以读入这个类的对象的不同版本.
- 对象流拒绝读入具有不同指纹的对象，因此为了兼容性还是需要在类中指定serialVersionUID，这样指纹就不会随着类的变化而变化.

## (2)解析对象：
- 类的方法产生变化时，在读入新对象数据时才不会有任何问题.
- 若数据域发生变化，就可能有问题，对象流将尽力将对象转换为当前类的版本(在serialVersionUID相同的前提下).

## (3)数据域解析：
- 对象流只考虑非瞬时和非静态的数据域，若名字匹配而类型不匹配，那么对象流不会尝试将一种类型转换为另外一种类型.
- 若当前版本具有对象流中没有的数据域，那么新添加的域被设置为默认值(对象为null，值为0，boolean为false).
- 若对象流有，而当前版本类中没有，那么对象流将忽略该域.

# 三 JSON序列化:
## (1)概述:
- 无需实现Serializable接口.
- 会首先调用无参数构造函数(不声明构造函数或显式声明一个无参构造函数), 再一次调用setXXX.