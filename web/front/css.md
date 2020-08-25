# 一 概述：
## (1)功能：
- CSS(Cascading Style Sheet)：层叠样式表，定义如何显示HTML元素.
- 解决了内容和表现分离的问题.
- http://www.w3school.com.cn/css/

## (2)层叠优先级(由低到高)：
- 浏览器缺省设置
- 外部样式表
- 内部样式表（位于 <head> 标签内部）
- 内联样式（在 HTML 元素内部）

## (3)备注：
- CSS规则应该每行只描述一个属性，增强样式定义的可读性.
- CSS对大小写不敏感，例外，和HTML一起的class和id是大小写敏感的.

# 二 语法：
## (1)CSS规则由两个部分组成：
- 选择器，以及一条或多条声明.
- selector {declaration1；declaration2；declarationN}
- selector(选择器)：通常是需要改变样式的HTML元素.
- declaration(声明)：由一个属性和一个值组成，被冒号分开，若值为多个单词，需加引号.

## (2)高级语法：
- 选择器分组：多个选择器共享相同的声明，例如：h1, h2, h3{color:green}.
- 跟进CSS，子元素从父元素继承属性，但并不总会work.

# 三 选择器分类：
## (1)派生选择器(上下文选择器)：
- 依据元素在其位置的上下文关系来定义样式.
- 例如：li strong{x:xxx; y:yyy}：列表中的strong元素为该格式.

## (2)id选择器：
- 可以为标有特定id的HTML元素指定特定的样式，<p id="xxx"></p>
- 以#来定义，#red{color:red}.
- 注意：id属性只能在每个HTML文档中出现一次.

## (3)id选择器和派生选择器结合：
- 例如：#sidebar p{x:xxx; y:yyy}，该样式只适用于id为sidebar的元素内的段落里.

## (4)类选择器：
- 以点号开始，例如：.center{x:xxx}，所有拥有center类的html元素适用，例如<p class="center"> </p>
- 类选择器也可以和派生选择器结合，例如：.类名 p{x:xxx}.

## (5)属性和值选择器：
- 为拥有指定属性的HTML元素设置样式，而不仅限于class和id属性.
- [title]{x:xxx}：属性选择器.
- [title=name]：属性和值选择器.

# 四 插入样式表的三种方法：
## (1)外部样式表：
- 每个页面使用<link>标签链接到样式表，<link>标签在<head>内.
- 例如：<link ref="stylesheet" type="text/css" href="mystyle.css">.
- 适用于：当样式需要应用于多个页面时候.

## (2)内部样式表：
- 使用<style>标签定义在<head>内部.
- 例如：<style type="text/css">...</style>
- 适用于：当个文档需要特殊的样式时，需使用内部样式表.

## (3)内联样式：
- 适用于：仅需要在一个元素上应用一次时，不美观，谨慎使用.
- 使用标签的style属性来包含如何css属性.
- 例如：<p style="color:read; age:20">.

## (4)混合使用：
- 按照优先级，相同的从优先级高的读取，不同的都要.