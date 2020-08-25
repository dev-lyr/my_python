# 一 概述：
## (1)功能：
- JS属于网络脚本语言，存在于web浏览器中，可用来验证表单，检测浏览器，创建cookie等更多应用，增强web站点与web应用程序之间的交互.

## (2)组成：
- 核心(ECMAScript)：与浏览器没有依赖关系，定义了JavaScript的核心语法和类型.
- 文档对象模型(DOM)：把整个页面映射成一个多层节点结构.
- 浏览器对象模型(BOM)：支持访问和操作浏览器窗口.

## (3)备注:
- https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide

# 二 HTML中使用JavaScript：
## (1)概述：
- 使用<script></script>元素，应该放在<head>元素中.
- 使用方法：内嵌或导入外部文件(src属性，建议使用).

## (2)<script>元素属性：
- type：可选，默认值为text/javascript.
- src：可选，包含要执行代码的外部文件.
- defer：表示脚本可以延迟到文档完全被解析和显示之后再执行，只对外部脚本文件有效.
- async：表示应该立即下载脚本，但不应妨碍页面中的其它操作，只对外部脚本文件有效，与defer不同，并不保证按照声明的先后顺序执行.

## (3)解析规则：
- js中会对函数定义进行预处理，然后再自上向下解析，例如：funciton methodName(){}，但var methodName=function(){}则不进行预处理.
- <script>通常存放在<head>，但造成必须等到js代码下载，解析和执行完毕后才开始显示页面内容(浏览器遇到<body>才开始显示内容)，因此现代web把一般把js放在body中内容显示的后面.