# 一 分配和释放:
## (1)概述:
- malloc, free, calloc, realloc - allocate and free dynamic memory

## (2)malloc
- The malloc() function allocates size bytes and returns a pointer to the allocated memory.  
- The memory is not initialized.  
- If size is 0, then malloc() returns either NULL, or a unique pointer value that can later be successfully passed to free().

## (3)free:
- The free() function frees the memory space pointed to by ptr, which must have been returned by a previous call to malloc(), calloc() or realloc().  
- Otherwise, or if free(ptr) has already been called before, **undefined behavior occurs**.  
- If ptr is NULL, no operation is performed.

## (4)calloc

## (5)realloc

# 二 初始化:
## (1)memset

## (2)bzero:
- 已废弃, 优先使用memset.

# 三 其它操作:
## (1)复制:
- memcpy
- memmove
- bcopy: 已废弃, 优先使用memcpy和memmove.

## (2)比较:
- memcmp
- bcmp: 已废弃, 优先使用memcmp.
