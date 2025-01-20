#include <stdio.h>

// fun1是幂函数
float fun1(int x, int n) {
    if (n > 1) {
        return x *
               fun1(x,
                    n - 1);  //传入的n若大于0，不断递至n为1，恰好满足幂次数为n次
    } else if (n == 0) {
        return 1;  //传入的n若为0，直接x^0 = 1
    } else {
        return x;  // n为1时，归
    }
}

// fun2是阶乘函数
float fun2(int n) {
    if (n > 1) {
        return n * fun2(n - 1);  //传入的n若大于0，不断递至n为1，恰好满足n阶乘
    } else if (n == 0) {
        return 1;  //传入的n若为0，规定0! = 1
    } else {
        return n;  //当n为1时，归
    }
}

// fune是e^x的泰勒公式
float fune(int x, int n) {
    float sum = fun1(x, n) / fun2(n);  //从最大阶数开始
    if (n > 0) {
        return fune(x, n - 1) + sum;  //不断递向低阶数，直至n = 1
    } else {
        return sum;  // n = 0时，此时当前层函数的sum值为1，开始归
    }
}

int main(void) {
    int x = 0, n = 0;
    scanf("%d%d", &x, &n);
    float output = fune(x, n);
    printf("%f", output);
    return 0;
}