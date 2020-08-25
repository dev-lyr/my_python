# 一 概述： 
## (1)常用持久化框架： 
- JDBC
- Hibernate
- Ibatis/MyBatis
- JPA
- 等等，Spring能够支持所有持久化框架.

## (2)数据源配置方式(即dataSource的配置)：
- 通过JDBC驱动程序定义数据源
- 通过JNDI查找的数据源
- 连接池的数据源

## (3)用占位符(即${}):
- 单独的ibatis：可在sqlmap_config中<properties resource="xxx"或url="xxx"/>来提供基于${}的变量值.
- spring和ibatis结合则需要：类型为PropertyPlaceholderConfigurer的一个bean，并发配置文件地址注入到location属性中.

## (4)异常：
- DataAccessException.

# 二 数据源配置： 
## (1)基于JDBC驱动配置：简单，但性能低.
- spring提供了两个数据源对象(org.springframework.jdbc.datasource包)：
- DriverManagerDataSource：每个连接请求都返回一个新建的连接，没有进行连接池管理.
- SingleConnectionDataSource：每个连接请求都会返回一个新建的连接，可视为只有一个连接的池.
- 适合小程序，不适合生产环境，性能较差，建议使用有数据源连接池.
- `<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">`
        	`<property name="driverClassName" value="com.mysql.jdbc.Driver"/>`
        	`<property name="url" value="jdbc:mysql://localhost:3306/lyr" />`
        	`<property name="username" value="root"/>`
        	`<property name="password" value="123456"/>`
`</bean>`

## (2)数据源连接池:
- (DBCP：https://commons.apache.org/proper/commons-dbcp/)：提供多个具有连接池功能的数据源, 其中BasicDataSource最常用.
- `<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
   <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        	<property name="url" value="jdbc:mysql://localhost:3306/lyr" />
        	<property name="username" value="root"/>
        	<property name="password" value="123456"/>
</bean>`

## (3)通过JNDI查找的数据源.