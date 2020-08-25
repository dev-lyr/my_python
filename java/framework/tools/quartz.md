# 一 quartz：
## (1)概述：
- https://quartz-scheduler.org/
- https://quartz-scheduler.org/api/2.2.1/
- 与spring结合: org.springframework.scheduling.quartz.

## (2)相关角色：
- 调度器(scheduler)
- 任务(job)
- 触发器(trigger)

## (3)其它类：
- TriggerKey：唯一表示一个Trigger，由name和group组成，group中的name必须唯一，若只指定name则使用默认group.

## (4)备注：
- 可有多个triggers指向一个job，但一个trigger只能意向一个job.
- 实现的Job不能和执行job的类放在一个文件下，切记，尼玛 大坑.
- 最好在mvn中增加ch.qos.logback的依赖，方便排查问题.
- 与spring结合使用时，不同版本的quartz使用自动注入时属性不一样.

# 二 调度器：
## (1)功能：
- 维护一个JobDetails和Triggers的注册处，一旦注册，Schedular将在Job相关类的Trigger触发(比如定时时间到)时执行该Job.
- Schedular实例通过SchedularFactory创建，创建完后，schedular处于"stand-by"(待用)模式，在fire相关jobs前需调用start方法.

## (2)相关接口和类：
- 接口Scheduler
- 接口SchedulerFactory：用来产生调度实例的工厂类，实现该接口的类为StdSchedulerFactory.

# 三 任务相关：
## (1)功能：
- Job是通过定义一个实现Job接口的类实现.
- JobDetail：表示一个job类实例的属性，通过JobBuilder创建和定义.

## (2)相关类：
- 接口Job：实现该接口的类表示一个被执行的任务.
- 接口JobDetail：给定任务(job)的详细属性.
- 类JobBuilder：用来实例化JobDetail实例.

# 四 触发器：
## (1)功能：
- 触发器，定义job何时执行.
- Trigger由TriggerBuilder产生具体触发器.
- 常用类型：SimpleTrigger和CronTrigger.

## (2)相关类和接口：
- 接口Trigger：所有触发器的基类，使用TriggerBuilder来产生具体的触发器.
- 类TriggerBuilder：实例化trigger.
- 接口SimpleTrigger.
- 接口ScronTrigger.

## (3)SimpleTrigger：
- one-time firings, or firing at an exact moment in time, with N repeats with a given delay between them.
- SimpleScheduleBuilder.

## (4)CronTrigger：
- scheduling based on time of day, day of week, day of month, and month of year.
- CronScheduleBuilder.

# 五 cron expression：
## (1)cron表达式包含七个字段：
- 秒：0-59 , -*/
- 分：0-59 , -*/
- 小时：0-23 , -*/
- 日期：0-31 , -*?/L W C
- 月份：1-12或JAN-DEC , -*/
- 星期：1-7或SUN-SAT , -*?/L C #
- 年(可选)：空，1970-2099 , -*/

## (2)备注：
- /：表示增量值，比如秒字段"5/15"代表从第5秒开始，每15秒一次.
- ?：表示这个字段不包含值.
- *：表示可接受任何可能的值.
- ,：指定多个值，比如小时'10,14,16'代表10点，14点和16点都执行.
- -：指定一个值范围.