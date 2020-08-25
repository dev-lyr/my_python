# 一 概述:
- http://logback.qos.ch/manual/configuration.html

# 二 根节点`<configuration>`:
## (1)属性:
- scan: 默认为true，配置文件发送变化将重新加载.
- scanPeriod: 默认为1分钟，设置检测配置文件是否改变的时间间隔，scan为true，才生效.
- debug: 默认为false，打印logback内部日志信息.

## (2)子元素:
- `<appender>`: 0个或多个.
- `<logger>`: 0个或多个.
- `<root>`: 至多一个.

# 三 `<root>`:
## (1)属性:
- level: 设置打印级别，默认为DEBUG.
- 备注: root属于logger，是根logger.

## (2)子元素:
- `<appender-ref>`: 将appender添加到这个logger中.

# 四 `<appender>`:
## (1)属性:
- name: 设置appender的名字.
- class: 指定需实例化的全路径appender类.

## (2)子元素:
- `<layout>`
- `<encoder>`
- `<filter>`

# 五 `<logger>`:
## (1)属性:
- name: **指定相关包或类，将类绑定到logger**.
- level
- additivity: 默认为true，子logger的log会在父logger对应的appender中输出.

## (2)子元素:
- `<appender-ref>`: 将appender添加到这个logger中.