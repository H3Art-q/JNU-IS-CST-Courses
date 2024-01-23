from listBinTree import *
from refBinTree import *
from expressionParsing import *
from treeTraversal import *
from binaryHeap import *
from binarySearchTree import *
from avlTree import *
from parsingDerivative import *

# 1. 用嵌套列表实现树
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

# 2. 用节点和引用实现树
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

# 3. 编写创建解析树、计算解析树的Python函数
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

# 4. 实现前序遍历、中序遍历和后序遍历算法
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

# 5. 实现后序求值函数，修改中序遍历算法实现还原完全括号表达式
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

# 6. 实现二叉堆及相关方法
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

# 7. 实现二叉搜索树及相关方法
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

# 8. 实现平衡二叉树(AVL)及相关方法(包含delete方法)
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

# 9. 写一个函数，以数学表达式解析树为参数，计算各变量的导数
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