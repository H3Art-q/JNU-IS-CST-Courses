def find_contiguous_subsequence_of_max_sum(numList: list) -> list:
    tempBeginIndex = maxBeginIndex = maxEndIndex = 0

    maxSum = tempSum = 0
    for index, element in enumerate(numList):
        tempSum += element

        # Dispose the subsequence when its sum < 0, because
        # the next contiguous elements cannot form a bigger sum
        if (tempSum < 0):
            tempSum = 0
            tempBeginIndex = index + 1
        # Update the max sum and the corresponding index
        elif (tempSum > maxSum):
            maxBeginIndex = tempBeginIndex
            maxEndIndex = index + 1
            maxSum = tempSum

    return numList[maxBeginIndex:maxEndIndex]


def main() -> None:
    numList = input(
        'Enter a sequence of consecutive numbers(Separated by SPACE):\n').split(' ')

    numList = [float(num) for num in numList]

    print(
        'The contiguous subsequence of maximum sum is:\n',
        find_contiguous_subsequence_of_max_sum(numList))


if __name__ == '__main__':
    main()
