# 一 RandomAccess:
## (1)功能:
- Lists使用的标记接口, 表示支持快速的随机访问, 主要目的是允许算法遇到可随机访问的队列时改变行为从而提高更好的性能.

# 二 Cloneable接口:
## (1)功能:
- 实现该接口则表示Object.clone方法的按域(field copy)是合法的，若不实现该接口，则调用Object.clone方法会抛出ClassNotSupportedException.

## (2)用法:
- 通常，实现该接口的类会用一个public方法覆盖Object.clone方法，详情参考复制对象.

# 三 Serializable接口:
## (1)功能:
- 实现该接口则表示该类是可序列化的.

# 四 Itetable接口:
## (1)功能:
- 实现该接口表示该对象可以for-each循环.

# 五 Comparable接口和Comparator:
## (1)功能:
- Comparable：该接口为实现该接口的类的对象提供全排序(变成可比较对象)，compareTo方法被用来进行比较.
- Comparator: 属于函数接口，比较函数，可以作为一些排序方法的参数(例如: Collections.sort).

## (2)Comparable使用:
- int compareTo(T o): 负数、0、正数分别表示小于、等于和大于.
- Collections.sort或Arrays.sort可对实现该接口的类的对象进行排序.

# 六 Annotation接口:
## (1)功能:
- 所有注解类型的公共接口.

# 七 AutoCloseable和Closeable接口:
## (1)功能:
- AutoCloseable: 一个持有资源的对象(例如:file或socket)直至资源被关闭，若使用try-with-resource块定义这些资源对象，则close方法会在退出try-with-resource块时自动调用.
- Closeable: 继承AutoCloseable(1.7之后)，表示一个可以被关闭的额数据源或目的对象.

# 八 FunctionalInterface:
## (1)功能:
- An informative annotation type used to indicate that an interface type declaration is intended to be a functional interface as defined by the Java Language Specification.