import itertools
import time

def AnagramJudge1(str1, str2):
    start = time.time()
    if len(str1) != len(str2):
        return False, time.time() - start
    strlist = list(str2)
    position1 = 0
    status = True
    while position1 < len(str1) and status:
        position2 = 0
        found = False
        while position2 < len(strlist) and not found:
            if str1[position1] == strlist[position2]:
                found = True
            else:
                position2 = position2 + 1
        if found:
            strlist[position2] = None
        else:
            status = False
        position1 = position1 + 1
    return status, time.time() - start


def AnagramJudge2(str1, str2):
    start = time.time()
    if len(str1) != len(str2):
        return False, time.time() - start
    strlist1 = list(str1)
    strlist2 = list(str2)
    strlist1.sort()
    strlist2.sort()
    position = 0
    status = True
    while position < len(strlist1) and status:
        if strlist1[position] == strlist2[position]:
            position = position + 1
        else:
            status = False
    return status, time.time() - start


def AnagramJudge3(str1, str2):
    start = time.time()
    if len(str1) != len(str2):
        return False, time.time() - start
    start = time.time()
    strlist = list(str1)
    strlen = len(str1)
    for possibility in itertools.permutations(strlist, strlen):
        if str2 == "".join(possibility):
            return True, time.time() - start
    return False, time.time() - start


def AnagramJudge4(str1, str2):
    start = time.time()
    if len(str1) != len(str2):
        return False, time.time() - start
    bucket1 = [0] * 26
    bucket2 = [0] * 26
    for i in range(len(str1)):
        position = ord(str1[i]) - ord('a')
        bucket1[position] = bucket1[position] + 1
    for i in range(len(str2)):
        position = ord(str2[i]) - ord('a')
        bucket2[position] = bucket2[position] + 1
    letter = 0
    status = True
    while letter < 26 and status:
        if bucket1[letter] == bucket2[letter]:
            letter = letter + 1
        else:
            status = False
    return status, time.time() - start


print(AnagramJudge1("macbook", "makbook"))
print(AnagramJudge2("macbook", "makbook"))
print(AnagramJudge3("macbook", "makbook"))
print(AnagramJudge4("macbook", "makbook"))

print()

print(AnagramJudge1("helloworld", "orlwhldelo"))
print(AnagramJudge2("helloworld", "orlwhldelo"))
print(AnagramJudge3("helloworld", "orlwhldelo"))
print(AnagramJudge4("helloworld", "orlwhldelo"))

print()

print(AnagramJudge1("datastructure", "structuredata"))
print(AnagramJudge2("datastructure", "structuredata"))
print(AnagramJudge3("datastructure", "structuredata"))
print(AnagramJudge4("datastructure", "structuredata"))
