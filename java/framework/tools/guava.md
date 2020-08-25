# 一 概述:
## (1)功能:
- Guava is a set of core libraries that includes new collection types (such as multimap and multiset), immutable collections, a graph library, functional types, an in-memory cache, and APIs/utilities for concurrency, I/O, hashing, primitives, reflection, string processing, and much more!

## (2)包含packages:
- com.google.common.annotations
- com.google.common.base
- com.google.common.cache
- com.google.common.collect
- com.google.common.escape
- com.google.common.eventbus
- com.google.common.graph
- com.google.common.hash
- com.google.common.html
- com.google.common.io
- com.google.common.math
- com.google.common.net
- com.google.common.primitives
- com.google.common.reflect
- com.google.common.util.concurrent
- com.google.common.xml

## (3)备注:
- https://github.com/google/guava

# 二 com.google.common.collect:
## (1) Lists、Sets、Maps和Queues:
- Lists: 与List实例相关的静态工具方法.
- Sets: 与Set实例相关的静态工具方法.
- Maps: 与Map实例相关的静态工具方法.
- Queues: 与Queue和Deque实例相关的静态工具方法.

## (2)Collection2.

# 三 com.google.common.cache:
## (1)概述:
- 基于应用内存的cache.

## (2)Cache接口:
- 一个semi-persistent键值映射, 可通过get(Object, Callable)或put(Object,Object)来添加, 直至evicted或手动设置失效, 通常使用**CacheBuilder**来创建.
- 实现该接口的类期待是线程安全的.
- get(Object, Callable): 返回cache中key对应的cache值, 若不存在从Callable对象中获得, 并别把该缓存到cahche中. 模式: 若缓存,返回; 反之,创建,缓存和返回.

## (3)LoadingCache:
- 一个semi-persistent键值映射, cache不存在时会被自动load, 直至evicted或手动设置失效.

## (4)CacheBuilder

# 四 com.google.common.util.concurrent:
## (1)RateLimiter
- 功能: 速率限制器, 以配置的速率分配进入量(permits).
- 线程安全的, 但不保证是公平.
- 基于令牌桶算法(token bucket).
