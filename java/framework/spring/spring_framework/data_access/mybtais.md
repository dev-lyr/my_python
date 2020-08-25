# 一 对MyBatis的支持：
- http://www.mybatis.org/spring/index.html

# 二 功能： 
## (1)事务处理： 
- 不需要特殊的事务策略，Spring标准的JDBC DataSourceTransactionManager或JtaTransactionManager(分布式事务)就足够.

## (2)异常：
- Spring对ORM(对象管理映射)的异常进行封装，将checked异常转换为通用的运行时异常DataAccessException.