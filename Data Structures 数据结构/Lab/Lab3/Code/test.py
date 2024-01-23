from convertToString import *
from drawSpiral import *
from drawTree import *
from drawTriangle import *
from hanoiTower import *
from mazeExplore import *
from makeChange import *
from fillWater import *
from stealArtworks import *
import time

# 1. 利用递归将任意整数转换成以2~16为进制基数的字符串
print(toStr(255, 16))
print(toStr(127, 2))
print(toStr(33, 3))
print(toStr(128, 8))
print()


# 调用turtle模块，准备进行接下来的函数调用
myTurtle = Turtle()
myWin = myTurtle.getscreen()


# 2.1 用turtle模块递归地绘制螺旋线
drawSpiral(myTurtle, 100)
time.sleep(3)
myWin.reset()
myTurtle.home()


# 2.2 用turtle模块递归地绘制分形树
myTurtle.right(90)
myTurtle.penup()
myTurtle.forward(200)
myTurtle.pendown()
myTurtle.right(180)
tree(myTurtle, 100)
time.sleep(3)
myWin.reset()
myTurtle.home()


# 3. 绘制谢尔平斯基三角形
myPoints = [(-250, -125), (0, 250), (250, -125)]
sierpinski(myPoints, 5, myTurtle)
time.sleep(3)
myWin.reset()
myTurtle.home()


# 4. 利用递归算法解决汉诺塔问题
moveTower(2, 1, 3, 2)
print()
moveTower(3, 1, 3, 2)
print()


# 5. 利用递归算法解决迷宫问题
myMaze = Maze("mazefile.txt", myTurtle)
# 在屏幕上绘制迷宫
myMaze.drawMaze()
# 开始探索迷宫
searchFrom(myMaze, myMaze.startRow, myMaze.startCol)
time.sleep(3)
myWin.reset()
myTurtle.home()


# 6. 分别用递归和动态规划实现零钱兑换
start = time.time()
print(recMakeChange([1, 5, 10, 25], 63))
print("Time cost by recursion way is %fs" %(time.time() - start))
start = time.time()
print(dpMakeChange([1, 5, 10, 25], 63))
print("Time cost by dynamic programming way is %fs" %(time.time() - start))
print()

start = time.time()
print(recMakeChange([1, 5, 10, 21, 25], 63))
print("Time cost by recursion way is %fs" %(time.time() - start))
start = time.time()
print(dpMakeChange([1, 5, 10, 21, 25], 63))
print("Time cost by dynamic programming way is %fs" %(time.time() - start))
print()

# 7. 写一个程序来解决这样一个问题：有2个坛子，其中一个的容量是4加仑，另一个的是3加仑。坛子上都没有刻度线。可以用水泵将它们装满水。如何使4加仑的坛子最后装有2加仑的水
waterFilling(4, 3, 2)
print()

# 8. 假设一个计算机科学家兼艺术大盗闯入美术馆。他只能用一个容量为W磅的背包来装盗取的艺术品，并且他对每一件艺术品的价值和重量了如指掌。他会如何写一个动态规划程序来帮助自己最大程度地获利呢？下面的例子可以帮助你思考：假设背包容量是20磅，艺术品为5件
a = [(2, 3), (3, 4), (4, 8), (5, 8), (9, 10)]
print(knapsackProblem(a, 20))