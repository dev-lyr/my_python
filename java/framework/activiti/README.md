# 一 概述:
## (1)介绍:
- Activiti is a light-weight **workflow** and **Business Process Management (BPM)** Platform targeted at business people, developers and system admins.

## (2)相关概念:
- process definition: 定义一个process中不同步骤的结构和行为.
- process instance: 是process definition的一个执行实例.
- services
- tasks
- jobs: Activiti中Jobs用来做很多事, 例如: 计时器, 异步继续, 延迟暂停/激活等.
- variables: Every process instance needs and uses data to execute the steps it exists of, 即变量.

## (3)备注:
- https://github.com/Activiti/Activiti
- https://www.activiti.org/
- http://www.bpmn.org/
- https://www.activiti.org/5.x/userguide/
- https://plugins.jetbrains.com/plugin/7429-actibpm

# 二 db相关:
## (1)概述:
- 所有表的格式: ACT_表示用途的两个字符_*.
- ACT_RE_*: RE表示repository, 该类表包含静态信息, 例如: process definitions和process resources(images, rules等).
- ACT_RU_*: RU表示runtime, 该类表包含process instance的运行时数据, user tasks, variables, jobs等等, 运行时数据只会在流程实例执行时保存, 当流程结束后会被删除.
- ACT_ID_*: ID表示identity, 该类表包含identity信息, 例如:users,group等.
- ACT_HI_*: HI表示history, 该类表包含历史数据, 例如: 历史的流程实例, 变量, 任务等.
- ACT_GE_*: GE表示general, 在多类场景使用.

# 三 事件处理:
## (1)功能:
- 允许engine内部发生多类事件时得到通知, 可以注册一个listener到指定的事件类型.
- 所有发送的事件是org.activiti.engine.delegate.event.ActivitiEvent的子类型, 事件会expose出type, executionId, processInstanceId和processDefinitionId, 特定事件会包含其它上下文.
- event-dispatching机制是开放的, 可以通过API(RuntimeService)来发送自定义事件到engine上注册的任意listener. 但是推荐只使用CUSTOM类型来发送ActivitiEvents.

## (2)所有支持的事件类型(ActivitiEventType).

## (3)事件listenner:
- listener需实现org.activiti.engine.delegate.event.ActivitiEventListener.
- 包含一些方便使用的base实现, 例如: BaseEntityEventListener.
- 事件listener可通过配置添加, 运行时API来添加或者在流程定义的BPMN XML文件添加.

# 四 Activiti API:
## (1)概述:
- API是最常用的Activiti交互方式, 中心起点是ProcessEngine.

## (2)ProcessEngine:
- repositoryService: 提供管理和操作deployments和process definitions, 流程定义时BPMN2.0流程.
- runtimeService: 启动和查询流程实例, 存储和查询流程变量(给定流程实例).
- taskService: 查询分配给users或groups的任务; 创建和流程实例无关的standalone任务; claiming和completing一个任务,claiming表示某某觉得作为任务的受理人来完成该任务, completing表示做任务的工作.
- identityService
- historyService
- managementService

## (3)变量(variables):
- 每个流程实例都需要和使用一些数据来执行步骤, 这些数据在activiti中称作变量, 存储在db中. 变量可以用在expression,java service tasks等.
- 每个表里存储在ACT_RU_VARIABLE表, startProcessInstance时可通过参数指定变量.

## (4)表达式(expressions):
- Activiti使用UEL来执行表达式解析, 表达式可用在Tasks, Listeners和Sequence flows等.
- 两种类型表达式: 值表达式和方法表达式.
- 值表达式: 解析为一个值, 默认所有流程变量和所有spring-beans可用, 例如: ${myVar}和${myBean.myProperty}.
- 方法表达式: 调用一个方法(可指定参数), 例如: ${xxx.yyy()}, ${myBean.xxx("lyr").

# 五 与spring的集成.
# 六 Deployment