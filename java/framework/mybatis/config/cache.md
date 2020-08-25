# 一 概述：
## (1)功能:
- 映射文件中的所有select都将会被缓存.
- 映射文件中的所有insert、update和delete语句会刷新缓存.

## (2)Mybatis缓存分类：
- 一级缓存：即本地缓存，默认开启，默认作用域为session，当session flush或close后，该Session内所有cache被清空.
- 二级缓存：默认关闭.
- 备注: Spring整合mybatis取sqlsession方法, 同一线程两次查询可能的sqlSession不同.

## (3)相关配置项：
- 全局setting中的cacheEnabled: 全局地开启或关闭配置文件中的所有映射器已经配置的任何缓存, 默认为true.
- 全局setting中的localCacheScope: Session(默认)或statement.
- `<cache>`：mapper级别的二级缓存.
- `<cache-ref>`：使用其它命名空间中的缓存机制，即共享缓存方案.
- useCache属性: 将其设置为 true，将会导致本条语句的结果被二级缓存, 默认值对select是true.
- flushCache属性: 将其设置为true, 任何时候只要语句被调用, 都会导致本地缓存和二级缓存都会被清空, 默认为false.

# 二 `<cache>`配置项：
## (1)功能：
- 开启Mapper级别的二级缓存.
- 可使用`<set>`开启全局的二级缓存.

## (2)属性：
- eviction：回收策略，可选有：FIFO、LRU、SOFT和WEAK，默认为LRU.
- flushInterval：刷新时间，毫秒为单位，默认不设置，缓存仅仅在调用语句时刷新.
- size：默认为1024，设置引用数目.
- readOnly：只读属性，默认为false.

## (3)自定义缓存方案：
- `<cache type="MyCache">`：type指定的类必须实现org.mybatis.cache.Cache接口.