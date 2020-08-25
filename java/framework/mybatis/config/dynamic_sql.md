# 一 相关元素：
- (1)if
- (2)choose(when和otherwise)：类似switch语句.
- (3)trim(where, set)
- (4)foreach
- (5)bind

# 二 if：
## (1)语法：
- `<if test="name != null">...</if>`
- `<if test="num>0">...</if>`
- `<if test="name!=null and num>0"></if>`
- `<if test="list!=null and list.size()>0"></if>`

# 三 choose(when和otherwise):
## (1)功能：
- 类似switch，选择满足一个选项的情况.

## (2)例子:
`
<choose>
    <when test="name!=null">
        ...
    </when>
    <when test="age>0">
        ...
    <when>
    <otherwise>
        ...
    </otherwise>
</choose>
`

# 四 `trim(where, set)`：
## (1)`<where>`：
- 功能：里面有内容返回才会插入where；并且若内容以and或or开头，则会跳过.
- 例如：`<where> <if test="name!=null">name=${name}</if></where>`

## (2)`<set>`：
- 功能：里面有内容返回才会插入set；会去掉结尾多余的,。
- 例如：`<set><if test="name!=null">name=${name},</if></set>`

## (3)`<trim>`：
- 与`<where>`等同：`<trim prefix="where" prefixOverrides="AND | OR"><if test="name!=null">name=${name}</if></trim>`.
- 与`<set>`等同：`<trim prefix="set" suffixOverrides=","><if test="name!=null">name=${name},</if><trim>`.

# 五 `<foreach>`：
## (1)功能：
- 遍历集合，通常用来创建IN条件.
- 例如：in <foreach item="item" index="index" collection="list" open="(" separator="," close=")"> #{item} </foreach>

## (2)collection参数：
- 若传入参数只有一个且是list，则collection="list"
- 若传入参数只有一个且是数组，则collection="array"
- 若传入参数有多个则是对应@Param指定的key.

## (3)备注：
- 返回集合时不能再使用resultMap，而使用resultType设置为指定元素的类型，同时数据库的字段需要使用as转换为给定类型的字段.
- 若list是空集合则会报非法sql，所以调用这个语句前需判断list不为空.
- 批量插入时不能使用useGeneratedKeys和keyProperty来获取数据库自增字段的值.