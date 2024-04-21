#include <stdio.h>
#include <stdlib.h>
int n;
void mincol(int** a, int* b) {
    for (int i = 0; i < n; i++) {
        b[i] = a[0][i];
        for (int j = 1; j < n; j++) {
            if (a[j][i] < b[i]) {
                b[i] = a[j][i];
            }
        }
    }
    return;
}
int main() {
    printf("Input a number n to create a 2-D n x n array.\n");
    scanf("%d", &n);
    int** a = (int**)malloc(sizeof(int*) * n);
    int* b = (int*)calloc(n, sizeof(int));
    printf("Input the elements of this n x n array.\n");
    for (int i = 0; i < n; i++) {
        a[i] = (int*)calloc(n, sizeof(int));
        for (int j = 0; j < n; j++) {
            scanf("%d", &a[i][j]);
        }
    }
    mincol(a, b);
    for (int i = 0; i < n; i++) {
        printf("The minimum number of column %d is %d.\n", i, b[i]);
    }
    return 0;
}