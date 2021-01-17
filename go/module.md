# 一 概述:
## (1)功能:
- module是一些相关联的go packages的集合. 
- 在module-aware模式下, GOPATH不再定义import方式, 但它仍然会存放下载的依赖(在GOPATH/pkg/mod)和安装的命令(在GOPATH/bin, 除非GOBIN被设置).

## (2)module组成:
- 由一个源文件树和一个go.mod文件组成, go.mod文件在树的root目录, 包含go.mod文件的目录被称为**module root**, 不包含有自己go.mod文件的subtree.

## (3)相关名词:
- **module root**: 包含go.mod文件的目录.
- **module path**: **import path prefix** corresponding to the module root, go.mod定义module path.
- **main module**: go命令执行的目录, go命令会从当前目录以及父目录来寻找go.mod.

## (4)备注:
- GO111MODULE: off, on(module-aware), auto(默认). auto或unset: 则go基于当前的目录判断是否支持module, 若当前目录在$GOPATH/src之外且它自己包含go.mod文件或属于一个包含go.mod文件的目录下则支持module.
- GOPROXY=https://goproxy.io: 设置一个代理地址用于下载包.

# 二 go.mod文件:
## (1)概述:
- go help go.mod
- go command automatically updates go.mod each time it uses the module graph, to make sure go.mod always accurately reflects reality and is properly formatted.

## (2)格式:
- go mod每行有一个指令(directive), 指令由verb和参数组成.
- comment格式//.

## (3)verb类型:
- **module**: 定义module path.
- **go**: 设置期望的语言版本.
- **require**: require a particular module at a given version or later.
- **exclude**: exclude a particular module version from use.
- **replace**: replace a module version with a different module version.

# 三 go mod:
## (1)功能:
- Go mod provides access to operations on modules.

## (2)语法:
- go mod <command> [arguments]

## (3)command:
- download: download modules to local cache.
- edit: edit **go.mod** from tools or scripts.
- graph: print module requirement graph.
- init: initialize new module in current directory.
- tidy: add missing and remove unused modules.
- vendor: make vendored copy of dependencies.
- verify: verify dependencies have expected content.
- why: explain why packages or modules are needed.
