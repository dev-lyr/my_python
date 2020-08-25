# 一 struts.xml：
## (1)概述：
- struts.xml是struts核心配置文件, 通常放在webapp的classpath下.
- \<struts>\<include file="xxx">...\<package>...\</package>...\</struts>
- struts是root标签，struts下用package标签声明不同的包.

## (2)package属性：
- name：必选，主要用来被其它package引用.
- extends：继承其它packages.
- namespace: 默认的namespace为空字符串, 支持/.

## (3)include属性:
- 被包含的文件需和struts.xml格式一致.
- 一个基础的配置文件struct-default.xml被包含在strut2.jar文件中，该文件会被struts.xml自动include进去.
- https://struts.apache.org/docs/struts-defaultxml.html.

## (4)备注:
- https://struts.apache.org/docs/configuration-elements.html

# 二 package内标签：
## (1)action.

## (2)result-types

## (3)interceptors

## (4)default-interceptor-ref:
- 默认interceptor，针对所有action，若某action引入interceptor，则默认失效。

## (5)global-results:
- 全局结果集，该package内所有action都可以使用这个结果集.

## (6)global-exception-mappings:
- 全局异常，当执行action时候，会首先在action内查找exception-mapping，若没有才会global-exception-mappings中查询，都没找到则抛出异常.

# 三 action标签：
## (1)属性：
- name: 只有name属性是必须的，其它的可以在package标签声明.
- method: 指定handler类的处理方法, 默认是Action接口的execute.
- class: 默认是ActionSupport, 相关属性/<default-class-ref>.

## (2)name.

## (3)method:
- 通配符method: 一些action mapping共享使用一个pattern, 格式: \<action name="*Person" method="{1}">, 对于addPerson则执行方法为add.

# 四 interceptors标签：
## (1)interceptor功能：
- 在action被调用之前执行预处理.
- 在action被调用之后执行post处理.
- 捕捉异常保证其他操作被执行.
- 根据在stack中的定义顺序执行interceptor.
- 单个interceptor和interceptor stack可以再定义在一个stack中.

## (2)子标签：
- \<interceptor>：定义一个拦截器.
- \<interceptor-stack>：一堆拦截器组成的拦截栈.
- \<interceptor-ref>：某个action使用一个拦截器或拦截栈.

# 五 result配置:
## (1)概述:
- 当action类方法完成时, 它返回一个字符串, 该**字符串用来选择一个result元素**; 一个action Mapping通常使用不同的result代表可能的输出结果.
- ActionSupport类定义了一些标准的结果集: success, none, error, input, login.; 应用可以自定义其它结果集来匹配特定情况.
- 每个package可以使用\<result-types>设置默认result type.

## (2)result元素
- 当\<result>的type没有设置时, 框架使用默认dispatcher类型, 转发到其它web资源, 例如若资源是JSP, 则容器会使用JSP引擎渲染它, 预定义的type参考com.opensymphony.xwork2.Result接口的子类.
- 当\<result>的name未指定时, 则框架使用"success"; 可以使用*表示其它情况, 即不是success, error等情况.
- \<result>的那么可以是多个名字, 比如: \<result name="success, input">xxx.jsp\</result>等.
- \<param>用来设置type的属性, name属性表示设置result对于type的属性, \<param>的值表示用什么值来设置. 例如: type为json时, 需设置root值, \<param name="root">xxx\</param>，把xxx设置为root.

## (3)全局result:
- 可以使用\<global-results>定义多个package共享的result, 使用时优先使用局部action定义的result.

## (4)动态result:
- result可能在执行之前并不知道, 可能需要根据返回结果来确定.

## (5)返回Result对象.