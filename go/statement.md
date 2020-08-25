# 一 简单语句:
## (1)empty语句:
- 格式: 点号.
- 功能: 什么也不做.

## (2)labeled语句:
- label语句可能是goto, break或continue语句的target.

## (3)expression语句:
- 除了特定的内置函数, 其它函数和方法调用, 接收操作都可以出现在语句中.
- 例如: `h(x+y), f.close, <-ch等`.

## (4)send语句:
- 功能: 发送一个值到一个channel, channel表达式必须是channel类型, 且该channel允许send操作, 且值的类型必须是可以赋给channel的元素类型.
- 格式: `channel <- Expression`.

## (5)IncDec语句:
- 格式: expression ++或--.

## (6)赋值语句:
- 格式: `x = 1; x,y = f(); a,b,c = '1','2','3'; _ = x; x, _ = f()`

## (7)break语句:
- 格式: `break [label]
- 终止for, switch或select语句的执行.

## (8)continue语句:
- 格式: `continue [label]

## (9)return语句:
- 功能: 终止函数的执行, 并返回一个或多个执行结构值, 也可以没有.
- 格式: `return 表达式列表`

## (10)goto语句

# 二 for:
## (1)概述:
- Go只有一种循环结构, 即for循环.

## (2)语法:
- 初始化语句:可选.
- 循环条件表达式: 可选.
- 后置语句:可选.
- 三个语句无需用()括起来, 但循环体还是需要{}的, 例如: for i:=1; i<10; i++{}
- 三个语句可以为空, 但是;还是需要的, 除非只有一个条件语句.
- for i<100: 省掉;号变成go版本的while.

## (3)备注:
- go不支持前置++和--.
- for {}: 死循环.

# 三 if:
## (1)语法:
- if 条件 {}: 无需(), 有也支持.
- else if和else
- 支持在条件之前执行个简单语句, 例如: if err := func(); err != nil{}

# 四 switch:
## (1)语法:
- 两种类型: **表达式switch语句**和**类型switch语句**.
- 表达式switch: `ExprSwitchStmt = "switch" [ SimpleStmt ";" ] [ Expression ] "{" { ExprCaseClause } "}"`.
- 类型switch: `TypeSwitchStmt  = "switch" [ SimpleStmt ";" ] TypeSwitchGuard "{" { TypeCaseClause } "}"`.
- switch os := runtime.GOOS; os{case 'linux':xxx case "drawin":xxx default:xxx}
- 默认分支会自动跳出, 除非指定fallthrough.

## (2)类型表达式:
- 格式: switch x.(type){case type1:... case type2:...}
- 所有case中的类型必须实现x的类型.

## (3)fallthrough语句:
- A "fallthrough" statement transfers control to the first statement of the next case clause in an expression "switch" statement. 
- It may be used only as the final non-empty statement in such a clause.
- 默认switch的case带有break语句, 使用fallthrough可以直接执行下个case的语句(case条件为false也会执行), fallthrough不能出现在最后一个case中.

# 五 defer:
## (1)功能:
- 延迟函数的执行, 直至上层函数(调用它的函数)返回.
- 延迟函数的调用被压入栈中, 当函数返回时根据后进先出的顺序调用被延迟的函数.

# 六 go语句:
## (1)功能:
- 已独立并发线程或者goroutine来调用一个函数执行.
- 格式: `go expression`.

# 七 Select语句
## (1)功能:
- A "select" statement chooses which of a set of possible send or receive operations will proceed.
- 与switch类似, 但是所有case都是关于communication operations(send语句, 接收语句).

## (2)语法:
 -SelectStmt = "select" "{" { CommClause } "}" .
 -CommClause = CommCase ":" StatementList .
 -CommCase   = "case" ( SendStmt | RecvStmt ) | "default" .
 -RecvStmt   = [ ExpressionList "=" | IdentifierList ":=" ] RecvExpr .
 -RecvExpr   = Expression .

## (3)执行顺序:
- For all the cases in the statement, the channel operands of receive operations and the channel and right-hand-side expressions of send statements are evaluated exactly once, in source order, upon entering the "select" statement. The result is a set of channels to receive from or send to, and the corresponding values to send. Any side effects in that evaluation will occur irrespective of which (if any) communication operation is selected to proceed. Expressions on the left-hand side of a RecvStmt with a short variable declaration or assignment are not yet evaluated.
- If one or more of the communications can proceed, a **single one** that can proceed is chosen via a uniform pseudo-random selection. Otherwise, if there is a default case, that case is chosen. If there is no default case, the "select" statement **blocks** until at least one of the communications can proceed.
- Unless the selected case is the default case, the respective communication operation is executed.
- If the selected case is a RecvStmt with a short variable declaration or an assignment, the left-hand side expressions are evaluated and the received value (or values) are assigned.
- The statement list of the selected case is executed.

## (4)备注:
- select{}: 永远阻塞.
