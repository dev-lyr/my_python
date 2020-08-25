# 一 概述：
## (1)特点：
- 所有注解接口都隐式扩展自java.lang.annotation.Annotation接口.
- 注解不会改变对程序的编译方式，java编译器对包含注解和不包含注解的代码生成相同的虚拟机指令.
- 使用注解除了注解本身，还需要实现一个注解处理工具.
- 注解的member中类型有限制, 比如:不支持Boolean.

## (2)注解成员类型：
- 每个元素的声明形式：type elementName() [ default value ];
- type: 基本类型,String,Class,enum类型,注解类型和上述类型组成的数组.

## (3)注解类型:
- 普通注解
- 标记注解
- 单元素注解
- 参考: java语言规范.

## (4)注解功能:
- 编译器类型检查.
- 可用来生成描述符文件.

## (5)注解解析:
- 类级别：Class.getAnnotation.
- 方法级别：method.getAnnotation.
- 属性级别：filed.getAnnotation.

## (6)标记注解(Marked Annotation):
- 没有参数的注解, 只是标注被注解的元素.
- 相关标记接口.

# 二 常用注解:
## (1)java.lang
- @Deprecated：注释该元素过时，不建议使用。
- @Override：表示当前方法定义将覆盖超类中的方法，若拼错，编译器会报错。
- @SuppressWarnings：过滤不必要的编译器警告信息。
- @SafeVarargs：A programmer assertion that the body of the annotated method or constructor does not perform potentially unsafe operations on its varargs parameter.

## (2)javax.annotation：
- Generated
- PostConstruct
- PreDestroy
- Resource
- Resources

# 三 元注解：
## (1)@Retention：
- 功能：用于指定一条注解应该保留多长时间.
- 根据元注解@Retention不同，三种处理级别：源码级别、字节码级别和运行时.
- 运行时注解：使用Java反射机制来处理注解.

## (2)@Target：
- 功能：限制注解可以用在哪些项上，比如：类，方法或变量等，没有@Target则表示没有限制，可用于任何项上.

## (3)@Inherited：
- 功能：允许子类继承父类中的注解.
- 只能用于对类进行注解.

## (4)@Documented：
- 功能：表示该注解应该被Javadoc工具识别，并记录到文档中.
