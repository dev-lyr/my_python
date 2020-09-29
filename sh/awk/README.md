# 一 概述:
## (1)语法:
- awk [选项] -f program-file file...
- awk [选项] program file
- 备注:awk读取文件每一行,然后执行program指定的命令;progrom可以写入文件或直接在命令行上给出.

## (2)program模块结构:
- '
- BEGIN { 起始操作程序代码,只执行一次}
- pattern { action }
- pattern { action }
- ...
- END { 结束操作程序代码,只执行一次}
- '
- action: 任意awk语句,可以省略({}也省略),若省略则等同于{print},会打印每条记录.
- 备注: BEGIN和END必须为大写.

## (3)常用选项:
- -F fs:设置输入分隔符.
- -v var=val:定义变量.
- -f file:指定program文件，替代命令行输入.

## (4)内置变量:
- FNR:当前输入文件的记录数.
- FS:字段分隔符
- RS:输入记录分隔字符
- OFS:输出字段分隔符
- ORS:输出记录分隔字符(默认为"\n")
- NF:当前记录的字段数
- NR:当前第几行.
- 备注:$0表示当前记录,$1...n表示第几个字段.

## (5)备注:
- gawk: awk的GNU实现.
- https://www.gnu.org/software/gawk/manual/gawk.html

# 二 pattern:
## (1)类型:
- BEGIN
- END
- BEGINFILE
- ENDFILE
- /regular expression/
- relational expression
- pattern && pattern
- pattern || pattern
- pattern ? pattern : pattern
- (pattern)
- ! pattern
- pattern1, pattern2

## (2)BEGIN和END:
- 两种特殊的pattern类型.

# 三 action:
## (1)概述:
- 语法: {...}.
- action语句包括: 普通语句,条件语句,循环语句和控制语句等.

## (2)控制语句:
- if (condition) statement [ else statement ]
- while (condition) statement
- do statement while (condition)
- for (expr1; expr2; expr3) statement
- for (var in array) statement
- break
- continue
- delete array[index]
- delete array
- exit [ expression ]
- { statements }
- switch (expression) {case value|regex : statement ...[ default: statement ]}
