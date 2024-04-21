#include <iostream>
#include <string>
using namespace std;
#define PI 3.141592

double area(double radius) { return radius * radius * PI; }

double area(double length, double width) { return length * width; }

double area(double upperbase, double bottom, double height) {
    return height * (upperbase + bottom) / 2;
}

template <typename Type_Add>
Type_Add add(Type_Add a, Type_Add b) {
    return a + b;
}

int main(void) {
    ios::sync_with_stdio(false);

    // Calculation of circle area
    double r;
    cout << "Please enter the radius of a circle:" << endl;
    cin >> r;
    cout << "The area of a circle with radius " << r;
    cout << " is " << area(r) << "."
         << "\n"
         << endl;

    // Calculation of rectangular area
    double l, w;
    cout << "Please enter the length and width of a rectangle:" << endl;
    cin >> l >> w;
    cout << "The area of a rectangle with length " << l;
    cout << " and width " << w;
    cout << " is " << area(l, w) << "."
         << "\n"
         << endl;

    // Calculation of a trapezoid area
    double u, b, h;
    cout << "Please enter the upperbase, bottom and height of a trapezoid:"
         << endl;
    cin >> u >> b >> h;
    cout << "The area of a trapezoid with upper base " << u;
    cout << " bottom " << b << " and height " << h;
    cout << " is " << area(u, b, h) << "."
         << "\n"
         << endl;

    // Addition of 2 int-type numbers
    int num1, num2;
    cout << "Please enter 2 int-type numbers:" << endl;
    cin >> num1 >> num2;
    cout << num1 << " + " << num2 << " = " << add(num1, num2) << "\n" << endl;

    // Addition of 2 double-type numbers
    double num3, num4;
    cout << "Please enter 2 double-type numbers:" << endl;
    cin >> num3 >> num4;
    cout << num3 << " + " << num4 << " = " << add(num3, num4) << "\n" << endl;

    // Addition of 2 strings
    string str1, str2;
    cout << "Please enter 2 string(Seperated by SPACE or ENTER):" << endl;
    cin >> str1 >> str2;
    cout << str1 << " + " << str2 << " = " << add(str1, str2) << "\n" << endl;

    return 0;
}