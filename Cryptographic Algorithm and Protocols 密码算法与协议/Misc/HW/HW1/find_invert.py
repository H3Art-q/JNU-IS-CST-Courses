'''
穷举法找模逆元/trial and test法
'''
num = int(input())
print('Find the number from 1 - {0}\'s invert modulo factor'.format(num))

for i in range(1, num):
    for j in range(1, 100):
        if (i * j) % num == 1:
            print('For {0}, the invert is {1}.'.format(i, j))
            break