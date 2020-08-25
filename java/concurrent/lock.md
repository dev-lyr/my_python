# 一 概述：
## (1)种类:
- **死锁**: 是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。
- **活锁(英文 live lock)**: 指事务1可以使用资源，但它让其他事务先使用资源；事务2可以使用资源，但它也让其他事务先使用资源，于是两者一直谦让，都无法使用资源(数据库中的概念)。
- **饥饿**: 是指如果事务T1封锁了数据R,事务T2又请求封锁R，于是T2等待。T3也请求封锁R，当T1释放了R上的封锁后，系统首先批准了T3的请求，T2仍然等待。然后T4又请求封锁R，当T3释放了R上的封锁之后，系统又批准了T4的请求......T2可能永远等待，这就是饥饿。

## (2)资源的分类：
- 可重用资源：指一次只能供一个进程安全地使用，并且不会由于使用而耗尽的资源。可重用资源包括：处理器、I/O通道、设备等。
- 可消耗资源(又称临时资源)：指可以被创建(生产)和销毁(消耗)的资源。例如：中断、信号和消息等。

## (3)备注:
- 解决活锁和饥饿的简单方法：先来先服务策略。

# 二 死锁:
## (1)概述:
- 死锁原因归结为两点：竞争资源；进程间推进顺序非法。

## (2)死锁的充分必要条件：
- 互斥：一次只有一个进程可以使用一个资源。
- 占有且等待：当一个进程等待其他进程时，继续占有已经分配的资源。
- 不可抢占：不能强行抢占进程已占有的资源。
- 环路等待：存在一个封闭的进程链，使每个进程至少占有此链中下一个进程所需要的一个资源。
- 前三个是死锁的必要条件，第四个是前三个条件的潜在结果。

## (3)处理死锁的基本方法：
- 死锁预防：通过设置某些限制条件，去破坏死锁的四个条件中的一个或几个条件，来预防发生死锁。但由于所施加的限制条件往往太严格，因而导致系统资源利用率和系统吞吐量降低。
- 死锁避免：允许前三个必要条件，但通过明智的选择，确保永远不会到达死锁点，因此死锁避免比死锁预防允许更多的并发。
- 死锁检测：不须实现采取任何限制性措施，而是允许系统在运行过程发生死锁，但可通过系统设置的检测机构及时检测出死锁的发生，并精确地确定于死锁相关的进程和资源，然后采取适当的措施，从系统中将已发生的死锁清除掉。
- 死锁解除：与死锁检测相配套的一种措施。当检测到系统中已发生死锁，需将进程从死锁状态中解脱出来。常用方法：撤销或挂起一些进程，以便回收一些资源，再将这些资源分配给已处于阻塞状态的进程。死锁检测盒解除有可能使系统获得较好的资源利用率和吞吐量，但在实现上难度也最大。

# 三 死锁预防:
## (1)互斥：
- 它是设备的固有属性所决定的，不仅不能改变，还应该加以保证。

## (2)占有且等待：
- 为预防占有且等待条件，可以要求进程一次性的请求所有需要的资源，并且阻塞这个进程直到所有请求都同时满足。这个方法比较低效。

## (3)不可抢占：
- 预防这个条件的方法：
- 如果占有某些资源的一个进程进行进一步资源请求时被拒绝，则该进程必须释放它最初占有的资源。
- 如果一个进程请求当前被另一个进程占有的一个资源，则操作系统可以抢占另外一个进程，要求它释放资源。

## (4)循环等待：
- 通过定义资源类型的线性顺序来预防。
- 如果一个进程已经分配了R类资源，那么接下来请求的资源只能是那些排在R类型之后的资源类型。该方法比较低效。

# 四 死锁避免：
## (1)两种死锁避免算法：
- 进程启动拒绝：如果一个进程的请求会导致死锁，则不启动该进程。
- 资源分配拒绝：如果一个进程增加的资源请求会导致死锁，则不允许此分配(银行家算法)。

## (2)银行家算法：
- 1.如果request<=need，转向步骤2；否则认为出错，因为请求资源大于需要资源。
- 2.如果request<=available，转向步骤3,；否则尚无足够资源，进程p阻塞；
- 3.系统尝试为把资源分配给进程P，并修改available、allocation和need的数值。
- 4.系统执行安全性算法，检查此次分配后系统是否处于安全状态，若安全，才正式将资源分配给进程P，否则将本次试探性分配作废，让进程P等待。
- 安全状态：系统能按照某种进程顺序，为每个进程分配资源，直至满足每个进程对资源的最大需求，使每个进程都可顺利完成。

## (3)安全性算法:
- 1.设置两个向量：
- 工作向量work：表示系统可提供给进程继续运行的所需的各类资源的数目，执行安全算法开始时，work=available。
- finish：表示系统是否有足够资源分配给进程，使之运行完成。开始时先做finish[i]=false；当有足够资源分配给进程时再令finish[i]=true。
- 2.从进程集合找到一个满足下列条件的进程：
- finish[i]=false；
- need<=work；
- 若找到执行步骤3；否则执行步骤4；
- 3.当进程P获得资源后，可顺利执行，直至完成，并释放出分配给它的资源，故应执行：
- work=work+allocation(P)；
- finish[i]=true；
- 循环执行步骤2；
- 4.如果所有进程的finish=true，则表示系统处于安全状态；否则，系统处于不安全状态。

# 五 活锁(live lock):
## (1)种类:
- 指事务1可以使用资源，但它让其他事务先使用资源；事务2可以使用资源，但它也让其他事务先使用资源，于是两者一直谦让，都无法使用资源(数据库中的概念)。
- 处理事务消息的应用中，若不能成功处理某个消息，则消息处理机制会回滚整个事务，并将它重新放到队列的头部，处理器反复调用该事务并返回相同结果，虽然没有阻塞线程，但是也无法继续执行下去，通常原因是错误将不可修复错误作为可修复错误进行处理，过度的错误恢复代码造成的.

# 六 饥饿:
## (1)原因:
- 线程优先级的使用不当.
- 持有锁的线程执行一些无法结束的代码.

## (2)线程优先级:
- 与平台相关，依赖底层操作系统的优先级，Java Thread API定义10个优先级，在特定平台上可能两个JAVA优先级映射到同一优先级，通常应避免修改线程优先级.