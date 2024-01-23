def knapsackProblem(artWorks, bearing):
    # 初始化二维列表
    record = [[0 for i in range(bearing + 1)]for j in range(len(artWorks) + 1)]

    # 以每个物品的序号作为行
    for i in range(1, len(artWorks) + 1):
        currentMass = artWorks[i - 1][0]
        currentPrice = artWorks[i - 1][1]
        # 在上一个物品放入的基础上
        # 判断是否将当前物品代替上一个物品
        # 或者直接叠加该物品
        for j in range(1, bearing + 1):
            # 比背包的容量大才开始进行判断是否装入
            if currentMass <= j:
                # 判断的条件：装入前后的价值变化，取大值
                record[i][j] = max(record[i - 1][j], record[i - 1]
                                   [j - currentMass] + currentPrice)

    return [record[-1][-1], getKnapsackItems(record, artWorks)]


# 输出拿了哪些物品
def getKnapsackItems(record, artWorks):
    # 从dp完毕的二维列表中要求的最大获利位置开始检索
    sequence = []
    y = len(record) - 1
    x = len(record[0]) - 1
    while x > 0 and y > 0:

        # 若该物品行的这一列价值与上一行的这一列价值相同
        # 意味着没有拿该物品，将搜索位置移至上一行
        if record[y][x] == record[y - 1][x]:
            y -= 1

        # 若该物品行的这一列价值与上一行的这一列价值不同
        # 意味着该物品有被拿取，将搜索位置减去该物品
        # 再将搜索位置移至上一行进行搜索
        else:
            sequence.append(artWorks[y - 1])
            x -= artWorks[y - 1][1]
            y -= 1

    # 搜索顺序是从最后拿取的物品开始的，所以将列表反转
    return list(reversed(sequence))
