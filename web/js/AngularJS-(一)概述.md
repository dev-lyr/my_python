# 一概述:
## (1)架构:
- AngularJS is a structural framework for dynamic web apps. It lets you use HTML as your template language and lets you extend HTML's syntax to express your application's components clearly and succinctly. AngularJS's data binding and dependency injection eliminate much of the code you would otherwise have to write. And it all happens within the browser, making it an ideal partner with any server technology.

## (2)备注:
- angular1和2差别大, 本文主要介绍angular1.
- angular1: https://angularjs.org/; 
- API手册: https://docs.angularjs.org/api
- http://www.runoob.com/angularjs/angularjs-tutorial.html
- angular2: https://angular.io/
- http://www.runoob.com/angularjs/angularjs-tutorial.html

## (3)相关:
- ui-select: https://github.com/angular-ui/ui-select/wiki

# 二 Modules(模块):
## (1)功能:
- 可把module看做是controllers, services, filters和directives等的一个容器.
- 所有module需通过angular.module注册才能使用.
- angular.module: creating, registering and retrieving AngularJS modules.

## (2)module的API:
- moduleName.controller
- moduleName.service
- moduleName.filter
- 备注: https://docs.angularjs.org/api/ng/type/angular.Module

## (3)ng模块:
- ng模块默认在Angular JS应用启动时候被load, 该模块包含AngularJS应用必须的一些组件.

# 三 Controllers:
## (1)功能:
- Controller通过js构造函数来定义, 用来参数化AngularJs Scope.
- 使用Controller来: 设置$scope对象的初始状态; 添加行为到$scope对象.

## (2)Controoler的构造函数:
- ngControoler指令: ng-controller
- 等等.

# 四 Services:
## (1)功能:
- AngularJS中可以使用内建服务或自定义服务.

## (2)内建服务:
- $http
- $location
- $log: 简单的日志服务, 默认将日志写入web的console.
- $timeout: window.setTimeout的AngularJS封装.
- $window: 一个浏览器window对象的引用.
- $q: 帮助异步执行函数并在完成处理后使用返回值(或异常).
- 备注: https://docs.angularjs.org/api/ng/service

# 五 Scopes:
## (1)功能:
- Scope is the glue between application controller and the view. During the template linking phase the directives set up $watch expressions on the scope. The $watch allows the directives to be notified of property changes, which allows the directive to render the updated value to the DOM.

- scope 是一个 JavaScript 对象，带有属性和方法，这些属性和方法可以在视图和控制器中使用.

# 六 数据binding

# 七 Filters:
# (1)功能:
- 过滤器用于转换数据, 使用一个管道(字符为|)添加到表达式(expression)和指令(directive).

## (2)过滤器种类:
- filter: 从数组项中选择一个子集.
- orderBy: 根据某个表达式排序数组.
- lowercase: 将字符串转为小写.
- uppercase: 将字符串转为大写.
- currency: 将数字转换为货币格式
- 备注: https://docs.angularjs.org/api/ng/filter

# 八 Directives

# 九 表达式(Expressions):
## (1)功能:
- AngularJS使用表达式把数据绑定到HTML, 表达式格式:{{expression}}.

