#include <stdio.h>
#define LEN 10
//目标：1. 用指针代替数组下标进行选择或冒泡排序(对指针+偏移量的和取值可实现与访问数组对应下标同样的效果）
//      2. 分别写出升序排序以及降序排序
double array[LEN] = { 4.4, 3.3, 2.2, 5.5, 1.1, 6.6, 7.7, 10.0, 9.9, 8.8 };
//两个变量值交换的函数声明
void Swap_double(double*, double*);
//创建一个函数指针
void (*sort)(double*);

void dec(double* arr)
{
    for (int i = 0; i < LEN - 1; i++) {
        for (int j = 0; j < LEN - 1 - i; j++) {
            if (*(arr + j) < *(arr + j + 1)) {
                Swap_double(arr + j, arr + j + 1);
            }
        }
    }
    return;
}

//利用选择排序进行升序排列操作
void inc(double* arr)
{
    for (int i = 0; i < LEN - 1; i++) {
        double min = *(arr + i);
        int rec = i;
        for (int j = i + 1; j < LEN; j++) {
            if (*(arr + j) < min) {
                min = *(arr + j);
                rec = j;
            }
        }
        Swap_double(arr + i, arr + rec);
    }
    return;
}

//封装交换函数
void Swap_double(double* a, double* b)
{
    double temp = *a;
    *a = *b;
    *b = temp;
    return;
}

int main()
{
    //将升序排序函数的地址赋给一开始创建的函数指针
    sort = &inc;
    //对函数指针取值便可以调用升序排序函数
    (*sort)(array);
    printf("The result by using selection way to sort the array in increasing sequence shows as follow:\n");
    for (int i = 0; i < LEN; i++) {
        printf("%.1lf ", *(array + i));
    }
    printf("\n");
    //把函数指针指向的函数地址更改为降序排序函数的地址
    sort = &dec;
    (*sort)(array);
    printf("The result by using bubblesort way to sort the array in decreasing sequence shows as follow:\n");
    for (int i = 0; i < LEN; i++) {
        printf("%.1lf ", *(array + i));
    }
    printf("\n");
    return 0;
}