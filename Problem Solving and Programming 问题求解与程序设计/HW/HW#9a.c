#include <stdio.h>
#include <stdlib.h>
// Task a):编写出可以将给定成绩表数据写入一个名为grade.bin的二进制文件中
//         利用FILE文件指针配合fopen函数以写模式打开文件
//         再利用fwrite函数写入数据
double num[20] = { 90.3, 92.7, 90.3, 99.8, 85.3, 90.5, 87.3, 90.8, 93.2, 88.4, 93.8, 75.6, 82.4, 95.6, 78.2, 90.0, 93.5, 80.2, 92.9, 94.4 };

int main()
{
    FILE* fp;
    //注意判断文件是否正确打开
    //利用“wb”(写)模式打开当前目录下的grade.bin文件，若没有则创建之
    //不能使用fputs函数进行写入，fputs函数只能写入字符型数据而非二进制数据
    //利用fwrite函数可以写入二进制数据，fread可以读取二进制数据
    if ((fp = fopen("./grade.bin", "wb")) != NULL) {
        for (int i = 0; i < 20; i++) {
            fwrite(num + i, sizeof(double), 1, fp);
        }
    } else {
        printf("The file is not open correctly.\n");
        printf("Please check that the file exists\n");
        //若文件没有正确地打开，直接退出程序，返回代码-1表明程序错误结束
        exit(-1);
    }
    //读写结束完毕手动关闭文件流
    fclose(fp);
    printf("Now we have already put the data into the file,\n");
    return 0;
}