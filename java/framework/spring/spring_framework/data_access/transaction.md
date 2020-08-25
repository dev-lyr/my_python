# 一 概述： 
## (1)分类： 
- 事务管理策略：声明式事务管理(基于AOP)和编码式事务管理.
- global事务和local事务.
- 声明式事务：**默认只在遇到unchecked异常(RuntimeException)和Error时才会回滚，可设置**. 补充：SQLException是checked异常，默认不回滚.
 
## (2)重要类介绍：
- PlatformTransactionManager接口: 事务的具体执行，提交或回滚.
- TransactionDefinition接口：设置和获取事务相关属性.
- TransactionStatus接口：表示事务的状态, 可用来获取状态信息; 编程方式请求rollback(替代抛出异常触发的隐式rollback)等.
- TransactionTemplate和TransactionCallback.
- 包: org.springframework.transaction.support

# 二 事务相关：
## (1)事务属性(TransactionDefinition) 
- 传播行为：定义了客户端与被调用方法之间的事务边界.
- 隔离级别：定义了一个事务可能受其它事务影响的程度.
- 事务只读：设置事务是否是只读事务，只读税务可以进行合适的优化措施.
- 事务超时：设置事务的运行时间，timeout后会回滚事务。
- 回滚原则：默认情况下，事务只有遇到运行期异常时才会回滚，检查型异常不回滚。

## (2)种类：
- global事务：作用于多重数据源，常见是数据库和消息队列(JTA和EJB CMT).
- 本地事务：资源相关，比如一个和JDBC连接关联的事务.
- Spring使用通用的编程模型，不用更改代码就可以根据不同环境使用不同的事务管理策略.

## (3)隔离级别:
- ISOLATION_DEFAULT: Use the default isolation level of the underlying datastore.
- ISOLATION_READ_COMMITTED: Indicates that dirty reads are prevented; non-repeatable reads and phantom reads can occur.
- ISOLATION_READ_UNCOMMITTED: Indicates that dirty reads, non-repeatable reads and phantom reads can occur.
- ISOLATION_REPEATABLE_READ: Indicates that dirty reads and non-repeatable reads are prevented; phantom reads can occur.
- ISOLATION_SERIALIZABLE: Indicates that dirty reads, non-repeatable reads and phantom reads are prevented.

## (4)传播行为：
- PROPAGATION_MANDATORY: Support a current transaction; throw an exception if no current transaction exists.
- PROPAGATION_NESTED: Execute within a nested transaction if a current transaction exists, behave like PROPAGATION_REQUIRED else.
- PROPAGATION_NEVER: Do not support a current transaction; throw an exception if a current transaction exists.
- PROPAGATION_NOT_SUPPORTED: Do not support a current transaction; rather always execute non-transactionally.
- **PROPAGATION_REQUIRED**: Support a current transaction; create a new one if none exists.
- PROPAGATION_REQUIRES_NEW: Create a new transaction, suspending the current transaction if one exists.
- PROPAGATION_SUPPORTS: Support a current transaction; execute non-transactionally if none exists.

# 三 常用事务管理器:
## (1)概述:
- 都实现PlatformTransactionManager接口.

## (2)JDBC事务：
- DataSourceTransactionManager. 

## (3)分布式事务:
- JtaTransactionManager. 

# 四 使用方法： 
## (1)声明式事务(优先使用):
- 基于XML方式：借助tx命名空间.
- 基于注解方法(@Transactional)：需<tx:annotation-driven transaction-manager="txManager">开启.

## (2)编程式事务.
<pre><code>
    DataSourceTransactionManager dstm = new DataSourceTransactionManager(dataSource)//也可xml配置DataSourceTransactionManager为Bean.
    TransactionDefinition td = new DefaultTransactionDefinition()
    TransactionStatus status = dstm.getTransaction(td)
    try
    {}
    catch()
    {dstm.rollback(status)}
    dstm.commit(status)
</code></pre>
- 备注: TransactionTemplate支持编程事务处理类.

## (3)备注：
- 可xml配置DataSourceTransactionManager为Bean，然后通过注解引用.
- 实现原理，底层还是jdbc的commit和rollback等，将连接作为当前执行线程的私有数据(threadLocal).
