# 一 概述:
## (1)定义:
- JMS: 面向异步消息而制定的标准API.
- ActiveMQ是JMS的一个实现.
- javax.jms

## (2)JMS消息通信模型:
- 点对点模型.
- 发布订阅消息模型.
- 备注: 一个应用可以结合使用者两种通信模型.

## (3)JMS优点(与同步RPC相比):
- 无需等待，发送者不用等待消息被处理.
- 面向消息和解耦，JMS发送消息以数据为中心.
- 位置独立.
- 确保投递，及时消息发送时服务崩溃，消息也会存储起来.

## (4)备注:
- 消息产生是内在异步的。
- 消息消费两种类型: 同步(消费者阻塞直至消息到达)；异步(消费者注册一个消息监听器).

# 二 JMS组成:
## (1)JMS provider:
- 实现JMS API的消息系统，例如: activemq.

## (2)JMS clients:
- 发送和接收消息的Java应用程序.
- MessageProducer接口: QueueSender和TopicPublisher，发送消息到destination, 通过session的createProducer创建.
- MessageConsumer接口: QueueReceiver和TopicSubscriber，从destination接收消息, 通过session的createConsumer创建, 可指定selector过滤感兴趣的信息.
- MessageListenner接口: 异步接收被传递消息, 可调用MessageConsumer的setMessageListener设置.
- ExceptionListener: 若JMS provider检测到Connection对象上的严重问题, 则通知Connection对象的注册的ExceptionListenner. Connection.setExceptionListener().
- CompletionListener: 当消息发送完成时, JMS Provider通过调研CompletionListener的onCompletion方法来通知应用.
- 备注: JMS2.0: JMSProducer, JMSConsumer.
- DeliveryMode(发送端): PERSISTENT(应用不能容忍消息在传输中丢失, client命令JMS provider存放消息到稳定存储)和NON_PERSISTENT(偶尔消息丢失可以容忍, Provider重启后消息丢失), Delivery模式只负责消息到destination的传输, 在destination存放消息直至它被接收确认并不保证. 消息的存放策略(retention)负责消息的从destination到消费者间的可靠性, 例如:若client消息的存储空间耗尽, 则消息可能丢失.

## (3)Messages:
- 应用程序client间用来交流信息的对象, JMS API定义了5类消息体.
- TextMessage: 包含一个java.lang.String对象, 可用来传输纯文本信息和XML信息.
- StreamMessage: 包含一个基本类型(primitive type)值的stream, 可以被顺序的填充和读取.
- ObjectMessage: 包含一个Serializable Java对象.
- MapMessage: 包含键值对的集合, key是String对象, value是java基本类型的值.
- BytesMessage: 包含一个不可解析(uninterpreted)字节的流.
- 相关属性:传递延迟(DEFAULT_DELIVERY_DELAY默认为0), 传递模式(DEFAULT_DEVIVERY_MODE为PERSISTENT), 优先级(DEFAULT_PRIORITY为4), 存活时间(DEFAULT_TIME_TO_LIVE没有限制, 不过期).

## (4)Destination:
- destination对象封装指定provider的地址.
- Queue
- TemporaryQuery: 在一个连接中创建的唯一Queue对象，生命周期为连接的生命周期，只能在创建它的连接中使用.
- Topic
- TemporaryTopic: 在一个连接中创建的唯一Topic对象，生命周期为连接的生命周期，只能在创建它的连接中使用.

## (5)ConnnectionFactory:
- 功能: client用来创建连接，对应实现类: ActiveMQConnectionFactory(继承QueueConnectionFactory, TopicConnectionFactory)等.
- 种类: QueueConnectionFactory、TopicConnectionFactory、XAQueueConnectionFactory、XATopicConnectionFactory

## (6)Connection:
- 功能: 一个客户到jms provider的活跃连接.
- 种类: QueueConnection、TopicConnection、XAConnection、XAQueueConnection、XATopicConnection.
- Connection创建时处于stopped状态，通常在所有消息消费者都创建完之后才调用start方法离开stopped状态.
- 相关类: ConnectionMetaData(通过连接的一些信息).

## (7)Session:
- 功能: 一个单线程的产生和消费消息的上下文，一个session可以创建和服务多个消息发送者和接受者.
- 种类: QueueSession、TopicSession、XAQueueSession、XASession和XATopicSession.
- 相关类: ServerSession和ServerSessionPool.

## (8)确认模式(Acknowledgment mode):
- AUTO_ACKNOWLEDGE: 该模式下,当seesion从receive方法成功返回或message listener被session调用处理消息并成功返回, session会自动确认对client接收的消息进行确认.
- CLIENT_ACKNOWLEDGE: client通过调用消息的acknowledge方法对消费的消息进行确认.
- DUPS_OK_ACKNOWLEDGE.
- SESSION_TRANSACTED.
- 备注: 在Session接口定义.

## (9)备注:
- JMS客户端通常创建一个连接、一个或多个session和一些消息发送者和接受者.
- JMSContext: JMS2.0提供的一个简化的JMS API, 将JMS1.1中两个分离的对象Connection和Session合并为一个对象, 创建方式ConnectionFactory的createContext方法.

# 三 点对点消息模型(PTP):
## (1)组成:
- 队列: 队列保存所有发给它的消息，直至消息被消费或过期, 消息顺序是FIFO.
- 发送者.
- 接收者.

## (2)特点:
- 每个消息只能有一个消费者.

# 四 发布/订阅模型(pub/sub):
## (1)组成:
- topic(主题): 客户端发送消息到一个主题，发布者或订阅者可以动态发布或订阅一个主题.
- publishers: 发布者.
- subscribers: 订阅者, 分为持久订阅者和非持久订阅者(默认).
- subscription: 订阅, 用来支持持久订阅者, 应用通过在topic上创建subscription, 并在subscription上创建消费者来消费消息. topic上创建的subscription会接收到一个消息的副本, 除非指定了消息选择器(selector). subscription允许多个消费者(每个消费者都会收到消息的副本).

## (2)订阅者类型:
- 非持久订阅者: 只接收在它们是active情况下发布的消息.
- 持久订阅者: 接收某主题下发布的所有消息.

## (3)特点:
- 一个topic可以有多个消费者, 传递的消息是完整的分离的消息, 处理完和确认一个消息对其它无影响.
- Only one session at a time can have a TopicSubscriber for a particular durable subscription.