# 一映射文件:
## (1)属性：
- namespace

## (2)包含可配置项：
- cache – Configuration of the cache for a given namespace.
- cache-ref – Reference to a cache configuration from another namespace.
- resultMap – The most complicated and powerful element that describes how to load your
objects from the database result sets.
- parameterMap：已废弃.
- sql – A reusable chunk of SQL that can be referenced by other statements.
- insert – A mapped INSERT statement.
- update – A mapped UPDATE statement.
- delete – A mapped DELETE statement.
- select – A mapped SELECT statement.

## (3)使用：
- 注释：<!-- -->
- 自增字段: 若数据库支持自增，可通过useGeneratedKeys来获取对于自增字段的值，keyProperty指定获取的值设置哪些字段，批量插入时mysql不支持获取多个自增id的值.
- 单插和批量插入时都返回插入行数；单插使用useGeneratedKeys和keyProperty可以获取自增字段.
- 返回map: 方法1：对应函数写为：List<Map<类型1, 类型2>> xxx()；resultType="java.util.HashMap"; 使用MapKey注解.

## (4)备注：
- http://mybatis.org/dtd/mybatis-3-mapper.dtd

# 二 参数:
## (1)概述:

## (2)字符串替换:
- #{}: 导致mybatis创建preparedstatement参数占位符来安全设置参数(像使用?一样),更安全和迅速, 通常首选.
- ${}: 存在SQL注入风险, 适用于需要直接在SQL语句中插入一个不转义字符串情况.

# 三 sql配置项:
## (1)功能:
- 用来定义可重用的SQL代码段，可以被其它语句使用(`<include>`).

# 四 select配置项:
## (1)属性:
- id: 在命名空间中唯一的标识符.
- parameterType: 传入该条语句的参数类的完全限制名或别名，**可选**，因为Mybatis的TypeHandler能够推断出具体传入语句的参数.
- resultType: 返回结果期待类型的类的完全限定名或别名，若是集合类型，则是包含元素类型而不是集合类型; 若是map则为map. 备注: 不能和resultMap一起使用.
- resultMap: 外部resultMap的命名引用, **resultType和resultMap需要指定一个, MyBatis不会像参数一样推导**.
- flushCache: 默认为false，设为true的话，任何时候调用该语句，都会导致本地缓存和二级缓存被清空.
- useCache: 对select默认为true，导致本条语句的结果被二级缓存.
- timeout: 设置在异常抛出之前，驱动程序等待数据库返回请求结果的秒数，默认为false.
- fetchsize: 尝试影响驱动程序每次批量返回结果的函数和该值相等，默认依赖驱动.
- statementType: STATEMENT，PREPARED或CALLABLE的一个，默认为PREPARED.
- resultSetType: FORWARD_ONLY、SCROLL_SENSITIVE或SCROLL_INSENSITIVE的只一个，默认未设置，依赖驱动.
- resultOrdered.
- resultSets.

# 五 insert、update和delete配置项:
## (1)属性:
- id: 在命名空间中唯一的标识符.
- parameterType: 传入该条语句的参数类的完全限制名或别名，可选，因为Mybatis的TypeHandler能够推断出具体传入语句的参数.
- flushCache: 默认为true(insert、update和delete)，任何时候调用该语句，都会导致本地缓存和二级缓存被清空.
- timeout: 设置在异常抛出之前，驱动程序等待数据库返回请求结果的秒数，默认为false.
- useGenerateKeys: (仅对insert和update有效)，令MyBatis调用JDBC的getGeneratedKeys方法取出由数据库内部生成的主键，默认为false.
- keyProperty: (仅对insert和update有效)唯一标记一个属性，Mybatis会通过getGeneratedKeys的返回值或selectKey子元素设置它的值.
- keyColumn
- databaseId
