from pythonds import Stack

def DecToBin(decNumber):
    remstack = Stack()
    while decNumber > 0:
        rem = decNumber % 2
        remstack.push(rem)
        decNumber = decNumber // 2
    binString = ""
    while not remstack.isEmpty():
        binString = binString + str(remstack.pop())
    return binString


def baseConverter(decNumber, base):
    digits = "0123456789ABCDEF"
    remstack = Stack()
    while decNumber > 0:
        rem = decNumber % base
        remstack.push(rem)
        decNumber = decNumber // base
    newString = ""
    while not remstack.isEmpty():
        newString = newString + digits[remstack.pop()]
    return newString

print(DecToBin(255))
print(DecToBin(65536))
print(DecToBin(114514))
print(DecToBin(1919810))

print()

print(baseConverter(127, 16))
print(baseConverter(72, 8))
print(baseConverter(2022, 4))
print(baseConverter(255, 2))