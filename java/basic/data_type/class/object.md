# 一 概述：
## (1)功能:
- Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.

## (2)方法：
- native getClass: 返回对象的运行时类.
- toString
- native clone：参考复制对象.
- finalize：参考析构.
- equals: Returns a string representation of the objectIndicates whether some other object is "equal to" this one.
- hashCode：Returns a hash code value for the object.
- wait和notify,notifyAll：是final方法，且必须在

# 二 toString：
## (1)功能：
- Returns a string representation of the object.

## (2)使用：
- 子类可覆盖，提供一个更可读的返回。当对象被println，printf，assert或者调试器打印出来时，toString方法会被自动调用.

# 三 equal和hashCode:
## (1)equal:
- 默认实现为this == var1, 直接比较两个引用是否指向对象.

## (2)hashCode:
- 返回对象的hash code, 默认调用本地native方法.
- 在一次Java程序执行过程中, hashCode方法必须返回一致的hash值, 但并不要求另外一次执行时对象的hash值和上次执行一致.
- 若两个对象equal相等, 则调用hashCode方法必须产生相同的hash值, 否则无法结合所有基于散列(hash)的集合一起正确运行.
- 若两个对象调用equal不一致, 此时并不要求这两个对象的hash值一定不一样, 但最好不一样, 可以提高hash表的效率.

## (3)备注:
- HashTable使用对象的hash值作为key, 在put和get元素时首先根据key的hash值找到候选对象, 然后调用==或对象的equal方法来最终确定是不是该对象.
- 若类覆盖了equal也要覆盖点hashCode.

# 四 wait和notify和notifyAll：
## (1)功能：
- wait：导致当前线程阻塞直至别的线程调用该对象notify或notifyAll方法、或者达到设置的wait时间; **该线程必须拥有该对象的monitor**，否则执行时候会抛异常:IllegalMonitorStateException.
- notify
- notifyAll

## (2)线程变成对象monitor的owner的三种方法：
- 执行该对象的同步方法：在该方法中调用上述三个方法.
- 执行该对象同步语句块：synchronize(obj){}
- 执行该对象静态同步方法：在该方法中调用上述三个方法.

## (3)备注：
- 这三个方式是final方法不能被覆盖.
