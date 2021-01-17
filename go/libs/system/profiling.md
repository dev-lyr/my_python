# 一 概述:
## (1)概述:

## (2)工具:
- runtime/pprof
- net/http/pprof

## (3)profiling数据生成方式:
- 代码中引入相关包.
- 使用go test

## (4)分析方式:
- go tool pprof
- 火焰图.

# 二 runtime/pprof:
## (1)概述: 
- pprof writes runtime profiling data in the format expected by the pprof visualization tool.


# 三 net/http/pprof
## (1)概述:
- pprof serves via its HTTP server runtime profiling data in the format expected by the pprof visualization tool.
