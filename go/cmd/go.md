# 一 概述:
## (1)功能:
- 操作go源码的工具.
- 语法: go command [arguments]

## (2)常用命令:
- build: 编译包和依赖.
- install: 编译并安装包和依赖.
- get: 下载并安装包和依赖.
- run: 编译和运行go程序.
- fmt: 规范代码.
- list: 列出包或模块.
- mod: module maintenance.
- test: 测试包.
- tool: 运行指定的go工具.
- env: 打印出环境变量信息.
- generate
- doc: 显示包和符号的文档.
- clean: 移除对象文件.

## (3)go help:
- go help command/其它主题.

# 二 go build:
## (1)功能:
- 编译包和依赖, 不安装.

## (2)用法:
- go build [-o output] [-i] [build flags] [packages].
- -o设置输出文件的名字, 只允许在build单个包时使用.
- -i安装target依赖的包. 
- build flags: 被 build, clean, get, install, list, run和test命令共同使用.

## (3)build flags:
- -a: 强制build所有包, 即使是最新的.
- -buildmode mode: 编译mode, 详情go help buildmode.
- -compiler name: 使用的编译器, 可选gc和gccgo.

## (4)备注:
- 当build一个单独main包, build会生成一个可执行的结果文件.
- 当build多个包或单个非main包, build会编译包但会丢弃结果对象, 只是检查下包是不是可以被编译.
- 当build时会忽略以**_test.go**结尾的文件.

# 三 go install:
## (1)功能:
- 编译和安装包.

## (2)语法:
- go install [-i] [build flags] [packages]
- -i: 安装包的依赖.

# 四 go run:
## (1)语法:
- go run [build flags] [-exec xprog] gofiles... [arguments...]
- build flags参考二(2).

# 五 go get:
## (1)功能:
- 下载指定的packages以及它的依赖, 然后安装packages.
- `go get [-d] [-f] [-t] [-u] [-v] [-fix] [-insecure] [build flags] [packages]`
- 当checkout新包时, 会在GOPATH/src/<import-path>下创建目标目录.

## (2)选项:
- -d: 只下载不安装.

