# 一 概述:
## (1)功能:
- ASM is an all purpose Java bytecode manipulation and analysis framework. It can be used to modify existing classes or to dynamically generate classes, directly in binary form. 
- ASM provides some common bytecode transformations and analysis algorithms from which custom complex transformations and code analysis tools can be built.

## (2)使用场景:
- the OpenJDK, to generate the lambda call sites, and also in the Nashorn compiler,
- the Groovy compiler and the Kotlin compiler,
- Cobertura and Jacoco, to instrument classes in order to measure code coverage,
- **CGLIB**, to dynamically generate proxy classes (which are used in other projects such as Mockito and EasyMock),
- Gradle, to generate some classes at runtime.

## (3)备注:
- https://asm.ow2.io/