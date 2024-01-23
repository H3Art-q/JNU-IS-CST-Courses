import time

def SumofN_loop(n):
    start = time.time()
    sumofn = 0
    for i in range(1, n+1):
        sumofn = sumofn + i
    end = time.time()
    return sumofn, end - start
    # 返回值是一个tuple


def SumofN_formula(n):
    start = time.time()
    return (n * (n + 1)) / 2, time.time() - start

print(SumofN_loop(100000))
print(SumofN_formula(100000))

print()

print(SumofN_loop(1000000))
print(SumofN_formula(1000000))

print()

print(SumofN_loop(10000000))
print(SumofN_formula(10000000))

print()

print(SumofN_loop(100000000))
print(SumofN_formula(100000000))
