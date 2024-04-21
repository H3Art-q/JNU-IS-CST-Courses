#include <stdio.h>
#include <stdlib.h>
// Task b):让程序可以读取文件中的数据，数据是五行四列的成绩表
//         因此，使用fread函数扫描文件中的数据
//         最终将数据存储在二维数组中进行平均成绩计算
int main(){
    FILE* fp;
    double grade_table[5][4], avg = 0;
    //利用“rb”(读)模式打开当前目录下的grade.bin文件
    if ((fp = fopen("./grade.bin", "rb")) != NULL) {
        for (int i = 0; i < 5; i++) {
            avg = 0;
            for (int j = 0; j < 4; j++) {
                //该函数可以读取FILE指针对应文件的内容
                fread(&grade_table[i][j], sizeof(double), 1, fp);
                avg += grade_table[i][j];
            }
            printf("%lf\n", avg / 4);
        }
    } else {
        printf("The file is not open correctly.\n");
        //用非0返回值代表程序运行发生了错误，便于查错
        exit(1);
    }
    fclose(fp);
    return 0;
}