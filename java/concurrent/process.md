# 一 概述： 
## (1)创建进程的两种方法： 
- ProcessBuilder：创建操作系统进程.
- Runtime.exec()

## (2)Process：
- ProcessBuilder.start()或Runtime.exec()创建的本地进程会返回一个Process对象操纵和查询它的信息.
- 默认情况下，创建的进程没有自己的终端或控制台，所有的标准IO会重定向到父进程.