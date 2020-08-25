# 一 概述:
## (1)功能:
- 允许应用实现一个安全策略, 在执行一些可能危险或敏感的操作之前, 判断是否允许执行.
- SecurityManager类包含需要checkXXX方法, 这些方法被Java类库中不同执行敏感操作的函数调用, 若操作不被允许, 则抛出SecurityException.

## (2)相关类:
- SecurityConstants
- java.security.Permission: Abstract class for representing access to a system resource.
- java.security.AccessController: used for access control operations and decisions.