# 一 概述：
## (1)功能:
- http://www.mybatis.org/spring/zh/index.html

## (2)相关配置:
- `<mybatis:scan base-package="xxxx.mapper"/>`: 让spring发现mybatis mapper并注入.

# 二 SqlSessionFactoryBean：
## (1)功能：
- 创建sqlSessionFactory，随后可使用sqlSessionFactory来创建sqlSession，sqlSession可用来执行具体的映射语句.

## (2)属性：
- dataSource
- configLocation：MyBatis配置文件mybatis_config.xml.
- mapperLocations：具体的mapper xml文件.
- configuration
- typeAliasesPackage: 搜索类型别名的package.
- typeAliases

## (3)使用SqlSessionFactory的类：
- SqlSessionTemplate：是Mybatis的核心，线程安全，可被多个Dao共享.
- SqlSessionDaoSupport.

## (4)备注：
- 使用注入映射器，避免使用SqlSessionDaoSupport或SqlSessionTemplate手工编写DAO实现代码.