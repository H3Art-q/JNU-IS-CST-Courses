/* convert a Celsius temperature to Fahrenheit */
#include <stdio.h>
int main01() {
	double celsius = 25; /* declaration and initialization */
	double fahrenheit; 
	fahrenheit = 9.0 / 5.0 * celsius + 32.0;
	printf("The Fahrenheit equivalent of %5.2f degrees Celsius\n", celsius);
	printf("is %5.2f degrees\n", fahrenheit);
	return 0;
}
/* calculate 10^2+11^2+12^2+……+20^2 */
int main02() {
	int out = 0;
	int n1 = 20;
	int n2 = 9;
	out = n1 * (n1 + 1) * (2 * n1 + 1) / 6 - n2 * (n2 + 1) * (2 * n2 + 1) / 6;
	printf("%d", out);
	return 0;
}