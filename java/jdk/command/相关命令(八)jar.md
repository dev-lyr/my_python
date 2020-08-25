# 一 概述:
## (1)jar(Java Archive Tool):
- jar: combines multiple files into a single JAR archive file.

## (2)用法:
- jar {ctxui}[vfm0Me] [jar-file] [manifest-file] [entry-point] [-C dir] files ...

## (3)选项:
<pre><code>
    -c  create new archive
    -t  list table of contents for archive
    -x  extract named (or all) files from archive
    -u  update existing archive
    -v  generate verbose output on standard output
    -f  specify archive file name
    -m  include manifest information from specified manifest file
    -e  specify application entry point for stand-alone application
        bundled into an executable jar file
    -0  store only; use no ZIP compression
    -M  do not create a manifest file for the entries
    -i  generate index information for the specified jar files
    -C  change to the specified directory and include the following file
If any file is a directory then it is processed recursively.
The manifest file name, the archive file name and the entry point name are
specified in the same order as the 'm', 'f' and 'e' flags.
</code></pre>

## (4)实例:
<pre><word>
创建jar包:
jar cvf test.jar A.class B.class
jar cvfe test.jar A A.class B.class()
jar cvfm test.jar mymanifest A.class B.class: 注意m选项要在f后面，添加自定义manifest文件内容.

查看jar包:
jar tf test.jar

解压jar包:
jar xvf test.jar
</code></pre>

## (5)参考:
- https://docs.oracle.com/javase/tutorial/deployment/jar/manifestindex.html

## (6)其它:
- WAR: web application archive
- SAR: service archive
- EAR: enterprise archive

# 二 MANIFESTS.MF文件:
## (1)概述:
- 用jar创建jar包时，会自动添加一个默认的manifest文件，路径为META-INF/MANIFEST.MF，默认的manifest文件包含以下内容:
Manifest-Version: 1.0
Created-By: 1.7.0_06 (Oracle Corporation).
- 文件项目格式: "header: value"，冒号之后要有空格.
- 可通过jar cfm jar-file manifest-addition input-file(s)添加自定义manifest项目.

## (2)设置程序入口(entry point)的两种方法:
- 方法1: 在manifest文件中添加Main-Class: classname.
- 方法2: 可以通过e选项在创建jar时添加entry point，例如：jar -cfe test1.jar person person.class.
- Entry point is a class having a method with signature public static void main(String[] args).
- 使用jar文件: java -jar name.jar