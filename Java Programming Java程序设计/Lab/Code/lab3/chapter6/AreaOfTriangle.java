package lab3.chapter6;
// 6.19

import java.util.Scanner;

public class AreaOfTriangle {
    final static int SIDENUM = 3;

    /* Return true if the sum of every two sides is greater than the third side. */
    public static boolean isValid(double side1, double side2, double side3) {
        return side1 + side2 > side3 &&
                side2 + side3 > side1 &&
                side1 + side3 > side2;
    }

    /* Return the area of the triangle. */
    public static double area(double side1, double side2, double side3) {
        double sFactor = (side1 + side2 + side3) / 2;
        return Math.sqrt(sFactor * (sFactor - side1) * (sFactor - side2) * (sFactor - side3));
    }

    public static void main(String[] args) {
        double[] sides = new double[SIDENUM];

        Scanner input = new Scanner(System.in);

        System.out.print("Enter 3 sides of a triangle(seperated by SPACE): ");
        for (int i = 0; i < SIDENUM; i++) {
            sides[i] = input.nextDouble();
        }

        if (isValid(sides[0], sides[1], sides[2])) {
            System.out.println("The area of this triangle is: " + area(sides[0], sides[1], sides[2]));
        } else {
            System.out.println("The input is invalid, cannot form a triangle.");
        }

    }
}
