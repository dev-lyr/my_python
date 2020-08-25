# 一 概述:
## (1)用途:
- 本文介绍根据JMS的特性来达到应用程序所需的可靠性(reliability)和性能(performance).
- 最可靠的产生消息方式: 在一个事务内以持久化模式发送消息.
- 最可靠的消息消费方式: 在一个事务内从一个队列或主题的持久订阅者中消费消息.
- 低级别的可靠性可以减少开销提高性能.

## (2)基本的可靠性机制:
- 控制消息确认(Controlling message acknowledgment): 可以指定不同级别的消息确认控制.
- 指定消息持久化: 可以指定消息被持久化存储, 即使provider故障, 消息也不会被丢失.
- 设置消息优先级层次: 可以设置消息的优先级, 影响消息被传递的顺序.
- 允许消息过期: 可以给消息指定一个过期时间.
- 创建临时目的地: 可以创建临时目的地，使它们只在连接内有效.

## (3)高级可靠性机制:
- 创建持久订阅.
- 使用本地事务.

# 二 控制消息确认:
## (1)概述:
- 直至JMS消息被确认, 该消息才算被成功消费.

## (2)成功消费消息的三个阶段:
- client接收到该消息.
- client处理该消息.
- 消息被确认(Acknowledged), 确认由JMS provider或client发出, 由session的确认mode决定.

## (3)确认的发生时机:
- 在事务性sessions内, 当事务被commit后确认自动发生, 当事务被回滚时, 所有被消费的消息重新被再投递(redelivered).
- 在非事务性session内, 确认的发生依赖createSession函数的第二个参数的指定值.
<pre><code>
Session.AUTO_ACKNOWLEDGE: 当client从receive中返回或被调用来处理消息的MessageListenner返回成功时，
由session自动确认client接收到消息. 这种情况下，消息的接收和确认发生在一个步骤内，随后是消息的处理.
Session.CLIENT_ACKNOWLEDGE: client通过调用acknowledge方法来确认消息, 
确认是session级别的, 即确认一个被消费的消息则会自动确认所有已被消费的消息.
Session.DUPS_OK_ACKNOWLEDGE: session延迟发送消息的确认.
</code></pre>

## (4)备注:
- 队列中的消息在被接收但未确认的情况下session就终止了, 则该消息会被JMS provider保持并重新投递.
- 对于拥有持久订阅者的已关闭session, JMS provider会保持未被确认的消息; 非持久订阅者的未确认消息则会在session关闭后被丢弃.

# 三 指定消息的持久性(默认是持久存储)
## (1)概述:
- JMS API支持两种传递模型来决定当JMS Provider故障时消息是否丢失, 由DeliveryMode接口的属性表示.

## (2)类型:
- DeliveryMode.PERSISTENT: 默认, 命令JMS Provider保证及时它故障时消息也不会被丢失, 通常消息被记录到稳定存储中.
- DeliveryMode.NON_PERSISTENT: 不要求JMS Provider存储该消息或保证它故障时不丢失消息.

## (3)选择:
- 使用NON_PERSISTEN模式可以提高性能减少存储开销, 但应用程序要能忍受丢失消息.

## (4)使用:
- MessageProducer类的setDeliveryMode方法: 生产者级别.
- producer.set方法的参数指定: 消息级别.

# 四 设置消息优先级:
## (1)功能:
- 可以使用消息优先级来命令JMS Provider优先发送紧急消息.
- 共10个级别的优先级0(最低)-9(最高), 默认为4, JMS Provider尽量先投递高优先级消息.

## (2)使用方法:
- MessageProducer类的setPriority方法: 设置生产者的所有消息优先级.
- producer.send方法的参数控制: 设置单个消息的优先级.

# 五 允许消息过期:
## (1)概述:
- 默认消息不会过期，若需设置消息在指定时间后过期，则可以设置过期时间.
- 到了过期时间还未被投递的消息会被销毁, 可以节约存储空间和计算资源.

## (2)使用:
- MessageProducer的setTimeToLive: 生产者级别.
- producer.send方法的参数控制: 消息级别.

# 六 创建持久化订阅者:
## (1)功能:
- 为了保证发布/订阅应用接收到所有发布的消息, 发布者要使用PERSISTENT投递模式, 订阅者要使用持久订阅.
- 非持久订阅者只能接收在它是active情况下发布的消息.
- JMS Provider会维持一个持久订阅的记录并确保topic上所有发布者的消息被保存, 直至消息被持久订阅者确认或过期.

# 七 使用JMS API本地事务:
## (1)概述:
- JMS client可以使用本地事务来分组消息发送和接收. Session接口的commit和rollback提供接口被JMS client使用.
- commit表示所有产生的消息被发送和所有消费的消息被确认.
- rollback表示所有产生消息被销毁和所有消费的消息被恢复并再次投递，除非它们过期.