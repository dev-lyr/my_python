# 一 encoding/json
## (1)功能:
- 实现了RFC7159定义的JSON编码和解码.
- 通过Marshal和Unmarshal函数来处理json到go值之间的映射.

## (2)函数:
- Marshal(v interface{})([]byte, error): 返回v的JSON字符串.
- Unmarshal
- Valid(data [] byte) bool: 判断一个字节数组是不是合法的JSON.

## (3)编码规则:
- 若值实现Marshaler接口且不为nil指针, Marshal调用它的MarshalJSON方法来产生JSON.
- 若没有MarshalJSON方法但是实现encoding.TextMarshaler, 则Marshal调用MarshalText和将结果编码为JSON.
- 若没有上述情况, 则Marshal使用类型默认的编码规则: Boolean->JSON boolean; Floating point, integer, Number值->JSON numbers; String->JSON string强制使用UTF-8, 将非法字节替换为Unicode; Array和slice->JSON数组, 除了[]bytes会被变为为base64的字符串, nil slice会变为null JSON值; struct->JSON对象, 每个exported的struct属性作为对象的成员, 使用struce的属性名字作为对象的key, 除非特别指定.
- struct的定制化格式: `json:-`(不编码), `json:"name,omitempty"`, `json:",omitempty"`等.

## (4)备注:
- https://golang.google.cn/pkg/encoding/json/

# 二 encoding/xml
