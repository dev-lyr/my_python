# 一 概述：
## (1)功能：
- jQuery是一个JavaScript库.
- HTML元素的选取和操作
- HTML事件函数和HTML DOM遍历和修改
- CSS操作
- JS特效和动画.

## (2)使用：
- jQuery就是一个js文件，包含jQuery所有函数.
- 用精简版本和未压缩版本(供调试和阅读).
- 可以本地存放jQuery库或从mic和google的CDN加载.
- <script type="text/javascript" src="jquery.js"></script>

## (3)简单语法：
- 基础语法：$(selector).action(), $代表jQuery，选择符查询和查找html元素，action对元素进行操作.
- `$(this).hide()`：隐藏当前HTML元素.
- `$("#test").hide()`：隐藏id="test"的元素.
- `$(".test").hide()`：隐藏所有class="test"的元素.
- `$("p").hide`：隐藏所有`<p>`元素.

## (4)API：
- http://api.jquery.com/

## (5)备注：
- `$(function(){...})`：在dom(不包含图片)文档载入完成后执行的函数，如同：$(document).ready().
- `function($){...}(jQuery)`：类似，function(arg){...}(param)，定义了一个参数为arg的匿名函数，并将param作为参数来调用这个函数.

# 二 jQuery选择器：
## (1)元素选择器：
- jQuery使用CSS选择器来选取HTML元素.
- `$("p")`选取`<p>`元素.
- `$("p.intro")`选取所有class="intro"的`<p>`元素.
- `$("p#demo")`选取所有id="demo"的`<p>`元素.

## (2)属性选择器：
- $("[href]") 选取所有带有 href 属性的元素。
- $("[href='#']") 选取所有带有 href 值等于 "#" 的元素。
- $("[href!='#']") 选取所有带有 href 值不等于 "#" 的元素。
- $("[href$='.jpg']") 选取所有 href 值以 ".jpg" 结尾的元素。

## (3)CSS选择器:
- `$("p").css("color", "red")`：改变所有<p>元素的颜色.

# 三 jQuery事件：
## (1)概述：
- jQuery事件处理方法是jQuery中核心函数.
- 事件处理程序指当HTML中发生某些事情时调用的方法.

## (2)常用函数：
- `$(document).ready(function)`：当DOM已经加载完成，包括图像已经呈现，会发送ready事件.

# 四 Ajax
## (1)概述:
- API: https://api.jquery.com/category/ajax/

# 五 相关对象:
## (1)Deferred对象
## (2)Callbacks对象
