INDEX_a, INDEX_b, INDEX_c = 0, 1, 2


class Result:
    def __init__(self) -> None:
        self.results = [False, False, False]


def result_classify(leftResult: int, rightResult: int) -> int:
    # Redution Rules:
    # ac = bc = ca = a
    # aa = ab = bb = b
    # ba = cb = cc = c
    if (leftResult == INDEX_a and rightResult == INDEX_b
       or leftResult == INDEX_b and rightResult == INDEX_c
       or leftResult == INDEX_c and rightResult == INDEX_a):
        return INDEX_a
    elif (leftResult == INDEX_a and rightResult == INDEX_a
          or leftResult == INDEX_a and rightResult == INDEX_b
          or leftResult == INDEX_b and rightResult == INDEX_b):
        return INDEX_b
    else:
        return INDEX_c


def result_record(resultMap: list, beginIndex: int, endIndex: int) -> None:
    # Part the substring into 2 parts and calculate the most simplified form
    for separatePosition in range(beginIndex, endIndex):

        for leftResult, leftReducible in enumerate(resultMap[beginIndex][separatePosition].results):
            # If the left part can be reduced to a, b or c, continue to find the most simplified form of right part
            if (leftReducible == True):
                for rightResult, rightReducible in enumerate(resultMap[separatePosition+1][endIndex].results):
                    if (rightReducible == True):
                        # Find the reduction form of the right and left parts'combination
                        result = result_classify(leftResult, rightResult)
                        resultMap[beginIndex][endIndex].results[result] = True

        # If the reduction result of the substring has already contained a, b and c, function returns directly
        if (resultMap[beginIndex][endIndex].results[INDEX_a] == True and
           resultMap[beginIndex][endIndex].results[INDEX_b] == True and
           resultMap[beginIndex][endIndex].results[INDEX_c] == True):
            return


def dp_result_calculation(expression: str) -> list:
    length = len(expression)
    # Initialize the total 2-dimensional list
    # (The storage form actually can be optimized to 1-dimensional list)
    resultMap = [[Result() for col in range(length)] for row in range(length)]

    # Initialize the single character result
    for i in range(length):
        if (expression[i] == 'a'):
            resultMap[i][i].results[INDEX_a] = True
        elif (expression[i] == 'b'):
            resultMap[i][i].results[INDEX_b] = True
        elif (expression[i] == 'c'):
            resultMap[i][i].results[INDEX_c] = True
        else:
            return "Invalid character in string"

    # Start from substring containing 2 characters to the total string
    for r in range(2, length+1):
        for beginIndex in range(0, length-r+1):
            endIndex = beginIndex+r-1
            result_record(resultMap, beginIndex, endIndex)

    return resultMap


def main() -> None:
    string = input(
        'Enter a string containing only the characters \'a\',\'b\',\'c\':\n')

    r = dp_result_calculation(string)

    if (r[0][len(string) - 1].results[INDEX_a] == True):
        print('It has a computational order such that the final result is \'a\'')
    else:
        print('It does NOT have a computational order such that the final result is \'a\'')


if __name__ == '__main__':
    main()
