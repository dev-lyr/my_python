# 一 reflect包:
## (1)功能:

## (2)函数:
- TypeOf: 接入任意interface{}类型, 返回一个表示其动态类型的反射类型reflect.Type.
- ValueOf: 接入任意interface{}类型, 返回一个装在装载其动态值的reflect.Value.
- DeepEqual.

## (3)类型:
- Type(interface): 表示一个Go类型,提供许多方法.
- Value(struct): 到一个go value的反射接口.

## (4)常量:
- 各种类型: reflect.Int, reflect.Bool等.

## (5)备注:
- https://golang.google.cn/pkg/reflect/
