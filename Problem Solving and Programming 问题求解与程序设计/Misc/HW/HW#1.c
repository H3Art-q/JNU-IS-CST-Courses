#include <stdio.h>
int main() {
    long long speed = 300000000;
    long long time = 60 * 60 * 24 * 365;
    long long distance = speed * time;
    printf("%lld", distance);
    return 0;
}