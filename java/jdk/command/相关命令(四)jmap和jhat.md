# 一 jmap：
## (1)功能：
- jmap prints shared object memory maps or heap memory details of a given process or core file or a remote debug server.

## (2)用法：
- jmap [options] pid
- jmap [options] executable core
- jmap [options] [pid] server-id] remote-host-or-ip

## (3)产生heap dump文件的方式：
- jmap -dump:live,format=b,file=指定目录 pid.
- -XX:+HeapDumpOnOutOfMemoryError：让jvm在OOM(outOfMemory)后自动产生dump文件.
- -XX:+HeapDumpOnCtrlBreak：使用ctrl+break键让虚拟机产生dump文件.

## (4)dump文件的分析工具：
- **jhat**: 分析Java堆dump文件, 并启动一个web服务器(端口为7000), 方便查看.
- **mat**

# 二 常用选项：
## (1)-dump:[live,] format=b, file=filename
- 功能：用hprof二进制格式将Java堆dump到指定文件.
- live：可选，表示只dump活跃对象(active objects).

## (2)-heap：
- 功能：显示堆的配置以及使用情况.

## (3)-histo[:live]：
- 功能：显示每个Java类，对象数量以及占用的内存大小.

## (4)-permstat:
- 功能: 显示持久代相关信息.

## (5)-finalizerinfo:
- 功能: 显示正在objects awaiting finalization的信息.

## (6)-F:
- 强制dump, 当-heap或-histo时pid没有响应时使用, 不过不支持live.