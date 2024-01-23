from turtle import *

PART_OF_PATH = 'O'          # 部分路径
TRIED = '.'                 # 已尝试的路径
OBSTACLE = '+'              # 障碍物
DEAD_END = '-'              # 死路


class Maze:

    def __init__(self, mazeFileName, myTurtle):
        # 初始化迷宫行、列以及表示的行列表
        rowsInMaze = 0
        columnsInMaze = 0
        self.mazelist = []

        # 每行建一个list读取mazefile
        # 再将其append到行列表里
        mazeFile = open(mazeFileName, 'r')
        rowsInMaze = 0
        for line in mazeFile:
            rowList = []
            col = 0
            for ch in line[:-1]:
                rowList.append(ch)
                if ch == 'S':
                    self.startRow = rowsInMaze
                    self.startCol = col
                col = col + 1
            rowsInMaze = rowsInMaze + 1
            self.mazelist.append(rowList)
            columnsInMaze = len(rowList)

        # 设置迷宫的总行数和列数
        self.rowsInMaze = rowsInMaze
        self.columnsInMaze = columnsInMaze

        # 设置迷宫左上角初始的x、y坐标
        self.xTranslate = -columnsInMaze/2
        self.yTranslate = rowsInMaze/2
        self.t = myTurtle
        
        # 设置画布
        setup(width=600, height=600)

        # 设置世界坐标系，原点在迷宫正中心
        # 参数依次为画布左下角x轴坐标、左下角y轴坐标、右上角x轴坐标、右上角y轴坐标
        setworldcoordinates(-(columnsInMaze-1)/2-.5,
                            -(rowsInMaze-1) / 2-.5,
                            (columnsInMaze-1)/2+.5,
                            (rowsInMaze-1)/2+.5)

    def drawMaze(self):
        self.t.speed(20)
        for y in range(self.rowsInMaze):
            for x in range(self.columnsInMaze):
                if self.mazelist[y][x] == OBSTACLE:
                    self.drawCenteredBox(
                        x+self.xTranslate, -y+self.yTranslate, 'tan')
        self.t.color('black', 'blue')

    def drawCenteredBox(self, x, y, color):
        tracer(0)
        self.t.up()
        self.t.goto(x-.5, y-.5)
        self.t.color('black', color)
        self.t.setheading(90)
        self.t.down()
        self.t.begin_fill()
        for i in range(4):
            self.t.forward(1)
            self.t.right(90)
        self.t.end_fill()
        update()
        tracer(1)

    def moveTurtle(self, x, y):
        self.t.up()
        self.t.setheading(self.t.towards(x+self.xTranslate,
                                         -y+self.yTranslate))
        self.t.goto(x+self.xTranslate, -y+self.yTranslate)

    def dropBreadcrumb(self, color):
        self.t.dot(color)

    def updatePosition(self, row, col, val=None):
        if val:
            self.mazelist[row][col] = val
            self.moveTurtle(col, row)

        if val == PART_OF_PATH:
            color = 'green'
        elif val == OBSTACLE:
            color = 'red'
        elif val == TRIED:
            color = 'black'
        elif val == DEAD_END:
            color = 'red'
        else:
            color = None

        if color:
            self.dropBreadcrumb(color)

    def isExit(self, row, col):
        return (row == 0 or row == self.rowsInMaze-1 or col == 0 or col == self.columnsInMaze-1)

    def __getitem__(self, idx):
        return self.mazelist[idx]


def searchFrom(maze, startRow, startColumn):
    maze.updatePosition(startRow, startColumn)
    # 检查基本情况

    # 1. 遇到墙
    if maze[startRow][startColumn] == OBSTACLE:
        return False
    # 2. 遇到已经走过的格子
    if maze[startRow][startColumn] == TRIED:
        return False
    # 3. 找到出口
    if maze.isExit(startRow, startColumn):
        maze.updatePosition(startRow, startColumn, PART_OF_PATH)
        return True

    maze.updatePosition(startRow, startColumn, TRIED)

    # 否则，依次尝试向 4 个方向移动
    found = searchFrom(maze, startRow-1, startColumn) or \
        searchFrom(maze, startRow+1, startColumn) or \
        searchFrom(maze, startRow, startColumn-1) or \
        searchFrom(maze, startRow, startColumn+1)

    if found:
        maze.updatePosition(startRow, startColumn, PART_OF_PATH)
    else:
        maze.updatePosition(startRow, startColumn, DEAD_END)
    return found
