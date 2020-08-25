# 一 概述：
## (1)相关包(spring4.xx)：
- org.springframework.cache
- org.springframework.cache.annotation
- org.springframework.cache.aspectj
- org.springframework.cache.concurrent
- org.springframework.cache.config
- org.springframework.cache.ehcache
- org.springframework.cache.guava
- org.springframework.cache.interceptor
- org.springframework.cache.jcache
- org.springframework.cache.jcache.config
- org.springframework.cache.jcache.interceptor
- org.springframework.cache.support
- org.springframework.cache.transaction

## (2)开启缓存(两种方法)：
- @EnableCaching和@Configuration.
- <cache:annotation-driven />

## (3)使用步骤(三步):
- 开启缓存(两种方法).
- 定义cacheManager，例如：<bean id="cacheManager" class="org.springframework.cache.concurrent.ConcurrentMapCacheManager"/>.
- 使用注解@Cacheable等标记方法或类.

## (4)cache底层：
- spring3.2内部集成两种存储机制：基于JDK的ConcurrentMap和encache库.
- guava: 4.0后开始支持.
- redis: https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/

# 二 Cache相关注解：
## (1)@Cacheable：
- 可用于类或方法，表示一个类的所有方法(用于类上)或指定方法(用于方法)的返回值被缓存.
- 若缓存中存在值，则不会执行该方法.

## (2)@CacheEvict：
- 可用于类或方法，表示一个方法或类上所有方法触发清除缓存操作.

## (3)@CachePut：
- 与@Cacheable类似，只是方法每次都会调用，返回结果会更新缓存中的结果.

## (4)@Caching

## (5)@EnableCaching：
- 用于开启缓存，需与@Configuration一起使用.