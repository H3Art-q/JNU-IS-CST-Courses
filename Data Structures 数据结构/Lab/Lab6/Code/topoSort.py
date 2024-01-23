from search import DFSGraph


def topologicalSort(graph):
    for i in graph.vertices:
        if graph.getVertex(i).indeg == 0:
            graph.dfsvisit(graph.getVertex(i))

    result = graph.explored
    result.reverse()
    return result
