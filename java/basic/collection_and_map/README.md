# 一 java集合类：
## (1)Collection接口(extends Iterable):
- **List**(Collection，Iterable): ArrayList: 随机访问元素性能好，但中间插入和删除较慢; LinkedList: 随机访问较慢，适合插入和删除元素; Vector;Stack.
- **Set**(Collection，Iterable): HashSet: 底层是散列表; TreeSet: 一个有序的集合，底层红黑树.
- **Queue**(Collection，Iterable): LinkedList; PriorityQueue(优先级队列)等.

## (2)map接口
- HashMap(map, Cloneable, Serializable)
- TreeMap: 底层红黑树.
- HashTable

## (3)注意：
- 容器不支持创建基本类型的容器，对应基本类型可使用数组。
- foreach语法可用于所有Collection，因为Collection继承Iterable.

## (4)重要类：
- java.util.Collections.

# 二 线程安全集合：
## (1)概述:
- 包含一些本身就是线程安全的集合以及使用Collections.synchronizedXXX方法将现有集合转换为线程安全(使用互斥量,性能较差).

## (2)ConcurrentMap: 
- ConcurrentHashMap和ConcurrentSkipListMap

# 三 for-each语句：
## (1)功能：
- 遍历集合首选方法.
- for(Element e : c){}
- 不仅能遍历集合和数组，还能遍历任何实现Iterable接口的对象.
- 只有实现Iterable接口才可以使用for-each循环.

## (2)不能使用情况：
- 遍历集合过程中需删除元素，此时需要显式迭代器，以便可以调用迭代器的remove方法删除元素.
- 改变列表或数组中部分元素的值，此时需要所用.
- 并行遍历多个集合.

## (3)不能使用for-each时使用：
- 集合遍历：for(Iterator i = c.iterator(); i.hashNetxt();){//i.next();}
- 遍历数组：for(int i =0; i<a.length; ++i){}

# 四 排序：
## (1)List的两种排序方法：
- Collections.sort(aList)：该aList需实现Comparable接口并实现compare方法.
- Collections.sort(aList, new Comparator(){...})：需提供一个Comparator匿名类作为比较方法.
- List.sort方法.

## (2)Set的排序：
- 使用TreeSet，元素类需实现comparable接口，TreeSet会自动调用compareTo方法比较.
- TreeSet(new Comparator(){...})：创建set时指定一个比较器.
- 基于红黑树, 实现log(n)时间的add, remove和contain.

## (3)Map的排序:
- 使用TreeMap.
- 基于红黑树, 实现log(n)时间的add, remove和contain.

# 五 迭代器(Iterator):
## (1)概述:
- 每类容器定义自己的迭代器.
- 用来遍历容器中的元素.

## (2)接口:
- hasNext: 当迭代器还有元素时候返回true, 逻辑就是判断当前cursor!=size.
- next: 返回下一个元素(lastRet=curosr, cursor+1), 若抛出NoSuchElementException, 使用前可使用hasNext看下有没有下一个元素.
- remove: 从当前集合中删除iterator返回的最后一个元素, 该方法在调用next后执行(删除lasfRet).
- forEachRemaining: 对集合中元素执行某个action, 直至全部执行完或者抛出异常.

## (3) 经验:
- **ConcurrentModificationException**异常: 容器的迭代器维护了一个expectedModCount变量, 当创建迭代器时初始化为容器元素的大小modCount, 当容器增加或删除元素时会增加和减少modCount, 当再次调用迭代器相关函数时检查发现expectedModCount!=modCount则会抛出该异常.
- **IllegalStateException**异常: 容器的迭代器维护了一个lastRet变量，初始化为-1, 当调用迭代器的next函数时会赋值为当前元素的位置(调用next后当前元素已经移动一位, 即迭代器指向原来的当前元素的位置), 调用remove前会判断lastRef若小于0则抛出该异常, 若lastRef不为-1(即在调用remove前调用了next)则继续执行，remove函数最后会将lastRet重新设置为-1.

# 六 Collections类.