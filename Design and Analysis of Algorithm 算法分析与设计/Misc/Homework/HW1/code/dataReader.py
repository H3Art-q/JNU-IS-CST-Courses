class Reader:
    def __init__(self, fileName) -> None:
        self.file = open(fileName, 'r')
        self.array = []

    def readData(self) -> list:
        self.array = self.file.readline().split(' ')
        self.array = [int(element) for element in self.array]

    def getData(self) -> list:
        return self.array
