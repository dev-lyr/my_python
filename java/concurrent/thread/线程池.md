# 一 ExecutorService:
## (1)功能:
- An Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
 
## (2)ExecutorService方法：
- void service.execute( new Runnable())
- Future service.submit(new Callable())
- Future service.submit(new Runnable())
- service.shutdown()：shutdown执行器，队列不接受新任务，已经提交任务会继续执行到完成，包括还未开始执行的任务，可调用awaitTermination等待任务完成. 注意: 不会向正在执行的线程发送interrupt.
- service.shutdownNow()：尝试停止所有正在执行任务(并不保证一定停止, 若线程不响应interrupt则不会终止)，停止处理等待的任务，返回一个等待执行任务的列表, 可调用awaitTermination等待任务完成.
- service.awaitTermination()：阻塞，直至所有任务完成，或者timeout或者被interrupted.
- service.isShutdown()：判断执行器是否shutdown.
- service.isTerminated()：若在shutdown后，所有任务都执行完成，则返回true.

## (3)实现子类:
- ThreadPoolExecutor
- ForkJoinPool
- ScheduledThreadPoolExecutor

## (4)经验:
- 给线程设置name, 方便问题排查.
- 不要使用Executors里的各种创建线程池方法, 部分queue无限制(Integer.MAX_VALUE)部分线程数量无限制(Integer.MAX_VALUE), 有可能造成OOM, 因此推荐使用ThreadPoolExecutor.

# 二 ThreadPoolExecutor:
## (1)相关属性:
- corePoolSize
- maxinumPoolSize
- workQueue(BlockingQueue)
- keepAliveTime: 若当前线程数量大于corePoolSize, 超过的线程会在空闲keepAliveTime指定的时间后终止.
- threadFactory: 指定可以设置线程name,daemon等属性, 若不指定则默认使用Executors.DefaultThreadFactory.
- handler: 类型为RejectedExecutionHandler, 任务不能被ThreadPoolExecutor执行时的handler策略, 默认为AbortPolicy.

## (2)线程池大小:
- 当新任务提交时, 若线程数量小于corePoolSize则创建新的线程来处理该请求, 即使有其它线程是空闲的.
- 若当前线程数量大于corePoolSize但是小于maxinumPoolSize, 若workQueue不满, 则将任务放入队列等待执行.
- 若workQueue满, 若当前线程数量小于maxinumPoolSize则创建新的线程, 若大于则使用相应拒绝策略来拒绝任务.

## (3)常用排队策略:
- Direct handoffs(直接传递): 默认的队列是SynchronousQueue(类似管道), 若没有线程来运行该task, 就会拒绝该task, 为了避免拒绝任务, 通常不限制maximunPoolSize的大小.
- Unbounded queues(无限队列): 使用无限制队列, 例如: LinkedBlockingQueue(不设置大小, 默认为Integer.MAX_VALUE), 使用无限制队列会导致不会创建出超过corePoolSize的线程数据. 适用于: 任务是独立的, 不依赖其它任务, 比如web server.
- Bounded queues(有限队列): 有限队列, 例如:ArrayBlockingQueue, 队列的大小和线程池的大小需要相互权衡.

## (4)拒绝策略(RejectedExecutionHandler):
- ThreadPoolExecutor.AbortPolicy: 默认, 抛出一个运行时异常RejectedExecutionException.
- ThreadPoolExecutor.CallerRunsPolicy: 直接在当前线程中调用task的run方法, 会阻塞新task的提交速率.
- ThreadPoolExecutor.DiscardOldestPolicy: 把queue首部的任务扔掉,把当前任务放入队列.
- ThreadPoolExecutor.DiscardPolicy: 默默丢弃.
- 备注: 当线程池shutdown或超过max和队列长度时, 则使用相应的拒绝策略.

## (5)对应实现:
- Executors的newFixedThreadPool: corePoolSize=maximumPoolSize, 队列为LinkedBlockingQueue, keepAliveTime为0.
- Executors的newCachedThreadPool: corePoolSize=0, maximumPoolSize=Integer.MAX_VALUE, 队列为SynchronousQueue, keepAliveTimew为60s.
- Spring的ThreadPoolTaskExecutor.

## (6)ThreadFactory(interface):
- 用于根据需要创建线程, 使用thread factory来代替写死的new Thread(), 可以让应用设置相关的线程属性(name,daemon等).
- 相关实现: Executors.DefaultThreadFactory和ThreadFactoryBuilder(google第三方)等.

# 三 ScheduledThreadPoolExecutor:
## (1)功能:
- 继承ThreadPoolExecutor, 额外支持任务以delay和periodic方式执行.

## (2)相关类:
- Delayed
- DelayQueue

# 四 线程池运行状态:
## (1)相关状态:
- RUNNING: Accept new tasks and process queued tasks.
- SHUTDOWN: Don't accept new tasks, but process queued tasks.
- STOP: Don't accept new tasks, don't process queued tasks,and interrupt in-progress tasks
- TIDYING:  All tasks have terminated, workerCount is zero,the thread transitioning to state TIDYING will run the terminated() hook method.
- TERMINATED: terminated() has completed

## (2)状态转换:
 - RUNNING -> SHUTDOWN: On invocation of shutdown(), perhaps implicitly in finalize().
 - (RUNNING or SHUTDOWN) -> STOP: On invocation of shutdownNow().
 - SHUTDOWN -> TIDYING: When both queue and pool are empty.
 - STOP -> TIDYING: When pool is empty.
 - TIDYING -> TERMINATED: When the terminated() hook method has completed.