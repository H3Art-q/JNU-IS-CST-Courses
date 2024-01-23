# 实验二

## 一. 背景知识
队列及列表的实现和相关算法


## 二. 目的要求
1. 理解队列、双端队列、列表等抽象数据类型
2. 使用队列进行基本的时序模拟
3. 理解队列、双端队列和列表适用于解决何种问题


## 三. 实验内容
1. 用python实现队列，并包含以下方法：判空isEmpty()、入队enqueue()、出队dequeue()、查看队列大小size()
2. 用队列模拟“传土豆”
3. 用队列模拟“打印任务”，流程如下：
   1. 创建一个打印任务队列。每一个任务到来时都会有一个时间戳。一开始，队列是空的
   2. 针对每一秒（currentSecond），执行以下操作
      - 是否有新创建的打印任务？如果是，以currentSecond作为其 时间戳并将该任务加入到队列中
      - 如果打印机空闲，并且有正在等待执行的任务，执行以下操作：
         1. 从队列中取出第一个任务并提交给打印机
         2. 用currentSecond减去该任务的时间戳，以此计算其等待时间
         3. 将该任务的等待时间存入一个列表，以备后用
         4. 根据该任务的页数，计算执行时间
      - 打印机进行一秒的打印，同时从该任务的执行时间中减去一秒
      - 如果打印任务执行完毕，或者说任务需要的时间减为0，则说明打印机回到空闲状态
   3. 当模拟完成之后，根据等待时间列表中的值计算平均等待时间
4. 用python实现双端队列，并包含以下方法：判空isEmpty()、元素前插addFront()、元素后插addRear()、删除前端元素removeFront()、删除后端元素removeRear()、双端队列大小size()
5. 用双端队列实现一个“回文检测器”
6. 实现无序列表（链表）及其方法
7. 实现有序列表及其方法

### 进阶：
1. 修改传土豆模拟程序，允许随机计数，从而使每一轮的结果都不可预测；
2. 实现无序列表抽象数据类型剩余的方法：append、index、pop和insert
3. 使用链表实现栈、队列、双端队列


## 四. 实验结果

*本人在大多数需要遍历得到结果的数据结构中加入了travel（遍历）方法*

1. 用python实现队列
- 测试代码：
```python
# 1. 用python实现队列
q = Queue()
print(q.isEmpty())
q.enqueue(4)
q.travel()
q.enqueue('dog')
q.travel()
q.enqueue(True)
q.travel()
print(q.size())
print(q.isEmpty())
q.enqueue(8.4)
q.travel()
print(q.dequeue())
q.travel()
print(q.dequeue())
q.travel()
print(q.size())

print()
```
- 测试输出
```
True
[4]
['dog', 4]
[True, 'dog', 4]
3
False
[8.4, True, 'dog', 4]
4
[8.4, True, 'dog']
dog
[8.4, True]
2
```

2. 用队列模拟“传土豆”
- 测试代码
```python
# 2. 用队列模拟“传土豆”
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 7))
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 6))
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 5))
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 4))

print()
```
- 测试输出
```
Susan
Kent
Jane
Bill
```

3. 用队列模拟“打印任务”
- 测试代码
```python
# 3. 用队列模拟“打印任务”
for i in range(10):
    simulation(3600, 5)

print()

for i in range(10):
    simulation(3600, 10)

print()
```
- 测试输出
```
Average Wait 456.74 secs   2 tasks remaining.
Average Wait  54.59 secs   4 tasks remaining.
Average Wait 230.25 secs   5 tasks remaining.
Average Wait  97.43 secs   0 tasks remaining.
Average Wait 235.70 secs   5 tasks remaining.
Average Wait 152.10 secs   1 tasks remaining.
Average Wait  90.92 secs   0 tasks remaining.
Average Wait 113.28 secs   0 tasks remaining.
Average Wait  15.40 secs   0 tasks remaining.
Average Wait 358.73 secs   0 tasks remaining.

Average Wait  11.50 secs   0 tasks remaining.
Average Wait  23.50 secs   0 tasks remaining.
Average Wait  16.21 secs   1 tasks remaining.
Average Wait  27.53 secs   0 tasks remaining.
Average Wait  19.71 secs   0 tasks remaining.
Average Wait   3.41 secs   0 tasks remaining.
Average Wait  15.90 secs   0 tasks remaining.
Average Wait  15.41 secs   0 tasks remaining.
Average Wait   4.71 secs   0 tasks remaining.
Average Wait  43.05 secs   1 tasks remaining.
```

4.  用python实现双端队列
- 测试代码
```python
# 4. 用python实现双端队列
d = Deque()
print(d.isEmpty())
d.addRear(4)
d.travel()
d.addRear('dog')
d.travel()
d.addFront('cat')
d.travel()
d.addFront(True)
d.travel()
print(d.size())
print(d.isEmpty())
d.addRear(8.4)
d.travel()
print(d.removeRear())
d.travel()
print(d.removeRear())
d.travel()

print()
```
- 测试输出
```
True
[4]
['dog', 4]
['dog', 4, 'cat']
['dog', 4, 'cat', True]
4
False
[8.4, 'dog', 4, 'cat', True]
8.4
['dog', 4, 'cat', True]
dog
[4, 'cat', True]
```

5. 用双端队列实现一个“回文检测器”
- 测试代码
```python
# 5. 用双端队列实现一个“回文检测器”
print(palchecker("hello"))
print(palchecker("otto"))
print(palchecker("purpose"))
print(palchecker("datastructurerutcurtsatad"))
print(palchecker("114514"))
```
- 测试输出
```
False
True
False
True
False
```

6. 实现无序列表（链表）及其方法
- 测试代码
```python
# 6. 实现无序列表（链表）及其方法
unOlist = UnorderedList()
print(unOlist.isEmpty())
unOlist.add(31)
unOlist.travel()
unOlist.add('python')
unOlist.travel()
unOlist.add(17)
unOlist.travel()
unOlist.add(True)
unOlist.travel()
unOlist.add(26)
unOlist.travel()
unOlist.add(54)
unOlist.travel()
print(unOlist.isEmpty())
print(unOlist.length())
print(unOlist.search(17))
print(unOlist.search(18))
unOlist.remove(31)
unOlist.travel()
unOlist.remove(54)
unOlist.travel()

print()
```
- 测试输出
```
True
[31]
[python, 31]
[17, python, 31]
[True, 17, python, 31]
[26, True, 17, python, 31]
[54, 26, True, 17, python, 31]
False
6
True
False
[54, 26, True, 17, python]
[26, True, 17, python]
```

7. 实现有序列表及其方法
- 测试代码
```python
# 7. 实现有序列表及其方法
Olist = OrderedList()
print(Olist.isEmpty())
Olist.add(31)
Olist.travel()
Olist.add(93)
Olist.travel()
Olist.add(17)
Olist.travel()
Olist.add(77)
Olist.travel()
Olist.add(26)
Olist.travel()
Olist.add(54)
Olist.travel()
print(Olist.isEmpty())
print(Olist.length())
print(Olist.search(17))
print(Olist.search(18))
Olist.remove(93)
Olist.travel()
Olist.remove(31)
Olist.travel()

print()
```
- 测试输出
```
True
[31]
[31, 93]
[17, 31, 93]
[17, 31, 77, 93]
[17, 26, 31, 77, 93]
[17, 26, 31, 54, 77, 93]
False
6
True
False
[17, 26, 31, 54, 77]
[17, 26, 54, 77]
```

8. 修改传土豆模拟程序，允许随机计数
- 测试代码
```python
# 8. 修改传土豆模拟程序，允许随机计数
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
```
- 测试输出
```
# 此结果为随机结果
Bill
Brad
David
Kent
```

9. 实现无序列表抽象数据类型的append、index、pop和insert方法
- 测试代码
```python
# 9. 实现无序列表抽象数据类型的append、index、pop和insert方法
unOlist.append(12)
unOlist.travel()
unOlist.append(29)
unOlist.travel()
unOlist.index(17)
unOlist.index(31)
print(unOlist.pop(3))
unOlist.travel()
print(unOlist.pop(2))
unOlist.travel()
print(unOlist.pop())
unOlist.travel()
print(unOlist.pop())
unOlist.travel()
unOlist.insert(1, 10)
unOlist.travel()
unOlist.insert(2, 99)
unOlist.travel()

print()
```
- 测试输出
```
[26, True, 17, python, 12]
[26, True, 17, python, 12, 29]
Item isn' t in the list
python
[26, True, 17, 12, 29]
17
[26, True, 12, 29]
29
[26, True, 12]
12
[26, True]
[26, 10, True]
[26, 10, 99, True]
```

10. 使用链表实现栈、队列、双端队列
    1.  测试栈
    - 测试代码
    ```python
      # 测试栈：
      unOstack = Stack_unordlist()
      unOstack.isEmpty()
      unOstack.push(4)
      unOstack.travel()
      unOstack.push('dog')
      unOstack.travel()
      print(unOstack.peek())
      unOstack.push(True)
      unOstack.travel()
      print(unOstack.size())
      print(unOstack.isEmpty())
      unOstack.push(8.4)
      unOstack.travel()
      print(unOstack.pop())
      unOstack.travel()
      print(unOstack.pop())
      unOstack.travel()
      print(unOstack.size())

      print()
    ```
    - 测试输出
    ```
      [4]
      [dog, 4]
      dog
      [True, dog, 4]
      3
      False
      [8.4, True, dog, 4]
      8.4
      [True, dog, 4]
      True
      [dog, 4]
      2
    ```

    2.  测试队列
    - 测试代码
    ```python
      # 测试队列
      unOqueue = Queue_unordlist()
      print(unOqueue.isEmpty())
      unOqueue.enqueue(4)
      unOqueue.travel()
      unOqueue.enqueue('dog')
      unOqueue.travel()
      unOqueue.enqueue(True)
      unOqueue.travel()
      print(unOqueue.size())
      print(unOqueue.isEmpty())
      unOqueue.enqueue(8.4)
      unOqueue.travel()
      print(unOqueue.dequeue())
      unOqueue.travel()
      print(unOqueue.dequeue())
      unOqueue.travel()
      print(unOqueue.size())

      print()
    ```
    - 测试输出
    ```
      True
      [4]
      [4, dog]
      [4, dog, True]
      3
      False
      [4, dog, True, 8.4]
      4
      [dog, True, 8.4]
      dog
      [True, 8.4]
      2
    ```

    3.  测试双端队列
    - 测试代码
    ```python
      # 测试双端队列
      unOdeque = Deque_unordlist()
      print(unOdeque.isEmpty())
      unOdeque.addRear(4)
      unOdeque.travel()
      unOdeque.addRear('dog')
      unOdeque.travel()
      unOdeque.addFront('cat')
      unOdeque.travel()
      unOdeque.addFront(True)
      unOdeque.travel()
      print(unOdeque.size())
      print(unOdeque.isEmpty())
      unOdeque.addRear(8.4)
      unOdeque.travel()
      print(unOdeque.removeRear())
      unOdeque.travel()
      print(unOdeque.removeFront())
      unOdeque.travel()

      print()
    ```
    - 测试输出
    ```
      True
      [4]
      [4, dog]
      [cat, 4, dog]
      [True, cat, 4, dog]
      4
      False
      [True, cat, 4, dog, 8.4]
      8.4
      [True, cat, 4, dog]
      True
      [cat, 4, dog]
    ```


## 五. 实验总结
- 理解了队列、双端队列、列表等抽象数据类型
- 使用队列进行基本的时序模拟，学习如何将具体问题抽象为数学问题并利用计算机编程模拟
- 理解队列、双端队列和列表适用于解决何种问题