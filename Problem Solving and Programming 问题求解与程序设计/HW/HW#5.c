#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main() {
    srand((unsigned)time(NULL));
    int in;
    char re;
    while (1) {
        int random = rand() % 100 + 1;
        for (int i = 0; i < 7; i++) {
            printf("Please guess a number between 1 and 100:\n");
            scanf("%d", &in);
            if (in > random) {
                printf("Wrong Number, Try Again.\nThe guess is too high.\n");
            } else if (in < random) {
                printf("Wrong Number, Try Again.\nThe guess is too low.\n");
            } else {
                printf("Hooray, you have won!\n");
                break;
            }
            printf("The number of guesses left is %d.\n", 6 - i);
            if (i == 6) {
                printf("\nSorry, you lose,the correct number is %d.", random);
            }
            printf("\n");
        }
        printf("Would you like to play again (y/n) ?\n");
        scanf("\n%c", &re);
        if (re == 'Y' || re == 'y') {
            printf("\n");
            continue;
        } else {
            break;
        }
    }
    // system("PAUSE");
    return 0;
}