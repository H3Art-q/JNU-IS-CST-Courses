# 实验五

## 一. 背景知识
树的数据结构及其用法

## 二. 目的要求
1. 了解如何用树实现映射
2. 实现树及相关应用
3. 用堆实现优先级队列

## 三. 实验内容
1. 用嵌套列表实现树（插入子树、访问节点等）
2. 用节点和引用实现树（插入子树、访问节点等）
3. 编写创建解析树的Python函数
   - 编写计算二叉解析树的递归函数
4. 实现前序遍历、中序遍历和后序遍历算法
5. 实现后序求值函数，修改中序遍历算法实现还原完全括号表达式
6. 实现二叉堆及下列方法：
   - 新建空二叉堆BinaryHeap()
   - 往堆中加入新元素insert()
   - 返回最小元素，元素留在堆中finMin()
   - 返回最小元素，并将该元素从堆中删除delMin()
   - 判空操作isEmpty()
   - 返回堆中元素的个数size()
   - 根据一个列表创建堆buildHeap()
7. 实现二叉搜索树及相关方法
8. 实现平衡二叉树（AVL）及相关方法

### 进阶
1. 写一个函数，以数学表达式解析树为参数，计算各变量的导数
2. 实现AVL树的delete方法

## 四. 实验结果
1. 用嵌套列表实现树（插入子树、访问节点等）
- 测试代码
```python
from listBinTree import *

r = listBinaryTree(3)
print("Initalize r with root 3:", r)
insertLeft(r, 4)
print("Insert 4 to r's left child:", r)
insertLeft(r, 5)
print("Insert 5 to r's left child:", r)
insertRight(r, 6)
print("Insert 6 to r's right child:", r)
insertRight(r, 7)
print("Insert 7 to r's right child:", r)

l = getLeftChild(r)
print("The left branch of r is:", l)
setRootVal(l, 9)
print("Change the left child value of r to 9:", r)
insertLeft(l, 11)
print("Insert 11 to r's left child:", r)

print("The right child of the right child of r is:", getRightChild(getRightChild(r)))
print()
```

- 测试结果
```
Initalize r with root 3: [3, [], []]
Insert 4 to r's left child: [3, [4, [], []], []]
Insert 5 to r's left child: [3, [5, [4, [], []], []], []]
Insert 6 to r's right child: [3, [5, [4, [], []], []], [6, [], []]]
Insert 7 to r's right child: [3, [5, [4, [], []], []], [7, [], [6, [], []]]]
The left branch of r is: [5, [4, [], []], []]
Change the left child value of r to 9: [3, [9, [4, [], []], []], [7, [], [6, [], []]]]
Insert 11 to r's left child: [3, [9, [11, [4, [], []], []], []], [7, [], [6, [], []]]]
The right child of the right child of r is: [6, [], []]
```

2. 用节点和引用实现树（插入子树、访问节点等）
- 测试代码
```python
from refBinTree import *

r = BinaryTree('a')

print("Root of r:", r.getRootVal())
print("Left child of r:", r.getLeftChild())

print("Insert 'b' to r's left child")
r.insertLeft('b')

print("The address of left child of r:", r.getLeftChild())
print("The value of left child of r:", r.getLeftChild().getRootVal())

print("Insert 'c' to r's right child")
r.insertRight('c')

print("The address of right child of r:", r.getRightChild())
print("The value of right child of r:", r.getRightChild().getRootVal())

print("Change the value of r's right child to 'hello'")
r.getRightChild().setRootVal('hello')
print("The value of right child of r:", r.getRightChild().getRootVal())

print()
del r
```

- 测试结果
```
Root of r: a
Left child of r: None
Insert 'b' to r's left child
The address of left child of r: <refBinTree.BinaryTree object at 0x1053786a0>
The value of left child of r: b
Insert 'c' to r's right child
The address of right child of r: <refBinTree.BinaryTree object at 0x1053780a0>
The value of right child of r: c
Change the value of r's right child to 'hello'
The value of right child of r: hello
```

3. 编写创建解析树的Python函数
   - 编写计算二叉解析树的递归函数
- 测试代码
```python
from expressionParsing import *

test1 = "( ( 7 + 3 ) * ( 5 - 2 ) )"
test2 = "( 2 * ( 3 + 4 ) )"
test3 = "( ( 3 + 5 ) / 3 )"

tree1 = buildParseTree(test1)
tree2 = buildParseTree(test2)
tree3 = buildParseTree(test3)

print(test1, "=", evaluate(tree1))
print(test2, "=", evaluate(tree2))
print(test3, "=", evaluate(tree3))

print()
```

- 测试结果
```
( ( 7 + 3 ) * ( 5 - 2 ) ) = 30
( 2 * ( 3 + 4 ) ) = 14
( ( 3 + 5 ) / 3 ) = 2.6666666666666665
```

4. 实现前序遍历、中序遍历和后序遍历算法
- 测试代码
```python
from refBinTree import *
from treeTraversal import *

t = BinaryTree('a')
t.insertLeft('b')
t.insertRight('c')
t.insertLeft('d')
t.insertRight('e')
t.insertLeft('f')
t.insertRight('g')

print("pre-order traversal:")
preOrder(t)
print()
print("in-order traversal:")
inOrder(t)
print()
print("post-order traversal:")
postOrder(t)
print()

print()
del t
```

- 测试结果
```
pre-order traversal:
a f d b g e c 
in-order traversal:
b d f a g e c 
post-order traversal:
b d f c e g a 
```

5. 实现后序求值函数，修改中序遍历算法实现还原完全括号表达式
- 测试代码
```python
from expressionParsing import *

test1 = "( ( 7 + 3 ) * ( 5 - 2 ) )"
test2 = "( 2 * ( 3 + 4 ) )"
test3 = "( ( 3 + 5 ) / 3 )"

tree1 = buildParseTree(test1)
tree2 = buildParseTree(test2)
tree3 = buildParseTree(test3)

print(printExpression(tree1), "=", postOrderEvaluate(tree1))
print(printExpression(tree2), "=", postOrderEvaluate(tree2))
print(printExpression(tree3), "=", postOrderEvaluate(tree3))

print()
```

- 测试结果
```
(((7)+(3))*((5)-(2))) = 30
((2)*((3)+(4))) = 14
(((3)+(5))/(3)) = 2.6666666666666665
```

6. 实现二叉堆及其方法：
- 测试代码
```python
from binaryHeap import *

h = BinaryHeap()

print("Is h empty:", h.isEmpty())

h.insert(114514)
h.insert(1919810)
h.insert(2023)
h.insert(31415926)
h.insert(65536)
h.insert(255)
h.insert(2021102716)

print("The min element is:", h.finMin())
print("Size of h:", h.size())
print("Delete the min element:", h.delMin())
print("Size of h:", h.size())
print("Is h empty:", h.isEmpty())

mylist = [9, 6, 5, 2, 3]
print("Rebuild h by list[9, 6, 5, 2, 3]")
h.buildHeap(mylist)
print("The min element is:", h.finMin())
print("Size of h:", h.size())

print()
del h
```

- 测试结果
```
Is h empty: True
The min element is: 255
Size of h: 7
Delete the min element: 255
Size of h: 6
Is h empty: False
Rebuild h by list[9, 6, 5, 2, 3]
The min element is: 2
Size of h: 5
```

7. 实现二叉搜索树及相关方法
- 测试代码
```python
from binarySearchTree import *

s = BinarySearchTree()
s.put(10, "Hello")
s.put(20, "Data")
s.put(30, 114.514)
s.put(40, True)
s[50] = "Structure"
s[60] = 1919810
s[70] = False

print("Len of h:", s.len())
print("s[40] =", s.get(40))
print("s[39] =", s.get(39))
print("s[50] =", s[50])
print("s[51] =", s[51])
print("delete s[50]")
del s[50]
print("Len of h:", s.len())
print("Is key'50' in s:", 50 in s)
print("Is key'20' in s:", 20 in s)

for i in s:
    print(i, ":", s[i])

print("pre-order traversal:")
s.preOrderTraversal(s.root)
print()
print("in-order traversal:")
s.inOrderTraversal(s.root)
print()
print("post-order traversal:")
s.postOrderTraversal(s.root)
print()

print()
del s
```

- 测试结果
```
Len of h: 7
s[40] = True
s[39] = None
s[50] = Structure
s[51] = None
delete s[50]
Len of h: 6
Is key'50' in s: False
Is key'20' in s: True
10 : Hello
20 : Data
30 : 114.514
40 : True
60 : 1919810
70 : False
pre-order traversal:
10 20 30 40 60 70 
in-order traversal:
10 20 30 40 60 70 
post-order traversal:
70 60 40 30 20 10 
```

8. 实现平衡二叉树（AVL）及相关方法(包含delete方法)
- 测试代码
```python
from avlTree import *

s = AVLTree()
s.put(10, "Hello")
s.put(20, "Data")
s.put(30, 114.514)
s.put(40, True)
s[50] = "Structure"
s[60] = 1919810
s[70] = False

print("Len of h:", s.len())
print("s[40] =", s.get(40))
print("s[39] =", s.get(39))
print("s[50] =", s[50])
print("s[51] =", s[51])
print("delete s[50]")
del s[50]
print("Len of h:", s.len())
print("Is key'50' in s:", 50 in s)
print("Is key'20' in s:", 20 in s)

for i in s:
    print(i, ":", s[i])

print("pre-order traversal:")
s.preOrderTraversal(s.root)
print()
print("in-order traversal:")
s.inOrderTraversal(s.root)
print()
print("post-order traversal:")
s.postOrderTraversal(s.root)
print()

print()
del s
```

- 测试结果
```
Len of h: 7
s[40] = True
s[39] = None
s[50] = Structure
s[51] = None
delete s[50]
Len of h: 6
Is key'50' in s: False
Is key'20' in s: True
10 : Hello
20 : Data
30 : 114.514
40 : True
60 : 1919810
70 : False
pre-order traversal:
40 20 10 30 60 70 
in-order traversal:
10 20 30 40 60 70 
post-order traversal:
10 30 20 70 60 40
```

9.  写一个函数，以数学表达式解析树为参数，计算各变量的导数
- 测试代码
```python
from parsingDerivative import *

expression = "(2*(3+4*x))"
print("Expression:", expression)
variable = "x"

expression = postfix(expression)
ptree = postbuildParseTree(expression)
difftree = diffTree(ptree, variable)

print("Derivative expression:", infixTree(difftree))

counts = 0
simp_diff_pt = simplifyTree(difftree)
while counts < 50 and not identicalTrees(simp_diff_pt, simplifyTree(simp_diff_pt)):
    simp_diff_pt = simplifyTree(simp_diff_pt)
    print("Simplifed expression:", infixTree(simp_diff_pt))
    counts += 1
print()


expression = "1/(1+x*x)"
print("Expression:", expression)
variable = "x"

expression = postfix(expression)
ptree = postbuildParseTree(expression)
difftree = diffTree(ptree, variable)

print("Derivative expression:", infixTree(difftree))

counts = 0
simp_diff_pt = simplifyTree(difftree)
while counts < 50 and not identicalTrees(simp_diff_pt, simplifyTree(simp_diff_pt)):
    simp_diff_pt = simplifyTree(simp_diff_pt)
    print("Simplifed expression:", infixTree(simp_diff_pt))
    counts += 1
print()
```

- 测试结果
```
Expression: (2*(3+4*x))
Derivative expression: ((0*(3+(4*x)))+(2*(0+((0*x)+(4*1)))))
Simplifed expression: (2*4)

Expression: 1/(1+x*x)
Derivative expression: (((0*(1+(x*x)))-(1*(0+((1*x)+(x*1)))))/((1+(x*x))^2))
Simplifed expression: ((-(2*x))/((1+(x^2))^2))
```

## 五. 实验总结
- 了解如何用树实现映射——二叉搜索树的实现和利用AVL树进行优化
- 实现树及相关应用——表达式解析树等
- 用堆实现优先级队列——二叉堆的增删改查实现最大/最小堆