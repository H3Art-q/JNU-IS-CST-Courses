'''
化简规则:
aa = ab = bb = b

ac = bc = ca = a

ba = cb = cc = c

0. 已知每个连续的双元素串都有对应的单元素表示

1. 利用动态规划的思想, 维护一个长度len(输入字符串)的二维列表(len x len)

2. 对于在string中每个字串, 都要计算出它能最终化简成为的单个项(a, b, c)

3. 计算自底向上进行, 先对字符串子串的最小单位——单个字符进行操作, 初始化列表的第i行第i列

4. 接下来对双元素串进行计算, 得到它们能组合出的单元素表示, 并将结果记录在列表的第i行第i+1列

5. 计算三元素串的最简表示, 利用单元素以及双元素的表示(已存储在列表中)计算得出

6. 以此类推, 得到整个字符串能化简成的单元素表示

7. 对于存储在列表中的每个元素, 他们都有以下数据段:

    a, b, c以布尔值数组表示(a下标为0, b下标为1, c下标为2), 代表当前的列表存储的第i行第j列, 
    
    即字符串的[i:j]字串能否被化简为a或b或c的单元素表示, sep_pos_a, sep_pos_b, sep_pos_c以整数数组表示
    
    代表若字符串的[i:j]字串想化简为单元素表示, 它必须从其中的哪个绝对下标分割成更小的子串

8. 根据化简规则可得:

    02 -> 12 -> 20 -> 0

    00 -> 01 -> 11 -> 1

    10 -> 21 -> 22 -> 2
'''

string = 'hello'

beginIndex = 0
endIndex = 4
for separatePosition in range(beginIndex+1, endIndex):
    print(string[beginIndex:separatePosition])
    print(string[separatePosition:endIndex+1])
    print()


# row = 0
# for i in r:
#     col = 0
#     for j in i:
#         print(j.results[INDEX_a], j.results[INDEX_b], j.results[INDEX_c],
#                 '({0}, {1})'.format(row, col))
#         col += 1
#     print()
#     row += 1