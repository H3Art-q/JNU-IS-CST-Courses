def waterFilling(bigJarVolume, smallJarVolume, target, currentBigJar=0, currentSmallJar=0):
    # 错误条件处理
    if target == 0 or greatestCommonDivisor(bigJarVolume, smallJarVolume) != 1 and \
        (greatestCommonDivisor(target, greatestCommonDivisor(bigJarVolume, smallJarVolume)) == 1 or
         greatestCommonDivisor(bigJarVolume, smallJarVolume) > target):
        print("No solution to the problem")
        return

    while currentBigJar < bigJarVolume:

        if currentSmallJar == 0:
            currentSmallJar += smallJarVolume
            print("Fill the small jar")

        currentBigJar += currentSmallJar
        currentSmallJar = 0

        if currentBigJar > bigJarVolume:
            currentSmallJar = currentBigJar - bigJarVolume
            currentBigJar = bigJarVolume

        print("Pour the small jar into the big one")
        print("Now the big jar has %d gallons of water" % currentBigJar)
        print("Now the small jar has %d gallons of water" % currentSmallJar)
        print()

        if currentBigJar == target:
            break

    if currentBigJar == target:
        return
    else:
        print("Pour the water out of the big jar")
        print()
        currentBigJar = 0
        waterFilling(bigJarVolume, smallJarVolume, target,
                     currentBigJar, currentSmallJar)


# 求最大公约数，作异常处理
def greatestCommonDivisor(num1, num2):
    if num1 == 0 or num2 == 0:
        print("Error: Number cannot divided by zero")
        return
    if num1 > num2:
        if num1 % num2 == 0:
            return num2
        else:
            return greatestCommonDivisor(num2, num1 % num2)
    else:
        if num2 % num1 == 0:
            return num1
        else:
            return greatestCommonDivisor(num1, num2 % num1)


waterFilling(12, 5, 0)
