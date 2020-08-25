# 一 概述:
## (1)功能:
- 方便创建stand-alone, product-grade的Sping应用.
- 大部分Spring Boot应用只需很少的Spring配置.

## (2)特性:
- 创建stand-alone Spring应用.
- 内嵌Tomcat, Jetty等(不需部署war包).
- 提供starter, 简化build配置.
- 尽可能自动配置Spring和第三方包.
- 提供工业级特性, 例如: metrics, health checks和externalized配置.
- Absolutely no code generation and no requirement for XML configuration.

## (3)执行方式:
- mvn spring-boot:run
- 打包成一个可执行的自包含的jar包, 从而可以在生产环境运行, 使用spring-boot-maven-plugin, 然后mvn package打包为jar.
- spring-boot-cli命令行工具: 主要用于测试.

## (4)备注:
- https://spring.io/projects/spring-boot
