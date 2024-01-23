from turtle import *


def drawSpiral(myTurtle, lineLen):
    if lineLen > 0:
        myTurtle.forward(lineLen)
        myTurtle.right(90)
        drawSpiral(myTurtle, lineLen-5)


# myTurtle = Turtle()
# myWin = myTurtle.getscreen()
# drawSpiral(myTurtle, 100)
# myWin.exitonclick()
