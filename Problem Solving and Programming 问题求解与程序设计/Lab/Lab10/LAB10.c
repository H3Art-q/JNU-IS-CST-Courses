#include <stdio.h>
int main()
{
    const char* dayofweek[7] = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };
    int date = 0;
    scanf("%2d", &date);
    if (date < 1 || date > 30) {
        printf("The date is out of correct range.\n");
    } else {
        int cnt = date % 7;
        printf("This corresponding day of 2021/06/%d is %s.\n", date, *(dayofweek + cnt));
    }
    return 0;
}