# 一 流程图:
## (1)事件(圆圈):
- 开始事件: None开始事件(空心圆).
- 结束事件: None结束时间(空心圆).

## (2)任务(方块):
- user task: 方块里面有小人.
- service task: 方块内有锯齿.

## (3)gateway: 
- exclusive gateway: 中间有叉的菱形.

## (4)sequence flow:
- 默认: 实心箭头.
- 条件性flow: 空心菱形+实心箭头.

# 二 Events:
## (1)概述:
- 事件用来模拟工作流流程中发生的事情.
- 事件定义(Event definitions): 定义一个事件的语义.

## (2)两类事件类别:
- Catching: 当流程执行到事件时, 它等待一个trigger发生, trigger的类型通过inner icon或xml中的type声明来定义.
- Throwing: 当流程执行到事件时, 一个trigger被触发(fired).

## (3)事件定义(event definitions):
- Timer Event定义:Timer事件是通过定义的timer触发的事件, 可用来作为start event, intermediate event或boundary event.
- Error Event定义: BPMN的错误与Java异常不一样, BPMN的错误事件是一种模拟business exception的方式.
- Signal Event定义:信号事件是一个与命名信号相关联的事件.
- Message Event定义:消息事件时一个与命名消息关联的事件, 与信号事件不同, 消息事件通常直接导向一个唯一的接收者.

## (4)Start事件:
- start事件表示一个流程开始的地方, start事件的类型(消息到达时候开始, 特定事件间隔), 定义了流程怎么开始, Start事件通常是Catching.
- initiator属性: 指向一个变量名字, 该变量存放的是流程开始时授权的user id.用户需使用identityService.setAuthenticatedUserId(String)方法来设置.
- None Start事件: 表示启动流程的trigger未定义, 使用场景是: 流程实例通过调用runtimeService.startProcessInstanceByXXX方法来启动, xml表示类似正常的start event定义, 只是没有任何子元素(其它启动事件类型都有子元素声明类型).
- Timer Start事件.
- Message Start事件.
- Signal Start事件.
- Error Start事件.

## (5)End事件:
- End事件表示流程的结束, end事件通常是throwing, 即当流程执行到end事件, 一个result会被抛出.
- None End事件: 表示不指明当到达end事件时需抛出result, xml表示与正常end事件一样, 只是没有子元素表示类型.
- Error End事件.
- Terminate End事件.
- Cancel End事件.

## (6)Boundary事件:
- 边界事件是attach到activiti的catching事件.

# 三 Gateways:
## (1)功能:
- 用来控制flow的执行.

## (2)Exclusive Gateway:
- 用来在process中模拟(model)decision, 当执行到该gateway时, 所有outgoing顺序flow会被依据定义顺序进行计算, 选择为ture的顺序flow继续执行process.
- xml表示: `<exclusiveGateway id="exclusiveGw" name="Exclusive Gateway">`

## (3)Parallel Gateway:
- 在process中模拟并发. 
- **fork**: all outgoing sequence flow are followed in parallel, creating one concurrent execution for each sequence flow.
- **join**: all concurrent executions arriving at the parallel gateway wait in the gateway until an execution has arrived for each of the incoming sequence flow. Then the process continues past the joining gateway.
- `xml表示: <parallelGateway id="xxx".>`.

## (4)Inclusive Gateway:
- 可以看做是exclusive和parallel gateway的结合.

## (5)Event-based Gateway

# 四 Sequence Flow:
## (1)概述:
 - 序列flow是一个process中两个元素间的连接器, 当流程执行中, 当一个element被访问后, 所有流出的序列flow会被followed.
- xml表示: `<sequenceFlow id="flow1" sourceRef="theStart" targetRef="theTask" />`
- 序列flow需要有一个流程唯一id, 并且引用到一个存在的source和target元素.

## (2)条件序列Flow:
- 序列flow可以定义condition, 默认行为是计算条件, 若为true则选择流出的序列流.
- xml表示: `<sequenctFlow id="一个唯一的id" sourceRef="source元素" targetRef="target元素"> <conditionExpression>相应条件</conditionExpression> </sequenceFlow>`

## (3)默认序列Flow:
- 所有BPMN2.0任务和gateway可以有一个默认的序列flow, 只有当前没有其它outgoing序列flow被选择时才会使用默认序列flow, 默认的flow的条件会被忽略.

# 五 Task:
## (1)Task Listener:
- 在task相关事件发生时, 用来执行自定义的Java逻辑或表达式, **只能用于user task**.
- event类型: create, assignment(任务分配给某人), complete(任务完成且在从运行时数据中删除之前), delete(任务打算删除之前), 注意当工作流执行到user task时第一个触发的事件类型为assignment(而不是create).
- class: 被调用的委托类, 该类需实现org.activiti.engine.delegate.TaskListener接口.
- expression
- delegateExpression

## (2)User Task:
- 用来model需要操作(actor)完成的工作, 当工作流执行到user task时, 会在该任务b被assign的的user(s)或group(s)的任务列表新建一个task.
- userTask可以直接分配给一个user, 通过定义一个**humanPerformer**元素来实现, 该元素需要一个resourceAssignmentExpression来定义user, 只可以分配给一个user, 该user被称作**assignee**.
- 任务也可以被放在人的候选任务列表, 使用**potentialOwner**元素.

## (3)Java Service Task:
- 用来调用一个外部java类.

## (4)Script Task:
- 脚本task是个自动化的活动, 当流程执行到脚本任务时, 对应脚本被执行.

## (5)Web Service Task:
- 用来同步调用外部web服务.
# 六 Sub-Processes and Call Activities

# 七 Transactions and Concurrency