# 一 经验：
## (1)常用:
- 传入多个参数时需使用@param限制参数，单个会自动判断.
- update和insert和delete返回影响行数量.
- 插入时使用的DO对象，会被填充为插入数据库的对象，即可以获得自动id等信息(要是有useGeneratedKeys和keyProperty).
- 可使用foreach实现批量插入和修改等，批量插入时参数为List，DO对象的id不会被填充，无法获得自动递增的id。
- 当返回值为对象时，若没有查到返回null；若返回值为list，若没有查找则返回空的list.
- #{}和?是安全的, ${}有sql注入风险.

## (2) 使用方式(推荐使用2)：
- 写xxx-mapper.xml，写dao和daoimpl，最原始方法.
- 不写daoimpl，使用mybatis-spring的注入注解器.
- 最方便，使用@Select等注解，不用写xxx-mapper.xml，但是该方式缺点较多，没有数据库字段到DO的映射，要求DO和数据库字段一致，同时不适合写一些复杂的sql语句.

# 二 异常：
## (1)ibaits：
- 抛出java.sql.SQLException异常，属于checked exception，强制捕捉.

## (2)spring的SqlMapClientTemplate：
- 将checked异常SQLException转为unchecked DataAccessExceptions异常.
