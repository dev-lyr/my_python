# 一 概述:
## (1)功能:
- Apache Commons项目旨在可重复使用的Java组件.
- 相关guava库.

## (2)组成:
- The Commons Proper: 创建和维护可重复使用的Java组件.
- The Commons Sandbox
- The Commons Dormant

## (3)常用组件:
- BeanUtils.
- Collections
- Lang
- Logging
- DBCP
- Codec: 实现了常用的编码和解码算法.
- 等等.

## (4)备注:
- https://commons.apache.org/

# 二 Collections:
## (1) CollectionUtils:
- collate: merge两个排序集合.
- collect: 根据自定义转换器(transformer)将输入迭代器(iterator)中所有元素进行转换，并把转换结果添加到一个输出集合(Collection).
- filter: 根据自定义Predicate过滤元素.
- transform: 对集合中每个元素根据自定义转换器(transformer)进行转换,输出元素类型是输入类型的子类型.

# 三 DBCP