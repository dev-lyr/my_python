# 一 概述： 
## (1)特性：
- String对象是不可变的，String类中没有提供修改对象字符串值的方法, 都是创建一个全新的String对象.
- 每个双引号字符串都代表一个String的实例.
- 不可变优点: 编译器让字符串共享(存储在公共存储区域), Java设计者认为共享带来的优点要多于修改带来的低效率.
- String不能通过==来比较内容是否相等，要使用str1.equals(str2).
- String str1 = "test", str1=="test"为true；str1==new String("test")为false.

## (2)字符串输出：
- System.out.println方法
- System.out.format方法
- System.out.printf方法：同上，格式化输出，类似C的printf.
- String.format方法：返回一个格式化拼接的String对象.
- java.util.Formatter类.

## (3)字符串输入：
- Scanner类
- Console类

## (4)正则表达式：
- java.util.regex

## (5)相关类：
- StringBuilder(推荐使用): 速度更快(执行没有同步),适合单线程.
- StringBuffer(线程安全)
- org.apache.commons.lang.StringUtils

# 二 使用： 
## (1)常用方法：
- format: 性能差.
- equals
- valueOf：static方法，把基本类型转为string.

## (2)字符串连接:
- 请使用StringBuilder来代替字符串的+连接操作,原因是字符串不可变,+连接操作会导致字符串被拷贝.
- format方法性能很差, 不适用于大量字符串连接.

## (2)经验:
- 当数据从文件、网络或键盘进入程序后，通常以字符串形式存在，只有的确是文本信息时才继续保留这种格式，若是其它类型，则应该转换为适当的类型。
