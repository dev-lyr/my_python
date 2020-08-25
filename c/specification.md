# 一 概述:
## (1) 备注:
- 差异较大，选择适合自己的，坚持下去.

## (2)参考:
- https://google.github.io/styleguide/cppguide.html 

# 二 头文件相关:
## (1)#define保护：
- #define防止头文件被多重包含(multiple inclusion)。
- 格式：`<PROJECT>_<PATH>_<FILE>_H_`，项目的全路径，保证了唯一性。

## (2)#include顺序：
- 相关头文件：比如a.c导入a.h.
- c库
- c++库
- 别的库
- 项目的.h文件.
- 备注: 需要根据情况判断是否导入某个头文件时(例如：#ifdef XXX #inlcude x.h #endif)，该#include文件放在最后.

# 三 变量命令：
## (1)普通变量：
- 局部变量：xx_yy
- 全局变量：xx_yy或g_xx_yy
- 静态变量：static int xx_yy.

## (2)常量：
- #define MAX_NUM 100
- const int MAX_NUM 100

## (3)函数：
- 例如：get_name().

## (4)类型命名:
- struct/class xx_yy
- struct/class XxxYyy
