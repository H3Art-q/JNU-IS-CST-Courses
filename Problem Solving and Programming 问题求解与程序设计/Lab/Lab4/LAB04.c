#include <stdio.h>
int main()
{
    double degree = 0, celsius = 0, fahrenheit = 0;
    char symbol;
    printf("Please type in the degree and the unit (C/c/F/f) or use \"EOF\" to terminate the program:\n");
    while (scanf("%lf%c", &degree, &symbol) != EOF) {
        if (symbol == 'c' || symbol == 'f') {
            symbol -= 32;
        }
        switch (symbol) {
        case 'C':
            fahrenheit = 9.0 / 5.0 * degree + 32.0;
            printf("The Fahrenheit equivalent of %5.2f degrees Celsius is %5.2f degrees\n\n", degree, fahrenheit);
            break;
        case 'F':
            celsius = 5.0 / 9.0 * (degree - 32.0);
            printf("The Celsius equivalent of %5.2f degrees Fahrenheit is %5.2f degrees\n\n", degree, celsius);
            break;
        }
        printf("Please type in the degree and the unit or use \"EOF\" to terminate the program:\n");
    }
    return 0;
}