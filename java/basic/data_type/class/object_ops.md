# 一 概述： 
## (1)默认情况：
- 基本类型：都有一个初始值，数值为0，boolean为false.
- 对象引用：null.

## (2)备注：
- 静态成员只被初始化一次，且在非静态成员之前初始化.

# 二 三种初始化方式： 
## (1)指定初始化：
- 类中定义变量的地方直接初始化，C++不允许这么做.

## (2)构造函数初始化：
- 初始化顺序：变量定义的顺序.
- 调用父类构造函数：子类构造函数中调用super(xxxx).

## (3)初始化块：在构造函数之前执行.
- 静态成员：static{a=1; b=2}.
- 非静态成员：{a=1; b=2}.
- 备注：对匿名类比较重要.

## (4)初始化顺序：
- 首先，所有数据域被初始化为默认值(0、false或null)；
- 然后，按照在类中声明中出现顺序，依次执行所有域初始化语句和初始化块；
- 再次，执行构造函数.

# 三 java复制对象的三种方法： 
## (1)拷贝构造函数：
- 使用new的时候才会调用拷贝构造函数.
- 推荐使用.

## (2)clone方法：
- Object的clone方法对各个域进行对应拷贝，若对象中所有数据域都属于数值或基本类型则没有问题；若对象中包含子对象引用，拷贝结果是两个引用指向一个对象，即是浅拷贝，因此，必须重定义clone方法，实现对象的深拷贝.
- 重定义clone的方法：类实现Cloneable接口，
- 并使用一个公用的clone方法覆盖object的clone，在此公有clone内首先调用super.clone，然后再设置其他需要的参数.

## (3)序列化：
- Java Serializable序列化.
- 序列化为json字符串.
- 第三方库:protobuf, hessian.
 
# 四 析构对象： 
## (1)概述：
- Java中没有析构函数，因此需要做清理工作，需要手动创建一个执行清理工作的普通方法，该方法通常和try-finally结构结合起来使用，确保及时终止.
- finalize函数是在垃圾回收器准备释放对象占用的内存时，将首先调用finallize方法，垃圾回收没有发生时不会调用.
- 对象可能不被垃圾回收：可能直至面临存储空间用完，才可能进行垃圾回收，因为垃圾回收本身也需要开销.
- 垃圾回收不等于析构：垃圾回收只和内存相关.

## (2)finalize()方法：
- finalize方法是不可预测，也很危险，一般情况下不要使用.
- 当没有正式的清理方法时，可以当备胎（虽然不一定会被调用，但有比没有好），但此时应该在日志中记录一条警告，因为这表示代码中存在bug.

# 五 对象属性复制:
## (1)常用方法:
- Apache的commons-beanutils的BeanUtils和PropertyUtils.(反射机制)
- Spring的BeanUtils.(反射机制)
- cglib的BeanCopier.(动态代理)

## (2)cglib的BeanCopier:
- BeanCopier copier = BeanCopier.create(Source.class, Target.class, true/false): 该操作很耗费且可以重复调用，最好创建后作为全局static成员变量.
- Target类型需是Source类型的子类或就是Source类型.

## (3) Apache的BeanUtils:
- 要求Source类和Target类必须是public的, 可以是两个没有继承关系的类型.