from medianFinder import MedianFinder

'''
In the testing part, I found the recursive version
of quick selection will lead to stack overflow, it
cannot execute when the data size greater than about 1200.

Therefore, I modified this inplementation from recursive way 
to iterative way.
'''


class Selector:
    def __init__(self, array: list) -> None:
        self.array = array.copy()

    def getArray(self) -> list:
        return self.array

    # Recursive quick selection
    def selection(self,  nthIndex: int, array: list) -> int:
        # Set the final element of array as the pivot
        pivot = array[len(array) - 1]

        # Partition
        lowerSide = [element for element in array if element < pivot]
        midSide = [element for element in array if element == pivot]
        biggerSide = [element for element in array if element > pivot]

        lenOfLowerSide = len(lowerSide)
        lenOfMidSide = len(midSide)

        # Caution:
        # range(a, b) -> [a, b)
        if (nthIndex in range(lenOfLowerSide, lenOfLowerSide + lenOfMidSide)):
            return pivot
        elif (nthIndex in range(0, lenOfLowerSide)):
            return self.selection(nthIndex, lowerSide)
        else:
            return self.selection(nthIndex - lenOfLowerSide - lenOfMidSide, biggerSide)

    # Recursive BFPRT algorithm
    def selectionEnhance(self, nthIndex: int, array: list, partitionGap: int) -> int:
        # Use median of median algorithm to find the pivot,
        # other parts are basically the same as selection()
        pivot = MedianFinder(partitionGap, array).medianOfMedian()

        lowerSide = [element for element in array if element < pivot]
        midSide = [element for element in array if element == pivot]
        biggerSide = [element for element in array if element > pivot]

        lenOfLowerSide = len(lowerSide)
        lenOfMidSide = len(midSide)

        if (nthIndex in range(lenOfLowerSide, lenOfLowerSide + lenOfMidSide)):
            return pivot
        elif (nthIndex in range(0, lenOfLowerSide)):
            # Caution:
            # Recursion Function should be modified to selectionEnhance()
            return self.selectionEnhance(nthIndex, lowerSide, partitionGap)
        else:
            return self.selectionEnhance(nthIndex - lenOfLowerSide - lenOfMidSide, biggerSide, partitionGap)

    # Iterative quick selection
    def selectionIterative(self,  nthIndex: int) -> int:
        pivot = self.array[len(self.array) - 1]

        # First Partition
        lowerSide = [element for element in self.array if element < pivot]
        midSide = [element for element in self.array if element == pivot]
        biggerSide = [element for element in self.array if element > pivot]

        lenOfLowerSide = len(lowerSide)
        lenOfMidSide = len(midSide)

        # Iteratively Selection
        while (nthIndex not in range(lenOfLowerSide, lenOfLowerSide + lenOfMidSide)):
            if (nthIndex in range(0, lenOfLowerSide)):
                tempArray = lowerSide
            else:
                tempArray = biggerSide
                nthIndex = nthIndex - lenOfLowerSide - lenOfMidSide

            pivot = tempArray[len(tempArray) - 1]

            lowerSide = [element for element in tempArray if element < pivot]
            midSide = [element for element in tempArray if element == pivot]
            biggerSide = [element for element in tempArray if element > pivot]

            lenOfLowerSide = len(lowerSide)
            lenOfMidSide = len(midSide)

        return pivot

    # Iterative BFPRT algorithm
    def selectionEnhanceIterative(self, nthIndex: int, partitionGap: int) -> int:
        pivot = MedianFinder(partitionGap, self.array).medianOfMedian()

        lowerSide = [element for element in self.array if element < pivot]
        midSide = [element for element in self.array if element == pivot]
        biggerSide = [element for element in self.array if element > pivot]

        lenOfLowerSide = len(lowerSide)
        lenOfMidSide = len(midSide)

        while (nthIndex not in range(lenOfLowerSide, lenOfLowerSide + lenOfMidSide)):
            if (nthIndex in range(0, lenOfLowerSide)):
                tempArray = lowerSide
            else:
                tempArray = biggerSide
                nthIndex = nthIndex - lenOfLowerSide - lenOfMidSide

            pivot = MedianFinder(partitionGap, tempArray).medianOfMedian()

            lowerSide = [element for element in tempArray if element < pivot]
            midSide = [element for element in tempArray if element == pivot]
            biggerSide = [element for element in tempArray if element > pivot]

            lenOfLowerSide = len(lowerSide)
            lenOfMidSide = len(midSide)

        return pivot
