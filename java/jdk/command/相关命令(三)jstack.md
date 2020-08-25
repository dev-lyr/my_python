# 一 jstack：
## (1)功能：
- 查询java进程当前时刻线程的快照，即每个线程正在执行的方法的堆栈的集合.
- jstack prints Java stack traces of Java threads for a given Java process or core file or a remote debug server.
- 主要用来定位线程出现长时间停顿的原因，例如：线程间死锁，死循环，请求外部资源导致长时间等待等.
- 线程包括：Java线程、JVM内部线程.

## (2)使用格式：
- jstack [option] pid
- jstack [option] executable core
- jstack [option] [server-id@]remote-hostname-or-ip

## (3)常用选项：
- -l：额外打印一些例如lock的信息.
- -F：强制 a stack dump，当-l没反应时.
- -m：混合模式打印(包括java和native c/c++ frames) stack trace.

## (4)备注:
- http://docs.oracle.com/javase/7/docs/technotes/tools/share/jstack.html.

# 二 输出内容:
## (1)概述:
- nid: 对应linux下轻量级线程id, ps -eLF的lwp.
