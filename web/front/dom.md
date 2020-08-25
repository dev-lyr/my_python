# 一 概述：
## (1)功能：
- DOM：Document Object Model，文档对象模型.
- HTML DOM定义了访问和操作HTML的标准方法，DOM将HTML文档表述为树结构.
- DOM是介于平台和语言的接口，允许程序和脚本动态的访问和更新文档的内容、结构和样式.

## (2)组成：
- 核心DOM：针对任何结构化的文档的标准模型.
- XML DOM：针对XML文档的标准模型.
- HTML DOM：针对HTML的标准模型.

## (3)备注：
- document对象是HTMLDocument(继承Document类型)的一个实例，表示整个HTML页面，且document对象时window对象的一个属性，因此可作为全局对象来访问.

# 二 HTML DOM：
## (1)功能：
- 定义了所有HTML元素的 对象和属性以及访问它们的方法.
- 在HTML DOM中所有事物都是节点，DOM是被视为节点树的HTML.
- 可通过js等脚本语言对HTML DOM进行访问.

## (2)节点：
- 整个文档是一个文档节点
- 每个 HTML 元素是元素节点
- HTML 元素内的文本是文本节点
- 每个 HTML 属性是属性节点
- 注释是注释节点

## (3)HTML DOM对象常用方法：
- getElementById(id) - 获取带有指定 id 的节点（元素）
- appendChild(node) - 插入新的子节点（元素）
- removeChild(node) - 删除子节点（元素）

## (4)HTML DOM对象常用属性：
- innerHTML - 节点（元素）的文本值
- parentNode - 节点（元素）的父节点
- childNodes - 节点（元素）的子节点
- attributes - 节点（元素）的属性节点