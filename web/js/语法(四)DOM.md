# 一 概述：
## (1)功能(文档对象模型)：
- 针对HTML和XML提供的一个API.
- DOM描述一个层次化的节点树，允许开发人员添加、移除和修改页面的一部分.

# 二 Node类型

# 三 Document类型：
## (1)概述：
- js通过Document类型表示文档，在浏览器中document对象是HTMLDocument(继承Document类型)的一个实例，表示整个页面.
- document对象时window对象的一个属性.

## (2)document对象方法：
- getElementById()：跟进id查找元素，找到则返回该元素，找不到返回null，id大小写敏感.
- getElementByTagName()：返回包含零个或多个元素的NodeList.