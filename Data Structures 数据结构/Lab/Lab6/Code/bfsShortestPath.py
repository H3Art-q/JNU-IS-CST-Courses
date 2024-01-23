from adjMapGraph import Graph
from adjMapGraph import Vertex
from adjMapGraph import returnPath
from search import bfs

def cleanPredVertex(graph):
    for name in graph.vertices:
        v = graph.getVertex(name)
        v.setColor('white')
        v.setPred(None)

def findShortestPath(graph):
    for name in graph.vertices:
        v = graph.getVertex(name)
        cleanPredVertex(graph)
        bfs(v)
        print("Set", v.getId(), "as the initial vertex:")
        for dname in [dst for dst in graph.vertices if graph.vertices != v]:
            dstv = graph.getVertex(dname)
            if dstv.getPred() == None:
                print("From", v.getId(), "cannot reach to", dstv.getId())
            else:
                print("The shortest path from", v.getId(), "to", dstv.getId(), "is", returnPath(dstv))
        print()