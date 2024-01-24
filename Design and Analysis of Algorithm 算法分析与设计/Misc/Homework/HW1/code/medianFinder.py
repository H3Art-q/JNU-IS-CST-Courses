'''
Actually the built-in sort() method is faster than this insertSort()

However, it can reduce the time-complexity constant to a very low magnitude,
which makes the test become:

"The larger the partition gap I set, the faster algorithm it performs...?"
'''


class MedianFinder:
    def __init__(self, gap: int, array: list) -> None:
        self.array = array.copy()
        self.partitionGap = gap

    def insertSort(self, array: list) -> None:
        for i in range(1, len(array)):
            key = array[i]
            j = i-1
            while j >= 0 and key < array[j]:
                array[j+1] = array[j]
                j -= 1
            array[j+1] = key

    def medianOfMedian(self) -> int:
        length = len(self.array)

        # Use while() loop instead of recursion to find median of median
        while (length > self.partitionGap):
            extraPartition = length % self.partitionGap != 0
            partitionNumber = length // self.partitionGap
            medianArray = []

            for i in range(0, partitionNumber):
                # Life is short, we need python.
                tempArray = [
                    element for element in self.array[i * self.partitionGap:(i + 1) * self.partitionGap]
                ]
                self.insertSort(tempArray)
                medianArray.append(
                    tempArray[self.partitionGap // 2]
                )

            if (extraPartition):
                tempArray = [
                    element for element in self.array[partitionNumber * self.partitionGap:]
                ]
                self.insertSort(tempArray)
                medianArray.append(
                    tempArray[len(tempArray) // 2]
                )

            self.array = medianArray
            length = len(self.array)

        self.insertSort(self.array)
        return self.array[length // 2]
