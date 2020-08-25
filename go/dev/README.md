# 一 环境变量:
## (1)查询:
- go env
- go help environment
- 修改: export GOPATH = ..等.

## (2)常用环境变量:
- GOPATH: 用来解析import语句, 若不设置, 默认为用户home下的go子目录(unix下为:$HOME/go), 格式:冒号分隔的字符串(unix), 详情go help gopath,  若使用modules，则GOPATH不再用来解析import.
- GOROOT: 指定go的安装目录和自带标准库的位置.
- GOBIN: go install安装一个命令的目录.
- GOTMPDIR: go命令用来写临时的源文件,包和二进制的目录.
- GOARCH: 编译code的架构或处理器, 例如:amd64, 386, arm等.
- GOOS: 编译代码的os, 例如:linux, windows, darwin等.
- GCCGO
- GOPROXY
- GOCACHE
- GORACE
- GOFLAGS

## (3)cgo相关相关变量
- CC
- CGO_ENABLED
- CGO_CPPFLAGS
- CGO_CXXFLAGS
- CGO_LDFLAGS
- CXX
- PKG_CONFIG

## (4)特定体系结构相关:
- GOARM
- GO386
- GOMIPS
- GOMIPS64

## (5)特定目的相关:
- GOROOT_FINAL
- GO_EXTLINK_ENABLED
- GIT_ALLOW_PROTOCOL

# 二 vim相关:
## (1)gotags:
- https://github.com/jstemmer/gotags
- 用法: gotags -f tag文件名字 -R 目录; 注意在.vimrc设置set tags=xxx; set autochdir.

## (2)vim-go:
- https://github.com/fatih/vim-go
- https://github.com/fatih/vim-go/wiki/Tutorial

## (3)tagbar:
- https://github.com/majutsushi/tagbar
- https://www.vim.org/scripts/script.php?script_id=3465
