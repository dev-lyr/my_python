# 一 概述:
## (1)相关概念:
- Java运行时识别对象和类的信息的两种方式: 传统的RTTI和反射.
- RTTI: Run-Time Type Information.
- java.lang.reflect库: Method和Field等.

## (2)RTTI的三种形式:
- 传统的类型转换，由RTTI确保类型转换的正确性，若执行错误转换，则抛出ClassCastException异常.
- 使用Class对象获取运行时所需信息.
- 关键字instanceof.

## (3)反射:
- Class类和java.lang.reflect一起对反射进行支持.
- 提供根据需要加载类并找出支持的方法和构造器的功能; 构造对象; 调用方法; 访问field等.

## (4)RTTI和反射区别:
- RTTI: 编译器是在编译时打开和检查.class文件，这个类型必须在编译时可知，即在编译时必须知道所有要通过RTTI来处理的类.
- 反射: .class文件在编译期是不可获取的 (可能来自磁盘或网络)，是在运行时打开和检查.class文件.

## (5)反射缺点:
- 丧失了编译时类型检查的有点, 包括异常检查.
- 执行反射所需代码比较多.
- 性能损失, 反射比普通方法调用满很多.

# 二 Class类:
## (1)定义:
- Class: Instances of the class Class represent classes and interfaces in a running Java application.

## (2)获取Class对象三种方法:
- Class.forName("类名"): 需捕获ClassNotFoundException异常.
- obj.getClass()
- 类名.class: 简单，安全且编译期检查，建议使用.

## (3)重要方法:
- getDeclaredFields和getDeclareFields: 返回类声明的域，public、protected和private，不包含继承.
- getFields和getFiled: 返回类声明的域，只包含public.
- getDeclaredMethods和getDeclaredMethod: 返回类声明的方法，public、protected和private，但不包含继承的方法.
- getMethods和getMethod: 返回类中public方法，包含继承的.

## (4)Class对象比较:
- instanceof和isInstance(): 是这个类或该类的继承类都为True.
- equals()和==: 确切类型，不考虑继承.

# 三 java.lang.reflect:
## (1)常用类:
- Method: 类的方法.
- Field: 类的域.
- Constructor: 类构造器.