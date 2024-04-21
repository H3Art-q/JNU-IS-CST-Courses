#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXLEN 2021102716

char str[MAXLEN];

void upperToLower(char* letter) {
    *letter = (*letter) | ' ';
    return;
}

void lowerToUpper(char* letter) {
    *letter = (*letter) & '_';
    return;
}

int main(void) {
    printf("Please enter a string:\n");
    scanf("%s", str);
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            lowerToUpper(&str[i]);
        } else if (str[i] >= 'A' && str[i] <= 'Z') {
            upperToLower(&str[i]);
        }
    }
    printf("The result of uppercase and lowercase conversion is:\n");
    printf("%s\n", str);
    return 0;
}