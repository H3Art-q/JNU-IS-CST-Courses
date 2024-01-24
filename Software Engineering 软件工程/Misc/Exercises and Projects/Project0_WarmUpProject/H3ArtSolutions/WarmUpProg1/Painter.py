from turtle import Turtle, Screen


class Painter:
    def __init__(self) -> None:
        self.turtle = Turtle()
        self.turtle.speed(0)
        self.turtle.color('red')
        self.turtle.hideturtle()
        self.default_forward_length = 15

        self.screen = Screen()
        self.screen.title('Dragon Curve')
        self.screen.screensize(1920, 1080)
        self.screen.bgcolor('black')
        self.screen.setup(width=1.0, height=1.0)

    def paint(self, sequence: str):
        for action in sequence:
            if action == 'F':
                self.turtle.fd(self.default_forward_length)
            elif action == 'R':
                self.turtle.rt(90)
            elif action == 'L':
                self.turtle.lt(90)
        self.turtle.write('Click to exit', font=(16))
        self.screen.exitonclick()
