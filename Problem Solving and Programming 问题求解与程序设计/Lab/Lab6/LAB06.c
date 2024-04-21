#include <math.h>
#include <stdio.h>
void date(int input, int* month, int* day, int* year)
{
    int m = 0, d = 0, y = 0;
    for (int i = 0; i < 8; i++) {
        if (i < 2) {
            d += (input % 10) * pow(10, i);
        } else if (i < 4) {
            m += (input % 10) * pow(10, i - 2);
        } else {
            y += (input % 10) * pow(10, i - 4);
        }
        input /= 10;
    }
    *month = m;
    *day = d;
    *year = y;
    return;
}
int main()
{
    int input;
    int month, day, year;
    printf("Please input a date (Format:yyyymmdd).\n");
    scanf("%d", &input);
    date(input, &month, &day, &year);
    printf("%d %d %d\n", year, month, day);
    return 0;
}