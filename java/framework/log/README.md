# 一 概述：
## (1)通用的日志框架：
- apache的commons-logging：不依赖日志系统的实现.
- SLF4J(Simple Logging Facade for Java)：a simple facade or abstraction for various logging frameworks.

## (2)具体日志实现：
- Log4j
- JUL(Java.util.logging): JDK包含.
- LogBack: Log4J的继承者,性能更优.

## (3)备注:
- commons-logging不能支持logback, 需jcl-over-slf4.
- 常用搭配: commons-logging和Log4J, SLF4J和LogBack.
- 注意: 在高并发情况下写日志对性能的影响.

# 二 commons-logging：
## (1)功能：
- 可以在不重新编译的情况下改变不同的日志实现.

# 三 SLF4J:
## (1)概述:
- https://www.slf4j.org/docs.html

## (2)经验:
- 优先使用{}来匹配字符串, 性能最好. 
- 异常以error方式记录, 且最好增加描述性信息, 而不仅仅是记录异常本身.
- logger是不是static: 各有优势, 使用static.
- 参考:https://www.slf4j.org/faq.html#logging_performance.
