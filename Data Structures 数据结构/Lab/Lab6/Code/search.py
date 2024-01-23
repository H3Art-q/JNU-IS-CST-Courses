from adjMapGraph import Graph, Vertex
from queue import Queue


class DFSGraph(Graph):
    def __init__(self):
        super().__init__()
        self.time = 0
        self.explored = []

    def dfs(self, start: Vertex):
        for aVertex in self:
            aVertex.setColor('white')
            aVertex.setPred(None)
        self.dfsvisit(start)

    def dfsvisit(self, startVertex):
        startVertex.setColor('gray')
        self.time += 1
        startVertex.setDiscovery(self.time)
        for nextVertex in startVertex.getConnections():
            if nextVertex.getColor() == 'white':
                nextVertex.setPred(startVertex)
                self.dfsvisit(nextVertex)
        startVertex.setColor('black')
        self.time += 1
        startVertex.setFinish(self.time)
        self.explored.append(startVertex.getId())

def bfs(start: Vertex):
    start.setDistance(0)
    start.setPred(None)
    vertQueue = Queue()
    vertQueue.enqueue(start)
    while (vertQueue.size() > 0):
        currentVert = vertQueue.dequeue()
        for nbr in currentVert.getConnections():
            if (nbr.getColor() == 'white'):
                nbr.setColor('gray')
                nbr.setDistance(currentVert.getDistance() + 1)
                nbr.setPred(currentVert)
                vertQueue.enqueue(nbr)
        currentVert.setColor('black')
