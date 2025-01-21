INDEX_a = 0
INDEX_b = 1
INDEX_c = 2


class Result:
    def __init__(self) -> None:
        self.results = [False, False, False]


def result_classify(leftResult: int, rightResult: int) -> int:
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
    # 对起始下标以及末尾下标框定的区间, 构造一个子串, 每次循环对其进行分割成左右两部分进行递推求组合
    # 分割的起点从第一个元素与第二个元素之间开始, 到倒数第二个元素与倒数第一个元素之间结束
    for separatePosition in range(beginIndex, endIndex):

        # leftSide = expression[beginIndex:separatePosition+1] 左半部分可以化成a或b或c, 枚举之
        # rightSide = expression[separatePosition+1:endIndex+1] 右半部分也可以化成a或b或c, 枚举之
        for leftResult, leftReducible in enumerate(resultMap[beginIndex][separatePosition].results):
            # 如果左半部分可以化成单元素,
            if (leftReducible == True):
                for rightResult, rightReducible in enumerate(resultMap[separatePosition+1][endIndex].results):
                    if (rightReducible == True):
                        result = result_classify(leftResult, rightResult)
                        resultMap[beginIndex][endIndex].results[result] = True

        # 如果一个字序列能化简的结果已经包含a, b和c了, 直接返回, 不用继续计算
        if (resultMap[beginIndex][endIndex].results[INDEX_a] and
           resultMap[beginIndex][endIndex].results[INDEX_b] and
           resultMap[beginIndex][endIndex].results[INDEX_c]):
            return


def dp_result_calculation(expression: str) -> list:
    length = len(expression)
    # 列表推导式初始化整个二维列表, 不能使用列表乘(浅拷贝——直接复制了引用), 而应该使用for循环(每次创建出一个新的Result实例)
    # 存储方式还可以进一步优化成一维列表, 只要索引规划正确, 这个版本下的二维列表其实只需要用到一半的空间, 还是挺浪费的
    resultMap = [[Result() for col in range(length)] for row in range(length)]

    # 为列表初始化每个单元素
    for i in range(length):
        if (expression[i] == 'a'):
            resultMap[i][i].results[INDEX_a] = True
        elif (expression[i] == 'b'):
            resultMap[i][i].results[INDEX_b] = True
        elif (expression[i] == 'c'):
            resultMap[i][i].results[INDEX_c] = True
        else:
            return "Invalid character in string"

    # 从双元素开始自底向上递推求更多元素的组合可能性
    for r in range(2, length+1):
        # 对于每次求组合, 从最初元素开始, 设置起始下标
        for beginIndex in range(0, length-r+1):
            # 设置末尾下标
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
