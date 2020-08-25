# 一 resultMap属性：
## (1)属性：
- id: resultMap在当前命名空间的一个唯一标识.
- type: 类的全限定名或别名.
- autoMapping

# 二 resultMap子元素：
## (1)id/result：
- 功能: 映射一个单独列的值到简单数据类型(字符串, 日期, 整数等)的单独属性或字段,id和result唯一不同id表示的结果是比较对象实例时用的标识属性, 用来改进整体性能, 特别是缓存和嵌入结果映射.

## (2)constructor:
- 功能: 类在实例化时用来注入结果到构造函数中.

## (3)association:
- 功能: 复杂类型的关联.

## (4)collection:
- 功能: 复杂类型集.

## (5)discriminator:
- 功能: 使用结果集决定使用哪个结果映射.