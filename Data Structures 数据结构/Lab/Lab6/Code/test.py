from adjMapGraph import Vertex
from adjMapGraph import Graph
from adjMapGraph import returnPath
from search import DFSGraph, bfs
from dijkstraAlgorithm import dijkstra
from primAlgorithm import prim
from topoSort import topologicalSort
from bfsShortestPath import findShortestPath

# 1. 借助邻接表实现图算法
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


# 2. 实现宽度优先搜索算法和深度优先搜索算法

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

# 3. 实现Dijkstra算法
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

# 4. 实现Prim算法
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

# 5. 修改深度优先搜索函数，以进行拓扑排序
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

# 6. 使用宽度优先搜索实现一个算法，用以计算从每一个顶点到其余所有顶点的最短路径
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