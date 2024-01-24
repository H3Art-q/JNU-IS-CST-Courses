from dataReader import Reader
from selector import Selector
from selectorComparator import Comparator
import time


class Test:
    def __init__(self, fileName: str) -> None:
        self.reader = Reader(fileName)
        self.data = self.reader.readData()
        self.selector = Selector(self.reader.getData())
        self.comparator = Comparator(self.reader.getData())

        # Test index range from 0 to len(data) - 1
        self.testDataLen = len(self.reader.getData())
        # Test 10 positions per data set
        self.testStepLen = self.testDataLen // 10

    def quickSelectTest(self) -> float:
        totalTimeCost = 0
        for i in range(0, self.testDataLen, self.testStepLen):
            startTime = time.time()
            selectResult = self.selector.selectionIterative(i)
            totalTimeCost += time.time() - startTime

            # Judge whether the result is correct
            assert (selectResult == self.comparator.selection(i)
                    ), 'Quick Select algorithm is implemented wrongly.'

        testTimes = self.testDataLen / self.testStepLen
        avgTimeCost = totalTimeCost / testTimes
        return avgTimeCost

    def BFPRTtimeCostTest(self, partitionGap: int) -> float:
        totalTimeCost = 0
        for i in range(0, self.testDataLen, self.testStepLen):
            startTime = time.time()
            selectResult = self.selector.selectionEnhanceIterative(
                i, partitionGap)
            totalTimeCost += time.time() - startTime

            # Judge whether the result is correct
            assert (selectResult == self.comparator.selection(
                i)), 'Quick Select algorithm(BFPRT enabled) is implemented wrongly.'

        testTimes = self.testDataLen / self.testStepLen
        avgTimeCost = totalTimeCost / testTimes
        return avgTimeCost


def main():
    test = Test('testdata.txt')

    print('Average time cost of quick select:')
    print(str(test.quickSelectTest()) + 's')

    for i in range(3, 8, 2):
        print('Average time cost of quick select(BFPRT enabled -> partition {}):'.format(i))
        print(str(test.BFPRTtimeCostTest(i)) + 's')


if __name__ == '__main__':
    main()
