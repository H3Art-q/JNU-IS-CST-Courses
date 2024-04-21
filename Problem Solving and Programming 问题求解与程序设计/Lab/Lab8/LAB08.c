#include <stdio.h>
#include <string.h>
int main()
{
    char str[50];
    //设置一个存储字符ascii码的桶
    int tank[128], i = 0;
    memset(tank, 0, sizeof(int) * 128);
    scanf("%s", str);
    while (str[i] != '\0') {
        //将扫描到的字符入对应的桶
        tank[str[i++]]++;
    }
    for (i = 0; i < 128; i++) {
        //输出桶内的数字并将桶内数字的计数减少
        while (tank[i]-- > 0) {
            printf("%c", i);
        }
    }
    printf("\n");
    return 0;
}