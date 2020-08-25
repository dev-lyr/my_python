# 一 System类：
## (1)功能：
- 提供标准输入(in)、输出(out)和出错(err).
- 访问外部定义的属性和环境变量.
- 提供加载文件和类库的方法.
- 等等.
- 部分方法调出调用Runtime类的方法.

## (2)常用方法：
- currentTimeMillis()
- lineSeparator()：返回系统的行分割字符串.
- getenv()和getenv(String name)
- getProperties和getProperty
- setProperties和setProperty
- getSecurityManager和setSecurityManager
- load和loadLibrary：加载本地库.

# 二 Runtime类：
## (1)功能：
- 每个Java应用都有一个单例的Runtime对象，通过它应用与它运行的环境进行交互.
- Runtime.getRuntime获取该对象，应用不能创建自己的Runtime类对象.

## (2)常用方法：
- availableProcessors()
- exec()
- freeMemory()和totalMemory()
- load()和loadLibrary()
- gc(): 主动触发full gc, 默认生效, 使用-XX:-DisableExplicitGC可设置为不生效.
- exit()

# 三 sun.misc包:
## (1)Unsafe

## (2)信号相关:
- Signal
- SignalHandler