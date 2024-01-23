# 实验六

## 一. 背景知识
图的数据结构及其用法

## 二. 目的要求
1. 使用多种内部表示实现图的抽象数据类型
2. 学习如何用图解决实际问题

## 三. 实验内容
1. 借助邻接表实现图算法
2. 实现宽度优先搜索算法和深度优先搜索算法
3. 实现Dijkstra算法
4. 实现Prim算法

### 进阶
1. 修改深度优先搜索函数，以进行拓扑排序
2. 使用宽度优先搜索实现一个算法，用以计算从每一个顶点到其余所有顶点的最短路径

## 四. 实验结果
1. 借助邻接表实现图算法
- 测试代码
```python
from adjMapGraph import Vertex
from adjMapGraph import Graph

g1 = Graph()

for i in range(6):
    g1.addVertex(i)

print(g1.vertices)

g1.addEdge(0, 1, 5)
g1.addEdge(0, 5, 2)
g1.addEdge(1, 2, 4)
g1.addEdge(2, 3, 9)
g1.addEdge(3, 4, 7)
g1.addEdge(3, 5, 3)
g1.addEdge(4, 0, 1)
g1.addEdge(5, 4, 8)
g1.addEdge(5, 2, 1)

for v in g1:
    for w in v.getConnections():
        print("(%s, %s)" % (v.getId(), w.getId()))

print()
```

- 测试结果
```
{0: <adjMapGraph.Vertex object at 0x102a1b490>, 1: <adjMapGraph.Vertex object at 0x102a1a410>, 2: <adjMapGraph.Vertex object at 0x102a1a3e0>, 3: <adjMapGraph.Vertex object at 0x102a1a3b0>, 4: <adjMapGraph.Vertex object at 0x102a1a380>, 5: <adjMapGraph.Vertex object at 0x102a1a350>}
(0, 1)
(0, 5)
(1, 2)
(2, 3)
(3, 4)
(3, 5)
(4, 0)
(5, 4)
(5, 2)
```

2. 实现宽度优先搜索算法和深度优先搜索算法
- 测试代码
```python
from adjMapGraph import Vertex
from adjMapGraph import Graph
from adjMapGraph import returnPath
from search import DFSGraph, bfs


# 宽度优先搜索算法
my_vertices = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I']

g2 = Graph()

for i in range(len(my_vertices)):
    g2.addVertex(my_vertices[i])

g2.addEdge('A', 'B')
g2.addEdge('A', 'C')
g2.addEdge('A', 'D')
g2.addEdge('C', 'D')
g2.addEdge('C', 'G')
g2.addEdge('D', 'G')
g2.addEdge('D', 'H')
g2.addEdge('B', 'E')
g2.addEdge('B', 'F')
g2.addEdge('E', 'I')

print("Set 'A' as the initial vertex:")
bfs(g2.vertices['A'])
print(returnPath(g2.vertices['F']))
print(returnPath(g2.vertices['H']))
print(returnPath(g2.vertices['G']))
print(returnPath(g2.vertices['I']))
print()

print("Set 'B' as the initial vertex:")
bfs(g2.vertices['B'])
print(returnPath(g2.vertices['F']))
print(returnPath(g2.vertices['H']))
print(returnPath(g2.vertices['G']))
print(returnPath(g2.vertices['I']))
print()

print()

# 深度优先搜索算法
my_vertices = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I']

g3 = DFSGraph()

for i in range(len(my_vertices)):
    g3.addVertex(my_vertices[i])

g3.addEdge('A', 'B')
g3.addEdge('A', 'C')
g3.addEdge('A', 'D')
g3.addEdge('C', 'D')
g3.addEdge('C', 'G')
g3.addEdge('D', 'G')
g3.addEdge('D', 'H')
g3.addEdge('B', 'E')
g3.addEdge('B', 'F')
g3.addEdge('E', 'I')

g3.dfs(g3.vertices['A'])
print("Set 'A' as the initial vertex:")
print(returnPath(g3.vertices['F']))
print(returnPath(g3.vertices['H']))
print(returnPath(g3.vertices['G']))
print(returnPath(g3.vertices['I']))
print()

g3.dfs(g3.vertices['B'])
print("Set 'B' as the initial vertex:")
print(returnPath(g3.vertices['F']))
print(returnPath(g3.vertices['H']))
print(returnPath(g3.vertices['G']))
print(returnPath(g3.vertices['I']))
print()

print()
```

- 测试结果
```
Set 'A' as the initial vertex:
A -> B -> F
A -> D -> H
A -> C -> G
A -> B -> E -> I

Set 'B' as the initial vertex:
B -> F
A -> D -> H
A -> C -> G
B -> E -> I


Set 'A' as the initial vertex:
A -> B -> F
A -> C -> D -> H
A -> C -> D -> G
A -> B -> E -> I

Set 'B' as the initial vertex:
B -> F
H
G
B -> E -> I
```

3. 实现Dijkstra算法
- 测试代码
```python
from adjMapGraph import Vertex
from adjMapGraph import Graph
from adjMapGraph import returnPath
from dijkstraAlgorithm import dijkstra

g4: Graph = Graph()

g4.addVertex("START")
g4.addVertex("A")
g4.addVertex("C")
g4.addVertex("B")
g4.addVertex("D")
g4.addVertex("END")

g4.addEdge("START", "A", 0)
g4.addEdge("START", "C", 2)
g4.addEdge("A", "B", 18)
g4.addEdge("A", "D", 15)
g4.addEdge("C", "B", 3)
g4.addEdge("C", "D", 10)
g4.addEdge("B", "END", 150)
g4.addEdge("D", "END", 15)
dijkstra(g4, g4.vertices["START"])

print(returnPath(g4.vertices["END"]))

print()
```

- 测试结果
```
START -> C -> D -> END
```

4. 实现Prim算法
- 测试代码
```python
from adjMapGraph import Vertex
from adjMapGraph import Graph
from adjMapGraph import returnPath
from primAlgorithm import prim

g5: Graph = Graph()

g5.addVertex("START")
g5.addVertex("A")
g5.addVertex("C")
g5.addVertex("B")
g5.addVertex("D")
g5.addVertex("END")

g5.addEdge("START", "A", 0)
g5.addEdge("START", "C", 2)
g5.addEdge("A", "B", 18)
g5.addEdge("A", "D", 15)
g5.addEdge("C", "B", 3)
g5.addEdge("C", "D", 10)
g5.addEdge("B", "END", 150)
g5.addEdge("D", "END", 15)
prim(g5, g5.vertices["START"])

print(returnPath(g5.vertices["END"]))

print()
```

- 测试结果
```
START -> C -> D -> END
```

5. 修改深度优先搜索函数，以进行拓扑排序
- 测试代码
```python
from search import DFSGraph
from topoSort import topologicalSort

my_vertices = ['3/4CupOfMilk', '1TblOil', '1Egg', 'HeatSyrup', '1CupMix',
               'HeatGriddle', 'Pour1/4Cup', 'TurnWhenBubbly', 'Eat']

g6 = DFSGraph()

for vertex in my_vertices:
    g6.addVertex(vertex)

g6.addEdge('3/4CupOfMilk', '1CupMix')
g6.addEdge('1Egg', '1CupMix')
g6.addEdge('1TblOil', '1CupMix')
g6.addEdge('1CupMix', 'HeatSyrup')
g6.addEdge('HeatSyrup', 'Eat')
g6.addEdge('1CupMix', 'Pour1/4Cup')
g6.addEdge('HeatGriddle', 'Pour1/4Cup')
g6.addEdge('Pour1/4Cup', 'TurnWhenBubbly')
g6.addEdge('TurnWhenBubbly', 'Eat')

print(topologicalSort(g6))

print()
```

- 测试结果
```
['HeatGriddle', '1Egg', '1TblOil', '3/4CupOfMilk', '1CupMix', 'Pour1/4Cup', 'TurnWhenBubbly', 'HeatSyrup', 'Eat']
```

6. 使用宽度优先搜索实现一个算法，用以计算从每一个顶点到其余所有顶点的最短路径
- 测试代码
```python
from adjMapGraph import Vertex
from adjMapGraph import Graph
from adjMapGraph import returnPath
from bfsShortestPath import findShortestPath

my_vertices = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I']

g7 = Graph()

for i in range(len(my_vertices)):
    g7.addVertex(my_vertices[i])

g7.addEdge('A', 'B')
g7.addEdge('A', 'C')
g7.addEdge('A', 'D')
g7.addEdge('C', 'D')
g7.addEdge('C', 'G')
g7.addEdge('D', 'G')
g7.addEdge('D', 'H')
g7.addEdge('B', 'E')
g7.addEdge('B', 'F')
g7.addEdge('E', 'I')

findShortestPath(g7)
```

- 测试结果
```
Set A as the initial vertex:
From A cannot reach to A
The shortest path from A to B is A -> B
The shortest path from A to C is A -> C
The shortest path from A to D is A -> D
The shortest path from A to E is A -> B -> E
The shortest path from A to F is A -> B -> F
The shortest path from A to G is A -> C -> G
The shortest path from A to H is A -> D -> H
The shortest path from A to I is A -> B -> E -> I

Set B as the initial vertex:
From B cannot reach to A
From B cannot reach to B
From B cannot reach to C
From B cannot reach to D
The shortest path from B to E is B -> E
The shortest path from B to F is B -> F
From B cannot reach to G
From B cannot reach to H
The shortest path from B to I is B -> E -> I

Set C as the initial vertex:
From C cannot reach to A
From C cannot reach to B
From C cannot reach to C
The shortest path from C to D is C -> D
From C cannot reach to E
From C cannot reach to F
The shortest path from C to G is C -> G
The shortest path from C to H is C -> D -> H
From C cannot reach to I

Set D as the initial vertex:
From D cannot reach to A
From D cannot reach to B
From D cannot reach to C
From D cannot reach to D
From D cannot reach to E
From D cannot reach to F
The shortest path from D to G is D -> G
The shortest path from D to H is D -> H
From D cannot reach to I

Set E as the initial vertex:
From E cannot reach to A
From E cannot reach to B
From E cannot reach to C
From E cannot reach to D
From E cannot reach to E
From E cannot reach to F
From E cannot reach to G
From E cannot reach to H
The shortest path from E to I is E -> I

Set F as the initial vertex:
From F cannot reach to A
From F cannot reach to B
From F cannot reach to C
From F cannot reach to D
From F cannot reach to E
From F cannot reach to F
From F cannot reach to G
From F cannot reach to H
From F cannot reach to I

Set G as the initial vertex:
From G cannot reach to A
From G cannot reach to B
From G cannot reach to C
From G cannot reach to D
From G cannot reach to E
From G cannot reach to F
From G cannot reach to G
From G cannot reach to H
From G cannot reach to I

Set H as the initial vertex:
From H cannot reach to A
From H cannot reach to B
From H cannot reach to C
From H cannot reach to D
From H cannot reach to E
From H cannot reach to F
From H cannot reach to G
From H cannot reach to H
From H cannot reach to I

Set I as the initial vertex:
From I cannot reach to A
From I cannot reach to B
From I cannot reach to C
From I cannot reach to D
From I cannot reach to E
From I cannot reach to F
From I cannot reach to G
From I cannot reach to H
From I cannot reach to I
```

## 五. 实验总结
- 使用多种内部表示实现图的抽象数据类型——邻接表、邻接矩阵等
- 学习了如何用图解决实际问题——BFS、DFS以及各种最短路算法的使用