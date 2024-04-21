#include <stdio.h>
int main()
{
    int year, weight;
    scanf("%d %d", &year, &weight);
    if (year <= 1970) {
        if (weight < 2700) {
            printf("%d $%.2f", 1, 16.50);
        } else if (weight > 3800) {
            printf("%d $%.2f", 3, 46.50);
        } else {
            printf("%d $%.2f", 2, 25.50);
        }
    } else if (year >= 1980) {
        if (weight < 3500) {
            printf("%d $%.2f", 7, 35.50);
        } else {
            printf("%d $%.2f", 8, 65.50);
        }
    } else {
        if (weight < 2700) {
            printf("%d $%.2f", 4, 27.00);
        } else if (weight > 3800) {
            printf("%d $%.2f", 6, 52.50);
        } else {
            printf("%d $%.2f", 5, 30.50);
        }
    }
    return 0;
}