# 一 Map接口:
## (1)概述:
- 映射keys到values, 不能包含重复的keys.
- 三种集合视图: keys, values, key-value mappings.
- 部分Map实现是按照key有序的, 比如TreeMap; HashMap则没有.

## (2)常用子类:
- ConcurrentMap.
- SortedMap
- HashMap
- Hashtable

## (3)其它:
- MultiMap: guava提供, jdk没有.

# 二 HashMap:
## (1)影响性能的两个参数:
- 初始容量(initial capacity)
- 负载因子(load factor): 默认是0.75. 太大降低空间开销, 但是会增加查询开销.
- 备注: 当元素数量超过负载因子和当前容量时, hash表会被rehash.

## (2)属性:
- DEFAULT_LOAD_FACTOR: 默认负载因子,0.75f.
- Node<K,V>[] table: 存放元素的数组, capacity()返回该数组长度.
- int size: map中键值key的数量.
- TREEIFY_THRESHOLD=8: 当冲突链表长度>=8时会被转换为一个红黑树.
- UNTREEIFY_THRESHOLD=6
- MIN_TREEIFY_CAPACITY=64

## (3)HashMap和HashTable的区别:
- HashMap允许null的key和value, HashTable不允许.
- HashMap不是线程安全的; HashTable是同步的, 线程安全的Map, 方法使用synchronized修饰.

# 三 有序的Map(SortedMap):
## (1)概述:
- 一个可以根据key进行排序的Map, 排序规则依据key的自然排序或创建map是提供的比较器(comparator).
- SortedMap中的所有key必须实现Comparable接口或可以被指定的比较器(comparator)接受.
- 所有key必须是可以相互比较(mutually comparable)的, 不会抛出ClassCastException.
- 实现类:ConcurrentSkipListMap、TreeMap.

## (2)TreeMap:
- 基于红黑树实现, 保证了logN的containsKey, get, put和remove操作.

## (3)ConcurrentSkipListMap:
- 实现跳跃表的一个并发版本, 期望平均logN的containsKey, get, put和remove操作.

# 四 线程安全Map:
## (1)实现方案:
- Hashtable: 性能差, 线程安全的Map, 方法使用synchronized修饰.
- ConcurrentMap接口的实现类: ConcurrentHashMap和ConcurrentSkipListMap
- Collections.synchronizedMap方法: 底层还是使用synchronized来修饰所有方法.
