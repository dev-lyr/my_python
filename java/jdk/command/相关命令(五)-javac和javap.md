# 一 javac:
## (1)功能:
- 读取Java写的类和接口的定义文件, 把它们编译为字节码文件.
- 可以处理Java源文件和类的注解.
- 用法: javac [option] [sourcefiles] [classes] [@argfiles]

## (2)选项(非标准-X):
- -cp path/-classpath path: 指定查找类文件, 注解处理器和源文件的地方.
- -d directory: 设置生成的class文件的位置, 必须是已存在目录.

# 二 javap
## (1)功能:
- 反汇编一个或多个类文件.
- 用法: javap [options] classfile ...

## (2)选项:
- -c: 打印反汇编的code, 例如: 组成Java字节码的指令.
- -l: 打印行号和局部变量表.
- -s: 打印内部type signatures.