# 一 概述:
## (1)功能:
- go的依赖管理工具.

## (2)备注:
- https://golang.github.io/dep/
- https://github.com/golang/dep

# 二 用法:
## (1)语法:
- dep [command]
- dep help command

## (2)command:
- init: 初始化一个新的go项目, 或者migrate一个已存在的.
- status: 报告项目依赖的status.
- ensure: Ensure a dependency is safely vendored in the project
- check: Check if imports, Gopkg.toml, and Gopkg.lock are in sync
- version: Show the dep version information.
