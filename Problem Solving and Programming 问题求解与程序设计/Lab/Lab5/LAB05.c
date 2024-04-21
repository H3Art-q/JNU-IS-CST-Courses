#include <stdio.h>
#include <stdlib.h>
double det2(double**, int, int, int, int);
double det3(double**);
int main()
{
    int level = 0;
    double result = 0;
    printf("please type in the level of determinant(2 / 3)\n");
    scanf("%d", &level);
    if (level == 2) {
        double** det = (double**)malloc(sizeof(double*) * level);
        for (int i = 0; i < level; i++) {
            det[i] = (double*)malloc(sizeof(double) * level);
            for (int j = 0; j < 2; j++) {
                scanf("%lf", &det[i][j]);
            }
        }
        result = det2(det, 0, 1, 0, 1);
        printf("%lf\n", result);
    } else if (level == 3) {
        double** det = (double**)malloc(sizeof(double*) * level);
        for (int i = 0; i < level; i++) {
            det[i] = (double*)malloc(sizeof(double) * level);
            for (int j = 0; j < 3; j++) {
                scanf("%lf", &det[i][j]);
            }
        }
        result = det3(det);
        printf("%lf\n", result);
    } else {
        printf("Wrong input, the program will end.\n");
    }
    return 0;
}

double det2(double** det, int row1, int row2, int col1, int col2)
{
    double result = det[row1][col1] * det[row2][col2] - det[row1][col2] * det[row2][col1];
    return result;
}

double det3(double** det)
{
    double result = 0;
    result += det[0][0] * det2(det, 1, 2, 1, 2);
    result -= det[1][0] * det2(det, 0, 2, 1, 2);
    result += det[2][0] * det2(det, 0, 1, 1, 2);
    return result;
}