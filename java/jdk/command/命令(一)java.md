# 一  用法:
## (1)用法:
- 执行一个类: java [-option] class [args...]
- 执行一个jar文件: java [-option] -jar jarfile [args...]

## (2)选项分类:
- Standard Options
- Non-Standard Options
- Advanced Runtime Options
- Advanced JIT Compiler Options
- Advanced Serviceability Options
- Advanced Garbage Collection Options

## (3)参考:
- https://docs.oracle.com/javase/8/docs/technotes/tools/windows/java.html

# 二 常用标准选项:
## (1)-D<name>=<value>: 设置系统属性。
- 获取系统属性: System.getProperty.
- 设置系统属性: System.setProperty.

## (2)-classpath classpath或-cp classpath:
- 设置搜索类的目录、jar文件或zip压缩文件.
- 备注: 也可设置CLASSPATH环境变量.

## (3)-jar filename:
- 功能:执行封装在JAR文件中的程序; filename是一个manifest包含Main-Class:classname(定义一个包含public static void main(String []args方法)的类, 该类作为程序的启动点.
- 当使用-jar时, 该JAR文件表示所有用户类, 其它class path设置会被忽略.

## (4)agent相关:
- -agentlib:libname[=options]: 加载指定的native agent库, 在库名之后可以指定逗号分隔的选项列表. 例如:-agentlib:foo指定, 则JVM会尝试在LD_LIBRARY_PATH系统变量指定的目录去加载libfoo.so库.
- -agentpath:pathname[=options]: 加载绝对路径下的native agent库.
- -javaagent:jarpath[=options]: 加载指定的Java语言agent.

# 三 非标准选项(-X:不要求所有vm都实现):
## (1)常用:
- -Xms<size>: 设置java初始的heap size.
- -Xmx<size>: 设置java最大的heap size.
- -Xss<size>: 设置java线程stack size.
- -Xmn<size>: 设置年轻代内存大小.

# 四 非稳定选项(-XX):
## (1)查询和设置:
- 查询所有: java -XX:+PrintFlagsFinal.
- bool型的选项: -XX:+<option>开启; -XX:-<option>关闭.
- 数值型的选项: `-XX:<option>=<number>`.

## (2)常用:
- -XX:PermSize: 设置初始化永久代内存.
- -XX:MaxPermSize: 设置最大允许的永久代内存的大小.

# 五 系统属性:
## (1)获取和设置系统属性:
- System.getProperties(): 获取.
- System.setProperties(): 设置.
- java -Dxxx=yyy: 设置.

## (2)常用属性:
- java.io.tmpdir: Jvm创建和存储临时文件的目录.
- java.library.path: 指定库文件所在路径，例如动态库文件libxxx.so.

# 六 环境变量:
## (1)获取和设置环境变量:
- System.getEnv(): 获取环境变量.

## (2)常用环境变量:
- JAVA_HOME
- JAVA_PATH
- CLASSPATH
- LD_LIBRARY_PATH: 指定库文件地址.