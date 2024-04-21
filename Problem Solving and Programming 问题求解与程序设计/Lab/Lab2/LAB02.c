#include <math.h>
#include <stdio.h>
int main()
{
    double g, height, speed;
    scanf("%lf%lf", &g, &height);
    for (int i = 0; i < 3; i++) {
        speed = sqrt(2 * g * height);
        height *= (2.0 / 3.0);
        printf("time %d:\nspeed=%.3lf\nheight=%.3lf\n\n", i + 1, speed, height);
    }
    return 0;
}