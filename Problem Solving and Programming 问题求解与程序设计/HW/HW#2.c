#include <math.h>
#include <stdio.h>
int main() {
    double p = 6.0 * exp(0.02 * (2010 - 2000));
    double A, R, X, N;
    /*R为利率，X为本金,N为存的时间（年）*/
    printf("%lf\n", p);
    scanf("%lf %lf %lf", &R, &X, &N);
    A = X * pow((1.0 + R / 100), N);
    printf("%lf", A);
    return 0;
}