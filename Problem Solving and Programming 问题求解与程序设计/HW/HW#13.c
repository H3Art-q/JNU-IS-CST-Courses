#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define STUDID 2021102716

long long num[2], cnt = 0;

void ReadNumber(const char* str) {
    long long judge = 1; /*To judge whether the number is positive or negative*/
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '-') {
            judge = -1;
        } else {
            /*Using bit operator to convert, store and update the number from
             * argv*/
            num[cnt] = (num[cnt] << 3) + (num[cnt] << 1) + (str[i] ^ '0');
        }
    }
    /*Switch to store number in another long long variable automatically*/
    num[cnt++] *= judge;
    return;
}

void Calculation(char opt) {
    switch (opt) {
        case '+':
            printf("%lld + %lld = %lld\n", num[0], num[1], num[0] + num[1]);
            break;
        case '-':
            printf("%lld - %lld = %lld\n", num[0], num[1], num[0] - num[1]);
            break;
        case 'x':
            printf("%lld x %lld = %lld\n", num[0], num[1], num[0] * num[1]);
            break;
        case '/':
            if (num[1] == 0) {
                printf("Number cannot be divided by zero.\n");
                exit(2);
            } else {
                printf("%lld / %lld = %lld\n", num[0], num[1], num[0] / num[1]);
            }
            break;
        case '%':
            if (num[1] == 0) {
                printf("Number cannot be divided by zero.\n");
                exit(2);
            } else {
                printf("%lld %% %lld = %lld\n", num[0], num[1],
                       num[0] % num[1]);
            }
            break;
        default:
            printf(
                "You might enter a wrong operator, please check your input.\n");
            exit(3);
    }
    return;
}

/*The program receives 4 arguments when it runs successfully
  These 4 arguments are:
  1. The address to this program
  2. The first number
  3. The operator
  4. The second number
*/
int main(int argc, char* argv[]) {
    if (argc < 4) {
        printf("The number of arguments you entered is not enough.\n");
        exit(1);
    } else {
        ReadNumber(*(argv + 1));
        ReadNumber(*(argv + 3));
        printf("The corresponding calculation is as follow:\n");
        Calculation(*(argv + 2)[0]);
    }
    return 0;
}