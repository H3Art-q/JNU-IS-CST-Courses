#include <stdio.h>
int main() {
    int row = 0;
    scanf("%d", &row);
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < row - i - 1; j++) {
            printf(" ");
            if (j == (row - i - 2)) {
                printf("*");
            }
        }
        if (i != (row - 1)) {
            for (int k = 0; k < 2 * i - 1; k++) {
                printf(" ");
                if (k == (2 * i - 2)) {
                    printf("*");
                }
            }
        } else {
            for (int k = 0; k < 2 * i + 1; k++) {
                printf("*");
            }
        }
        printf("\n");
    }
    return 0;
}