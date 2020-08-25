# 一 java.lang.Throwable类：
## (1)概述：
- Java中所有exceptions和errors的超类，只有该类或其子类的实例才能被JVM或throw语句抛出，同样只有该类或其子类才能为catch语句的参数.

## (2)常用方法：
- printStackTrace和getStackTrace.

## (3)使用指南：
- 早抛出晚捕获.
- finally中不要包含return, 否则异常不会被抛出.

# 二 Throwable类类别：
## (1)Error：
- 表示编译时和系统错误(一般不用关心)，是程序无法处理的错误，例如jvm运行错误，内存资源不够(OutOfMemoryError)等.
- Error表示一些不该发生的严重错误, 不要尝试去catch.

## (2)Exception：
- 可以被抛出的基本类型，在Java类库、用户方法以及运行时故障中都可能抛出Exception异常。
- The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions.
- Checked exceptions need to be declared in a method or constructor's throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.

## (3)常用方法：
- printStackTrace(): Prints this throwable and its backtrace to the standard error stream.

# 三 Exception种类：
## (1)RuntimeException(运行时异常,"unchecked exceptions"):
- is superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.
- 运行时异常会被自动捕获。
- 注意:只能在代码中忽略RuntimeException(以及其子类)类型异常，其它类型异常都是被编译器强制实施的。
- RuntimeException程序中可以选择是否捕获处理，这些异常一般由程序逻辑错误引起，应该从逻辑上避免这种异常。
- 不可查异常("unchecked exceptions")：包括RuntimeException(及其子类)和错误(Error)。

## (2)非运行时异常(编译异常，"checked exceptions")：
- RuntimeException以外的异常，类型上属于Exception及其子类，从语法角度是必须处理的异常，否则不能编译通过，例如：IOException，SQLException等。
- 一般情况下不会自定义检查异常(即编译异常)

# 四 异常的用法：
## (1)try...catch...finally
## (2)throws: 异常说明.
## (3)throw

# 五 经验(effective java):
## (1)针对异常情况下才使用异常:
- 异常是为异常情况而设计, 不要用于普通控制流.
- 可选方案: 状态测试方法(例如:Iterator的hasNext())和可识别的返回值(例如: 返回null).
- 状态测试方法优先于可识别返回值, 因为若没有调用状态测试方法, 则状态相关方法会抛出异常, 而忘记检查可识别返回值, 则很难发现bug.

## (2)如何选择:
- 若期望调用者能够尝试恢复, 则应该使用checked异常.
- 用运行时异常来表明编程错误.
- 运行时异常和Error, 都是不需要也不应该被捕获的, 此时程序往往处于不可恢复状态, 执行下去也无意义, 此时线程会终止, 并出现相关错误信息.

## (3)避免不必要的checked异常:
- 当正确使用API不能阻止异常发生且发生异常时可以采取相关动作, 则可以使用checked异常; 否则使用非checked异常.
- 若方法抛出一个或多个checked异常, 则调用该方法的代码必须使用一个或多个catch块来处理一次或者将它们传播出去, 增加了码农的负担.
- 可将checked异常转换为运行时异常.

## (4)优先使用标准异常

## (5)抛出相对应的异常:
- 异常转译(exception translation): 更高层实现应该捕获底层的异常, 同时抛出高层可解释的异常.
- 异常链: 若底层异常对高层异常问题有帮助, 则使用异常链, 将底层异常传递到高层(高层异常的构造器将底层异常转到chaining-aware的super构造器, Exception的一个构造函数), 高层的getCause方法来获得底层异常.
- 大多数标准都有chaining-aware的构造器, 若没有则可以直接调用Throwable的initCause方法来设置原因.
- 需尽量避免底层异常, 例如调用之前做一些参数检查等, 从而避免不必要的底层异常.
- 若不能阻止或避免底层异常, 一般使用异常转译, 同时使用日志将底层异常记录下来.

## (6)每个方法抛出的异常要有文档:
- 要为每个方法可能抛出的异常建立文档(使用Javadoc的@throws标记), 对于checked和非checked异常都一样.
- checked异常还需在方法的声明中使用throws关键字指出, 非checked异常不要.

## (7)细节信息中包含捕获失败的信息:
- 当程序由于未checked异常失败时候, 系统会自动打印该异常的堆栈, 即toString方法的调用结果, 若想要获得更多信息, 则异常类型的toString方法应该尽可能返回更多信息.

## (8)使失败保持原子性:
- 当抛出异常之后, 通常期望对象处于可用状态之中, 对于checked异常尤其重要, 因为调用者期望能从异常中恢复.
- 可选方法: 使用不可变对象; 操作之前优先检查参数有效性; 调整计算顺序, 使得可能失败的计算在对象改变之前发生; 编写一段恢复代码, 拦截操作过程中失败, 以便使对象回滚到之前状态; 创建对象的copy.

## (9)不要忽略异常
