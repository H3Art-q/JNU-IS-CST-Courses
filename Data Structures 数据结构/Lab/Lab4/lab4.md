# 实验四

## 一. 背景知识
常用的搜索和排序算法


## 二. 目的要求
1. 能够解释并实现顺序搜索和二分搜索
2. 能够解释并实现冒泡排序、选择排序、插入排序、希尔排序、归并排序和快速排序
3. 理解散列和映射


## 三. 实验内容
1. 实现无序列表和有序列表的顺序搜索并分析比较次数
2. 分别用递归和非递归的方法实现对有序列表的二分搜索并分析比较次数
3. 实现冒泡排序算法及改进后的短冒泡排序算法
4. 实现选择排序算法
5. 实现插入排序算法
6. 实现希尔排序算法
7. 实现归并排序算法
8. 实现快速排序算法

### 进阶
1. 实现映射（map）抽象数据类型及相关方法
2. 有一种改进快速排序的办法，那就是在列表长度小于某个值时采用插入排序（这个值被称为“分区限制”）。重新实现快速排序算法，并给一个随机整数列表排序。采用不同的分区限制进行性能分析。


## 四. 实验结果
*测试数据准备*
```python
import time
import operator

# 数据规模为100000，用于搜索测试
file1 = open("unorderedData.txt", mode='r')
file2 = open("orderedData.txt", mode='r')

# 数据规模为1000，用于排序测试
file3 = open("unsortedData.txt", mode='r')
file4 = open("sortedData.txt", mode='r')

l1 = file1.read().split()
unorderedData = list(int(i) for i in l1)

l2 = file2.read().split()
orderedData = list(int(i) for i in l2)

l3 = file3.read().split()
unsortedData = list(int(i) for i in l3)

l4 = file4.read().split()
sortedData = list(int(i) for i in l4)
```


1. 实现无序列表和有序列表的顺序搜索并分析比较次数
- 测试代码
```python
from LinearSearch import *

# 无序列表的顺序搜索：
print("Test for sequential search of unordered list:")

# 存在目标元素的最好情况
print("The best condition of searching an existing element:")
start = time.time()
sequentialSearch(unorderedData, unorderedData[0])
end = time.time()
print("Time used: %fs\n" % (end - start))

# 存在目标元素的最坏情况
print("The worst condition of searching an existing element:")
start = time.time()
sequentialSearch(unorderedData, unorderedData[99999])
end = time.time()
print("Time used: %fs\n" % (end - start))

# 存在目标元素的中间情况
print("The mid condition of searching an existing element:")
start = time.time()
sequentialSearch(unorderedData, unorderedData[49999])
end = time.time()
print("Time used: %fs\n" % (end - start))

# 不存在目标元素的最好情况
print("The best condition of searching an inexistent element:")
start = time.time()
sequentialSearch(unorderedData, unorderedData[0] - 1)
end = time.time()
print("Time used: %fs\n" % (end - start))

# 不存在目标元素的最坏情况
print("The worst condition of searching an inexistent element:")
start = time.time()
sequentialSearch(unorderedData, unorderedData[99999] + 1)
end = time.time()
print("Time used: %fs\n" % (end - start))

# 不存在目标元素的中间情况
print("The mid condition of searching an inexistent element:")
start = time.time()
sequentialSearch(unorderedData, unorderedData[49999] + 1)
end = time.time()
print("Time used: %fs\n" % (end - start))

# 有序列表的顺序搜索：
print("Test for sequential search of ordered list:")

# 存在目标元素的最好情况
print("The best condition of searching an existing element:")
start = time.time()
orderedSequentialSearch(orderedData, orderedData[0])
end = time.time()
print("Time used: %fs\n" % (end - start))

# 存在目标元素的最坏情况
print("The worst condition of searching an existing element:")
start = time.time()
orderedSequentialSearch(orderedData, orderedData[99999])
end = time.time()
print("Time used: %fs\n" % (end - start))

# 存在目标元素的中间情况
print("The mid condition of searching an existing element:")
start = time.time()
sequentialSearch(orderedData, orderedData[49999])
end = time.time()
print("Time used: %fs\n" % (end - start))

# 不存在目标元素的最好情况
print("The best condition of searching an inexistent element:")
start = time.time()
orderedSequentialSearch(orderedData, orderedData[0] - 1)
end = time.time()
print("Time used: %fs\n" % (end - start))

# 不存在目标元素的最坏情况
print("The worst condition of searching an inexistent element:")
start = time.time()
orderedSequentialSearch(orderedData, orderedData[99999] + 1)
end = time.time()
print("Time used: %fs\n" % (end - start))

# 存在目标元素的中间情况
print("The mid condition of searching an inexistent element:")
start = time.time()
sequentialSearch(orderedData, orderedData[49999] + 1)
end = time.time()
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Test for sequential search of unordered list:
The best condition of searching an existing element:
Time used: 0.000003s

The worst condition of searching an existing element:
Time used: 0.007116s

The mid condition of searching an existing element:
Time used: 0.003720s

The best condition of searching an inexistent element:
Time used: 0.007148s

The worst condition of searching an inexistent element:
Time used: 0.006989s

The mid condition of searching an inexistent element:
Time used: 0.007182s

Test for sequential search of ordered list:
The best condition of searching an existing element:
Time used: 0.000003s

The worst condition of searching an existing element:
Time used: 0.008871s

The mid condition of searching an existing element:
Time used: 0.003570s

The best condition of searching an inexistent element:
Time used: 0.000001s

The worst condition of searching an inexistent element:
Time used: 0.009058s

The mid condition of searching an inexistent element:
Time used: 0.007221s
```

- 比较次数分析

在无序列表中进行顺序搜索时的比较次数
||最好情况|最坏情况|普通情况|
|-|-|-|-|
|存在目标元素|$1$|$n$|$\displaystyle\frac{n}{2}$|
|不存在目标元素|$n$|$n$|$n$|

在有序列表中进行顺序搜索时的比较次数
||最好情况|最坏情况|普通情况|
|-|-|-|-|
|存在目标元素|$1$|$n$|$\displaystyle\frac{n}{2}$|
|不存在目标元素|$1$|$n$|$\displaystyle\frac{n}{2}$|


2. 分别用递归和非递归的方法实现对有序列表的二分搜索并分析比较次数
- 测试代码
```python
from BinarySearch import *

print("Recursive Binary Search:")

print("For existing element:")
print(recurBinarySearch(orderedData, 838434709))
print(recurBinarySearch(orderedData, 540456683))
print("For inexistent element:")
print(recurBinarySearch(orderedData, 124242850))
print(recurBinarySearch(orderedData, 740082764))
print()

print("Iterative Binary Search:")

print("For existing element:")
print(iterBinarySearch(orderedData, 838434709))
print(iterBinarySearch(orderedData, 540456683))
print("For inexistent element:")
print(iterBinarySearch(orderedData, 124242850))
print(iterBinarySearch(orderedData, 740082764))
print()
```

- 测试结果
```
Recursive Binary Search:
For existing element:
True
True
For inexistent element:
False
False

Iterative Binary Search:
For existing element:
True
True
For inexistent element:
False
False
```

- 比较次数分析

二分搜索算法的表格分析
|比较次数|剩余元素的近似个数|
|-|-|
|$1$|$\displaystyle\frac{n}{2}$|
|$2$|$\displaystyle\frac{n}{4}$|
|$3$|$\displaystyle\frac{n}{8}$|
|$\vdots$|$\vdots$|
|$i$|$\displaystyle\frac{n}{2^i}$|


3. 实现冒泡排序算法及改进后的短冒泡排序算法
- 测试代码
```python
from BubbleSort import *

print("For a totally unsorted data:")

print("Bubble Sort:")
templist = list(i for i in unsortedData)
start = time.time()
bubbleSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Short Bubble Sort:")
templist = list(i for i in unsortedData)
start = time.time()
shortBubbleSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("For a sorted data:")

print("Bubble Sort:")
start = time.time()
bubbleSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Short Bubble Sort:")
start = time.time()
shortBubbleSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
For a totally unsorted data:
Bubble Sort:
Result check: True
Time used: 0.038051s

Short Bubble Sort:
Result check: True
Time used: 0.041645s

For a sorted data:
Bubble Sort:
Result check: True
Time used: 0.021720s

Short Bubble Sort:
Result check: True
Time used: 0.000048s
```

4. 实现选择排序算法
- 测试代码
```python
from SelectionSort import *

print("Selection Sort:")
templist = list(i for i in unsortedData)
start = time.time()
selectionSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Selection Sort:
Result check: True
Time used: 0.017077s
```

5. 实现插入排序算法
- 测试代码
```python
from InsertionSort import *

print("Insertion Sort:")
templist = list(i for i in unsortedData)
start = time.time()
insertionSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Insertion Sort:
Result check: True
Time used: 0.019430s
```

6. 实现希尔排序算法
- 测试代码
```python
from ShellSort import *

templist = list(i for i in unsortedData)
start = time.time()
shellSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Shell Sort:
Result check: True
Time used: 0.001421s
```

7. 实现归并排序算法
- 测试代码
```python
from MergeSort import *

print("Merge Sort:")
templist = list(i for i in unsortedData)
start = time.time()
mergeSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Merge Sort:
Result check: True
Time used: 0.001500s
```

8. 实现快速排序算法
- 测试代码
```python
from QuickSort import *

print("Quick Sort:")
templist = list(i for i in unsortedData)
start = time.time()
quickSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Quick Sort:
Result check: True
Time used: 0.000953s
```

9.  实现映射（map）抽象数据类型及相关方法
- 测试代码
```python
from pythonds import *

myMap = Map()

myMap.put(1, 2021102716)
myMap[114514] = "cat"

print(myMap.len())
print(myMap[1])
print(myMap.get(114514))


print(3 in myMap)
print(114514 in myMap)

del myMap[3]
print(myMap.len())

del myMap[1]
print(1 in myMap)
print(myMap.len())

print()
```

- 测试结果
```
2
2021102716
cat
False
True
2
False
1
```

10. 重新实现快速排序算法，并给一个随机整数列表排序。采用不同的分区限制进行性能分析
- 测试代码
```python
from QuickSort_Modified import *

print("Quick Sort modified:")

print("Min partition size: 75")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 75)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 50")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 50)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 40")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 40)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 30")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 30)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 25")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 25)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 20")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 20)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 10")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 10)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))

print("Min partition size: 5")
templist = list(i for i in unsortedData)
start = time.time()
modQuickSort(templist, 5)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))
```

- 测试结果
```
Quick Sort modified:
Min partition size: 75
Result check: True
Time used: 0.001540s

Min partition size: 50
Result check: True
Time used: 0.001203s

Min partition size: 40
Result check: True
Time used: 0.001093s

Min partition size: 30
Result check: True
Time used: 0.000990s

Min partition size: 25
Result check: True
Time used: 0.000928s

Min partition size: 20
Result check: True
Time used: 0.000895s

Min partition size: 10
Result check: True
Time used: 0.000863s

Min partition size: 5
Result check: True
Time used: 0.000861s
```

- 性能分析

与8中实现的原生快速排序相比，在同样的测试数据集下，将分区大小设为**25**以下可以获得一定的性能提升，此时快排递归调用的开销大于直接采用插入排序处理

## 五. 实验总结
- 能够解释并实现顺序搜索和二分搜索
- 能够解释并实现冒泡排序、选择排序、插入排序、希尔排序、归并排序和快速排序——理解原理并推导出其时间复杂度
- 理解散列和映射——哈希函数的设计、散列的存储方式（冲突处理：再散列、平方探测）
