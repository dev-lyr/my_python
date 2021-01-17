# 一 概述:
## (1)概述:
- 每个go源文件开头必须有包声明语句, 包名和导入路径的**最后一个目录**一致, 包语句: **package 包名**.
- import语句必须跟在文件package声明之后, 随后才是函数,变量,常量,类型的声明语句.
- 每个go程序都由包组成, 程序运行的**入口包是main**.
- 名为main的包用来定义一个可执行程序, 而不是库.
- **首字母大写的名称是被导出的, 导入包时候只能访问导出的名称.**

## (2)包导入方式:
- import "包"
- import ("包1" "包2")
- 备注: 第二种更常见, 在第二种中可以用空格来区分不同组织的包.

## (3)使用方式:
<pre><code>
import   "lib/math": 常规, math.Sin.
import m "lib/math": 别名, 避免两个同名包冲突, m.Sin.
import . "lib/math": 省去包名直接使用,Sin.
import _ "lib/math": 匿名导入(空导入), 不能访问包内的成员, 用于计算包级别初始化表达式和执行导入包的init函数情况时使用.
import ../xxx或./xxx: 支持相对路径import.
</code></pre>

## (4)包种类:
- 类型:标准库包和其它包.
- 备注:https://golang.org/pkg/

## (5)搜索顺序:
- GOROOT
- GOPATH

## (6)包管理工具:
- go mod
- dep
- go vendor

## (6)预留包名:
- main: 特殊的包, 用来定义一个独立的可执行程序而不是库.
- std
- cmd
- all

## (7)备注:
- 为了避免命名冲突以及方便查找, 除了标准库包以外, 其它的导入路径建议以互联网域名为路径开始.
- go help packages

# 二 包初始化:
## (1)变量初始化

## (2)init函数

# 三 import path:
## (1)概述:
- go help importpath
- go help packages

## (2)相对路径

## (3)remote导入路径

# 四 相关:
## (1)目录:
- src: 存储源代码, src下的路名决定了**import路径或执行名字**.
- pkg: 用于保存编译后的包的目标文件, 每个目标os和architecture有自己的目录, 格式为:pkg/GOOS_GOARCH.
- bin: 用于保存编译后的可执行文件.
- vendor: 用于存储依赖包固定版本的源代码.
- internal: 只能和internal包同一父目录的包导入.

## (2)GOPATH:
- 用来指定当前的工作空间, 包含src, pkg和bin三个目录.
- 唯一必须要配置的变量.
- go help gopath
- **当使用module时, GOPATH不再用来解析import**.

## (3)GOROOT:
- 指定go的安装位置, 以及标准库的位置.

