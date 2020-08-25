# 一 概述:
## (1)XML解析器:
- 树形解析器(tree parser): DOM(文档对象模型)解析器, 对应包: org.w3c.dom.
- 流机制解析器(streaming parser): 流机制解析器, SAX(Simple API for xml),对应包:org.xml.sax.

## (2)相关库:
- XStream:将对象序列化为xml文件或反之, https://x-stream.github.io.

# 二 XPath:
## (1)功能:
- XML路径语言, 用来查找XML文档中某位置, 基于XML的树形结构.
- 对应包: javax.xml.xpath.