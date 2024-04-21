#include <stdio.h>
void swap(double* num1, double* num2)
{
    double temp = *num1;
    *num1 = *num2;
    *num2 = temp;
    return;
}
//冒泡排序
void bubble_sort(double* arr, int len, char sequence)
{
    //传入数组名会退化为数组的首地址，但依然可以在函数内用数组的方式操作整个数组变量
    //冒泡排序的思路是每次让指向的元素与下一个元素相比较，满足比较条件就进行交换
    //这样做最终会在每一轮比较后将最大/最小的元素移至比较范围内数组的一端
    double temp; //定义临时变量以进行后面步骤的值调换
    for (int i = 0; i < len - 1; i++) {
        //外循环代表冒泡排序总共需要进行（数组元素个数-1）次
        for (int j = 0; j < len - 1 - i; j++) {
            //内循环代表某一次排序过程中要进行（剩余未排序的数组元素个数-1）次
            switch (sequence) {
            case 'a':
                if (arr[j] > arr[j + 1]) {
                    swap(&arr[j], &arr[j + 1]);
                }
                break;
            case 'd':
                if (arr[j] < arr[j + 1]) {
                    swap(&arr[j], &arr[j + 1]);
                }
                break;
            }
        }
    }
}
//选择排序
void selection_sort(double* arr, int len, char sequence)
{
    //选择排序在每一轮中选出最大/最小的元素，然后将其移至选择范围内数组的一端
    double max, min, temp;
    int rec;
    switch (sequence) {
    case 'a':
        for (int i = 0; i < len - 1; i++) {
            //总共需要选择（数组元素个数-1）次
            min = arr[i];
            //每次开始的时候将最大值/最小值赋值为第一个元素
            rec = i;
            //每次开始的时候需要初始化一个标记，标记出最终为最大/最小值的数组下标
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    rec = j;
                }
            }
            //选出最大/最小值后就将选择范围内的第一个元素赋值为最大/最小值
            //同时将标记的那个数组下标对应的元素赋值为未赋值最大/最小值之前的第一个元素
            swap(&arr[rec], &arr[i]);
        }
        break;
    case 'd':
        for (int i = 0; i < len - 1; i++) {
            max = arr[i];
            rec = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    rec = j;
                }
            }
            swap(&arr[rec], &arr[i]);
        }
        break;
    }
}
//快速排序
void quick_sort(double* arr, int beg, int end, char sequence)
{
    //快速排序利用二分的思想进行排序
    if (beg > end) {
        return;
    }
    double std = arr[beg];
    //先将数组的第一个元素设为基准
    int i = beg, j = end;
    while (i != j) {
        switch (sequence) {
        case 'a':
            //以升序（正序）排序为例，设置两个哨兵i与j
            //让查找先从j开始，j对应比基准更大的数时直接自减
            while (arr[j] >= std && i < j) {
                j--;
            }
            //同理i对应比基准更小的数时就自增，最终i会指向比基准更大的数
            // j指向比基准更小的数
            while (arr[i] <= std && i < j) {
                i++;
            }
            break;
        case 'd':
            while (arr[j] <= std && i < j) {
                j--;
            }
            while (arr[i] >= std && i < j) {
                i++;
            }
            break;
        }
        //将i和j分别对应的数组元素交换
        if (i < j) {
            swap(&arr[i], &arr[j]);
        }
        //在结束的时候i==j,指向同一个元素
    }
    //最后将数组的第一个元素赋值为i和j指向的那个元素
    arr[beg] = arr[i];
    //然后i和j共同指向的元素赋值为基准值，这样就完成了将基准值前后的值都分成
    //比基准更大和比基准更小的部分
    arr[i] = std;
    //接下来递归重复调用，将每个部分逐渐二分进行快排，完成整个排序
    quick_sort(arr, beg, i - 1, sequence);
    quick_sort(arr, i + 1, end, sequence);
}
int main()
{
    double arr[10] = { 4.4, 3.3, 2.2, 5.5, 1.1, 6.6, 7.7, 10.0, 9.9, 8.8 };
    int sortway = 0;
    char order;
    printf("输入排序的顺序（正序为a倒序为d），再输入排序的方式（冒泡1/选择2/快速3）。\n");
    scanf("%c%d", &order, &sortway);
    switch (sortway) {
    case 1:
        bubble_sort(arr, 10, order);
        break;
    case 2:
        selection_sort(arr, 10, order);
        break;
    case 3:
        quick_sort(arr, 0, 9, order);
        break;
    }
    for (int i = 0; i < 10; i++) {
        printf("%.1lf ", arr[i]);
    }
    return 0;
}