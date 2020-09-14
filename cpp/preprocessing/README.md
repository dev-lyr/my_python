# 一 概述：
## (1)功能：
- 预处理语句用来控制预处理器的行为, 不是c语句在编译之前执行, 结尾没有分号;.
- 预处理在编译之前进行，只有条件为true，才会编译控制块中的代码.
- http://en.cppreference.com/w/c/preprocessor.

## (2)格式：
- 每个预处理语句一行，格式如下：`# 指令 参数`
- 备注: **无需分号**.

## (3)指令分类：
- 条件：#if, #ifdef, #ifndef, #else, #elif, #endif
- 替换：#define和#undef.
- 包含其它文件：#include
- 导致error：#error
- 其它：__FILE__、__LINE__、__DATE__、__TIME__或__TIMESTAMP__.
- 可以控制预处理器：#pragma

# 二 条件相关预处理语句： 
## (1)语法：
- 开头：#ifdef、#ifndef或#if.
- 中间：多个#elif和一个#else.
- 结尾：#endif.

## (2)#if和#elif：
- 语法：#if expression，表达式可以是字面值、#define定义常量等.
- 与if语句区别：在编译时刻根据条件判断需要编译哪些语句块.

## (3)#ifdef和#ifndef：
- 语法：#ifdef 标示符.
- 判断是否使用#define定义过某个标示符.
- 备注：#ifdef与#if defined(xxx)、#ifndef与#if !defined(xxx).

# 三 #include的两种形式：
## (1) #include<头文件>：
- 先搜索-I指定的目录
- 然后搜索gcc的环境变量CPLUS_INCLUDE_PATH
- 最后搜索gcc的内定目录：/usr/include、/usr/local/include等目录

## (2) #include“头文件”：
- 先搜索当前目录
- 然后搜索-I指定的目录
- 再搜索gcc的环境变量CPLUS_INCLUDE_PATH(C程序使用的是C_INCLUDE_PATH)
- 最后搜索gcc的内定目录，/usr/include、/usr/local/include等目录.