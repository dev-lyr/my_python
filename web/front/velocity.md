# 一 概述：
## (1)功能：
- Velocity is a Java-based template engine.

## (2)备注：
- http://velocity.apache.org/engine/devel/

# 二 VTL(Velocity Template Language)：
## (1)功能：
- 在web页面嵌入动态内容.
- velocity使用引用来嵌入动态内容，一个变量是引用的一种.
- 变量可以引用Java code中定义的，也可以从web页面的VTL #set语句定义.

## (2)VTL引用类型：
- 变量：定义，#set($name="lyr")；使用，$name.
- 属性
- 方法
- 使用: $var: 变量未定义时打印本身; ${var}：同上，{}只不过是分割变量和联系字符串，比如：${var}var2; $!var：变量未定义时打印空字符串; $!{var}：同上，{}只不过是分割变量和联系字符串，比如：$!{var}var2.

## (3)注释：
- ##：单行注释.
- #* ... *#：多行注释.
- #**...*#：注释块.

## (4)指令(Directives)：
- #set：设置引用的值.
- #[[not prase me]]#：velocity不解析里面内容.
- #if，#elseif，#else，#end
- #foreach.
- #include：导入一个本地文件，例如：a.git等.
- #parse：导入一个本地VTL文件，例如：person.vm.
- #define：把一个VTL语句块赋值给一个引用.
- 备注：#set指令没有#end语句，其它都有#end语句.

## (5)宏(macro)
- #macro: allows you to name a section of a VTL template and re-insert it multiple times into the template.
- http://people.apache.org/~henning/velocity/html/ch07.html