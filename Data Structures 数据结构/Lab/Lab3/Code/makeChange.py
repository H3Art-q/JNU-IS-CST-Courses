def recMakeChange(coinValueList, change):
    minCoins = change
    if change in coinValueList:
        return 1
    else:
        for i in [c for c in coinValueList if c <= change]:
            numCoins = 1 + recMakeChange(coinValueList, change - i)
            if numCoins < minCoins:
                minCoins = numCoins
    return minCoins


def dpMakeChange(coinValueList, change):
    minCoins = [0] * (change + 1)
    for cents in range(change + 1):
        coinCount = cents
        for j in [c for c in coinValueList if c <= cents]:
            if minCoins[cents - j] + 1 < coinCount:
                coinCount = minCoins[cents - j] + 1
        minCoins[cents] = coinCount
    return minCoins[change]
