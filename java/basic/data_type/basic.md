# 一 基本类型：
## (1)概述：
- Java中每种基本类型所占存储空间的大小是固定的，该特性是Java可移植性强的原因之一.
- 基本类型都有**包装器类**，可以堆中创建一个包装类来表示对应的基本类型.
- JavaSE5的自动包装功能运行：基本类型和包装类间的自动转换.

## (2)高精度数字：
- BigInteger：支持任意精度的整数.
- BigDecimal：支持任意精度浮点数.

## (3)备注：
- float和double：是近似计算，没有提供精确结果，不适用于需要精确结果的地方，float a =1.0f，后面要强制使用f，不使用f则为double类型.
- Java1.5提供了自动装箱和拆箱功能，**当混合使用装箱类型和基本类型时，装箱类型就会自动拆箱**.
- 基本类型也有Class对象, 例如:int的Class对象可通过int.class或Integer.TYPE来获得.

# 二 基本类型和装箱类型：
## (1)区别：
- 基本类型只有值，装箱类型具有与他们值不同的同一性，两个装箱类型可能有相同的值和不同的同一性。
- 装箱类型还有一个null.
- 基本类型比装箱类型更节省空间和时间.

## (2)装箱类型的用途：
- 作为集合中的元素、键或值时.
- 参数化类型中必须使用装箱类型作为类型参数.
- 进行反射方法调用时，必须使用装箱类型.
- 函数重载时, 基本类型和装箱类型是不一样的.

## (3)经验：
- 优先使用基本类型，基本类型简单且高效.
- 对于装箱类型，==操作比较的是同一性，而不是值.

## (4)比较:
- int a =10; Integer b = new Integer(10); a==b为true, b会被拆箱.
- Integer a = 10; Integer b = new Integer(10); a==b为false.
- Integer a = new Integer(10); Integer b = new Integer(10); a==b为false.

# 三 封装类型的cache: 
## (1)概述:
- 一些封装类型会cache一些常用值避免重复创建对象, 比如Integer.IntegerCache会在初始化时候缓存-128到127的Integer对象,**当遇到Integer a = 10或Integet.valueOf(10)时会优先使用cache中的对象, 若不在cache才会重新new对象.**
- 其它提供cache的封装类型有: Short, Boolean(Boolean.True, Boolean.False), Long, Character等.

## (2)备注:
- 优先使用XXX.valueOf可以避免创建临时对象, **使用new XXX()不会使用cache.**
- 注意: 包装类型的++等操作会导致对象变, 例如: Integer i = new Integer(10); ++i, i会指向11对应的cache对象.
