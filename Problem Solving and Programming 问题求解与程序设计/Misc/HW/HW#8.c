#include <stdio.h>
#include <string.h>
#define LEN 100
//题目分析：
//1. 若使用scanf，利用%c来接收空格与换行，但使用gets更简单，gets读取到换行直接停止
//  （但似乎gets在stdio.h中已经被删除了？）
//2. 给出数据的第一个字符只能是+、-、小数点或者数字，而不能是空格或者直接\0
//3. 除第一个字符以外，剩下的字符只能是数字或小数点
//4. 小数点出现的次数至多只能有一次
//5. 至少出现一个0-9的数字
int isvalidReal(char* str)
{
    int i = 0, numcnt = 0, dotcnt = 0;
    //第一个字符的判断用一个if单独进行
    if (str[0] != '+' && str[0] != '-' && str[0] != '.' && (str[0] < 48 || str[0] > 57)) {
        return 0;
    }
    //接下去字符判断连续进行直到遇见'\0',但必须从第一个字符开始
    //因为要满足小数点的计数器记录下第一位的小数点，否则“..009”会被判定为有效
    while (str[i] != '\0') {
        if ((str[i] < 48 || str[i] > 57) && str[i] != '.') {
            return 0;
        } else if (str[i] > 47 && str[i] < 58) {
            numcnt++;
        } else {
            dotcnt++;
        }
        if (dotcnt > 1) {
            return 0;
        }
        i++;
    }
    if (numcnt < 1) {
        return 0;
    } else {
        return 1;
    }
}
int main()
{
    char str[LEN];
    memset(str, 0, sizeof(char) * LEN);
    printf("Input the number and finally use \"ENTER\" key to end the input.\n");
    //利用scanf的解决方案：
    //for (int i = 0; i < LEN; i++) {
    //    scanf("%c", &str[i]);
    //    if (str[i] == '\n') {
    //      str[i] = '\0';
    //      break;
    //  }
    //}
    gets(str);
    int result = isvalidReal(str);
    printf("Your input is \"%s\".\nThe result is %d.\n", str, result);
    if (result) {
        printf("Thus, your input is a valid real number.");
    } else {
        printf("Thus, your input isn't a valid real number.");
    }
    return 0;
}