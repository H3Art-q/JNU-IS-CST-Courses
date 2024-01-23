from LinearSearch import *
from BinarySearch import *
from BubbleSort import *
from SelectionSort import *
from InsertionSort import *
from ShellSort import *
from MergeSort import *
from QuickSort import *
from QuickSort_Modified import *
from pythonds import *
import time
import operator

# 测试数据准备

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



# 1. 实现无序列表和有序列表的顺序搜索并分析比较次数

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



# 2. 分别用递归和非递归的方法实现对有序列表的二分搜索并分析比较次数
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



# 3. 实现冒泡排序算法及改进后的短冒泡排序算法
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



# 4. 实现选择排序算法
print("Selection Sort:")
templist = list(i for i in unsortedData)
start = time.time()
selectionSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))



# 5. 实现插入排序算法
print("Insertion Sort:")
templist = list(i for i in unsortedData)
start = time.time()
insertionSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))



# 6. 实现希尔排序算法
print("Shell Sort:")
templist = list(i for i in unsortedData)
start = time.time()
shellSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))



# 7. 实现归并排序算法
print("Merge Sort:")
templist = list(i for i in unsortedData)
start = time.time()
mergeSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))



# 8. 实现快速排序算法
print("Quick Sort:")
templist = list(i for i in unsortedData)
start = time.time()
quickSort(templist)
end = time.time()
# 结果比对
print("Result check:", operator.eq(templist, sortedData))
print("Time used: %fs\n" % (end - start))



# 9. 实现映射（map）抽象数据类型及相关方法
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



# 10. 重新实现快速排序算法，并给一个随机整数列表排序。采用不同的分区限制进行性能分析
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