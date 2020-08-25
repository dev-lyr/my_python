# 一 配置项：
## (1)properties：
- 功能：导入外部配置文件，可在配置xml文件中使用${var}来使用，在spring中使用@Value来使用.
- resource：相当于classpath的路径.
- url：绝对路径.

## (2)settings：
- 功能：改变MyBatis运行时行为的一些配置.
- 格式: `<settings><setting name="xxxx"  value="xxxx"><setting></settings>`

## (3)typeAliases：
- 功能：给Java类起一个别名.
- `格式1：<typeAliases><typeAlias alias="x" type="a.b.x"/></typeAliases>`
- `格式2：<typeAliases><package name="a.b"></typeAliases>`
- package可结合@Alias注解来指定别名，默认是类名，别名是不区分大小写的.
- 相关属性: SqlSessionFactoryBean的typeAliasesPackage.

## (4)typeHandlers

## (5)objectFactory

## (6)plugins

## (7)environments
- 功能：配置MyBatis.
- `格式：<environments><environment><transactionManager></transactionManager><dataSource></dataSource></environment></environments>`

## (8)databaseIdProvider

## (9)mappers：
- 功能：导入sql映射文件.
- `格式1：<mappers><mapper>...</mapper></mappers>`
- `格式2：<mappers><package name="x.y.z"></package></mappers>`
- resource属性：相对类路径.
- url属性：绝对路径.
- class属性.
- 备注: 相关SqlSessionFactoryBean的mapperLocations属性.

## (10)备注：
- 参考：http://mybatis.org/dtd/mybatis-3-config.dtd
- `<![CDATA[内容]]`: 表示内容不由xml解析, 主要用来处理特殊字符.
