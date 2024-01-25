package lab8.chapter13;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] sides = new double[3];
        String color;
        boolean isFilled;

        System.out.println("Enter the properties of a triangle:");
        System.out.print("Enter side1 length: ");
        sides[0] = input.nextDouble();
        System.out.print("Enter side2 length: ");
        sides[1] = input.nextDouble();
        System.out.print("Enter side3 length: ");
        sides[2] = input.nextDouble();
        System.out.print("Enter its color: ");
        color = input.next();
        System.out.print("Enter whether the triangle is filled: ");
        isFilled = input.nextBoolean();
        input.close();

        Triangle triangle = new Triangle(color, isFilled, sides[0], sides[1], sides[2]);

        System.out.println(triangle);
    }
}