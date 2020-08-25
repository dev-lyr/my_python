# 一 概述:
## (1)功能:
- 将大任务拆分为小任务并行执行.
- 实现递归等.

## (2)重要类:
- ForkJoinPool: 一个允许**FrokJoinTask**的ExecutorService.
- FrokJoinTask

# 二 ForkJoinTask:
## (1)概述:
- 运行在ForkJoinPool中的任务的抽象基类.

## (2)方法:
- fork: 准备在当前任务运行的pool中异步执行该任务, 若当前任务不在pool中则运行于ForkJoinPool.commonPool中.
- invoke: 开始执行该任务, 等待它完成(若需要), 返回结果或抛出unchecked异常.
- invokeAll
- join: 在done的时候返回计算结果.

## (3)子类:
- RecursiveAction: 一个递归无结果返回的ForkJoinTask.
- RecursiveTask: 一个递归有结果返回的ForkJoinTask.

# 三 ForkJoinPool:
## (1)概述:
- 一个运行**FrokJoinTask**的ExecutorService.

## (2)创建:
- commonPool静态方法: 创建一个公用的pool, 当线程没有使用时会被回收, 使用时再重新启动.
- 构造函数ForkJoinPool: 应用需要独立或自定义的pool时使用, 默认并行度等于可用处理器的数量.

## (3)方法:
- execute(ForkJoinTask): 准备异步执行给定任务.
- invoke(ForkJoinTask): 执行给定任务, 并在完成时返回结果.
- submit