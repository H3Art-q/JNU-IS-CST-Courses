'''
To check the "selection & its improval" algorithm, the 
checker module is designed.

This module use python's sort() function to
directly sort the test data and finally select
the number from the corresponding index.
'''


class Comparator:
    def __init__(self, array: list) -> None:
        self.array = array.copy()

    def selection(self, nthIndex: int) -> int:
        self.array.sort()
        return self.array[nthIndex]
