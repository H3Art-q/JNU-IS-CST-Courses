#include <stdio.h>
#include <string.h>
#define MAXLEN 50
int main()
{
    char str[MAXLEN];
    scanf("%s", str);
    for (int i = 0; i < strlen(str) - 1; i++) {
        for (int j = 0; j < strlen(str) - 1 - i; j++) {
            if (str[j] > str[j + 1]) {
                char temp = str[j];
                str[j] = str[j + 1];
                str[j + 1] = temp;
            }
        }
    }
    printf("The string in ascending order is \"%s\".\n",str);
    return 0;
}