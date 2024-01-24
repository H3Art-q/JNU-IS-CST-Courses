from Dragon import Dragon
from Painter import Painter


def main():
    N = int(input('Please input an integer N: '))

    dragon = Dragon(N)
    dragon.sequenceGenerator()

    print('The path sequence of the dragon curve is:')
    print(dragon.getSequence())

    # If you want to see visual result, please remove these 2 line comment
    # ⬇
    # painter = Painter()
    # painter.paint(dragon.getSequence())


if __name__ == '__main__':
    main()
