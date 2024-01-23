from pythonds import *
from pythonds_unorderedlist import *
from orderedlist import *
from unorderedlist import *
from passpotato import *
from passpotato_modified import *
from printer import *
from palchecker import *

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

# 2. 用队列模拟“传土豆”
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 7))
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 6))
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 5))
print(hotPotato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 4))


print()

# 3. 用队列模拟“打印任务”
for i in range(10):
    simulation(3600, 5)

print()

for i in range(10):
    simulation(3600, 10)

print()

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

# 5. 用双端队列实现一个“回文检测器”
print(palchecker("hello"))
print(palchecker("otto"))
print(palchecker("purpose"))
print(palchecker("datastructurerutcurtsatad"))
print(palchecker("114514"))

print()

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

# 8. 修改传土豆模拟程序，允许随机计数
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))
print(hotPotato_modified(["Bill", "David", "Susan", "Jane", "Kent", "Brad"]))

print()

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

# 10. 使用链表实现栈、队列、双端队列

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