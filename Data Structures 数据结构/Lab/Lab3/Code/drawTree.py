from turtle import *


def tree(myTurtle, branchLen):
    # if branchLen > 5:
    #     myTurtle.forward(branchLen)
    #     myTurtle.right(20)
    #     tree(myTurtle, branchLen-15)
    #     myTurtle.left(40)
    #     tree(myTurtle, branchLen-10)
    #     myTurtle.right(20)
    #     myTurtle.backward(branchLen)
    if branchLen > 5:
        # 绘制右侧树枝
        myTurtle.forward(branchLen)
        myTurtle.right(20)
        tree(myTurtle, branchLen - 15)
        myTurtle.left(40)
        tree(myTurtle, branchLen - 15)
        myTurtle.right(20)
        myTurtle.backward(branchLen)
