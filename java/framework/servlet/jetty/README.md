# 一 概述：
## (1)功能：
- 一个可作为HTTP server、HTTP client和javax.servlet容器的开源软件

## (2)包含目录： 
- start.jar：启动Jetty的Jar文件.
- webapps：默认的Jetty中运行web应用的目录.
- bin/jetty.sh：在linux/unix启动jetty的工具脚本.
- etc：Jetty XML配置文件目录.
- lib：所有运行Jetty需要的Jar文件.
- logs：请求log目录.

# 二 控制jetty:
## (1)启动：
- java -jar start.jar或bin/jetty.sh
- java -jar start.jar --help：查询相关选项.

## (2)停止:
- bin/jetty.sh: 先发送TERM信号给进程; sleep 30s; 若还没结束则发送kill信号.

# 三 Jetty配置(How And What)
## (1)启动配置：
- ini文件：start.ini和start.d/&/ini文件.
- mod文件：modules/.mod文件，包含模块的定义.
- xml文件：etc目录.

## (2)其它配置文件：
- web.xml
- Context XML文件.
- Property文件.

## (3)需要配置的类型：
- Server配置.
- Connectors配置.
- Contexts配置.
- 配置web应用.

# 四 架构:
## (1)概述:
- Jetty Server由多个接收客户HTTP连接的连接器(Connector)的集合，以及一些用来处理HTTP请求并产生响应的Handler集合组成.
- 执行接收请求、处理请求并返回相应的线程由一个线程池提供.

# 五 热部署(hot deployed)： 
## (1)概述：
- Jetty Server可以发现webapps(jetty-deploy.xml可修改)目录下部署文件改变，从而实现热部署.
- 若增加一个web应用或context到该目录，Jetty的DM(DeploymentManager)则部署它.
- 若创建或更新一个context描述符，则DM停止、再配置和重新部署该应用.
- 若删除一个web应用或context，则DM从server中关闭和删除该应用.

## (2)webapps目录下支持以下四种文件类型：
- 若文件类型为目录，例如：examples/：若包含WEB-INF/web.xml子目录和文件则会作为标准web应用部署, context path为http://ip:port/examples.
- 若文件类型为目录，例如：examples/，不包含WEB-INF/web.xml，则作为静态内容.
- 若文件类型为war文件，例如：example.war: 作为标准web应用部署，context path为http://ip:port/example. 注意: root.war为预留名字, 对应的context path为:http://ip:port/.
- 若文件为xml文件，例如: example.xml：xml文件必须设置context path.
- 备注：若存在example.xml，则不会部署example.war; 若存在example.war则不会部署example目录.

## (3)配置(etc/jetty-deploy.xml配置文件)：
- 修改WebAppProvider类的monitoredDirName和scanInterval属性来修改扫描路径和扫描间隔秒数.
