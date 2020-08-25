# 一 概述:
## (1)关键字列表:
- abstract
- assert
- boolean
- break
- byte
- case
- catch
- char
- class
- const
- continue
- default
- do
- double
- else
- enum
- extends
- final
- finally
- float
- for
- goto
- if
- implements
- import
- instanceof
- int
- interface
- long
- native
- new
- package
- private
- protected
- public
- return
- short
- static
- strictfp
- super
- switch
- synchronized: 参见my_java_concurrent.
- this
- throw
- throws
- transient: 标记类中的属性是不可序列化的.
- try
- void
- volatile: 参见my_java_concurrent.
- while

# 二 this和super:
## (1)this关键字：
- 只能在方法内部调用，表示"调用方法的那个对象"的引用.
- 在构造函数中调用另外一个构造函数.
- 若方法内部调用同一个类的另一个方法，则不必使用this.

## (2)super关键字(表示基类)：
- 子类覆盖基类的方法，在该方法中调用基类版本.
- 在子类中调用基类的构造函数(super(...))，主要是基类没有默认构造函数的情况, super(...)只能用在子类的构造函数中.
