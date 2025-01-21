import random

'''
Create a random number data set for testing the selection algorithm.
'''


class Generator:
    def __init__(self, fileName: str) -> None:
        self.file = open(fileName, 'w')

    def unorderedGenerate(self, quantity: int, minNum: int, maxNum: int) -> None:
        for i in range(quantity):
            # Caution:
            # The final ' ' will not be deleted in split(' ')
            if (i == quantity - 1):
                self.file.write(str(random.randint(minNum, maxNum)))
            else:
                self.file.write(str(random.randint(minNum, maxNum)) + ' ')

    def orderedGenerate(self, quantity: int, minNum: int, maxNum: int) -> None:
        tempArray = []
        for i in range(quantity):
            tempArray.append(random.randint(minNum, maxNum))
        tempArray.sort()
        for i in range(quantity):
            # Caution:
            # The final ' ' will not be deleted in split(' ')
            if (i == quantity - 1):
                self.file.write(str(tempArray[i]))
            else:
                self.file.write(str(tempArray[i]) + ' ')

    def __del__(self) -> None:
        self.file.close()


def main():
    generator = Generator('testdata.txt')
    scale = 100000
    generator.unorderedGenerate(scale, -scale, scale)
    print('Data have been generated successfully')


if __name__ == '__main__':
    main()
