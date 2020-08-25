# 一 概述:
## (1)概述:
- Go使用一个轻量级测试框架, 该框架由**go test**命令和**testing**包组成.

## (2)使用方法:
- `创建一个以_test.go结尾的文件, 该文件包含的以TestXxx命名和signature为func(t *testing.T), 注意:函数名字Test后以大写开头.`
- 测试框架会运行上面的函数, 当函数调用一个失败函数(例如:t.Error或t.Fail)则测试被认为是失败的.

## (3)测试文件的三种特殊函数:
- 功能测试函数: 以Test开头, 参数为`t *testing.T`.
- 基准测试函数: 以Benchmark开头, 参数为`b *testing.B`.
- 示例函数: 以Example开头, 无参数.

## (4)Main:
- 适用于: 在测试执行前做一些setup以及测试后做些清理工作.
- 格式: 若一个测试文件包含`func TestMain(m *testing.M)`函数, 则会直接调用TestMain函数替代直接运行测试.

## (5)备注:
- https://golang.org/pkg/testing/

# 二 go test:
## (1)概述:
- 语法: `go test [build/test flags] [packages] [build/test flags & test binary flags]`
- go help testflag

## (2)运行模式:
- local目录模式: 不指定packages, go test编译当前目录下的包里的源文件和测试并且运行产生的test binary, 在该模式下cache是disable.d.
- package list模式: 指定packages.
- 备注: 在package list模式下, go test会cache测试结果避免重复测试(有一定条件).

## (3)testflag:
- -v: 详细的输出.
- -run: 只测试指定函数, 例如: go test -v -run="Test1|Test2".
