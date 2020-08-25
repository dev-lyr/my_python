# 一 概述:
## (1)概述:
- Service Provider Interface(SPI): 是一个打算让第三方实现或扩展的API, 使得框架可以扩展和替换组件.

## (2)组成:
- **service**: 一个众所周知的接口的集合和类(通常是抽象).
- **service provider**: 是service的一个特定实现, service提供者实现服务中定义的接口和继承类.
- **service loader**: java.util.ServiceLoader.

## (3)使用:
- JDBC
- Java Cryptography Extension(JCE)
- Java XML处理
- Java文件系统

## (4)局限:
- ServiceLoader不能被继承和扩展, 所以不能修改它的行为, 可以使用自定义ClassLoader子类来改变类发现方式.
- 不支持在**运行时**告诉应用有新的providers.
- change-listeners to the loader to find out whether a new provider was placed into an application-specific extension directory.

## (5)备注:
- https://en.wikipedia.org/wiki/Service_provider_interface
- https://docs.oracle.com/javase/8/docs/api/index.html
- https://docs.oracle.com/javase/tutorial/ext/basics/spi.html

# 二 service

# 三 service提供者:
## (1)概述:
- 服务提供者通过在资源目录**META-INF/services**下放置一个**provider configuration**文件来识别.
