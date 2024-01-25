package lab1.chapter2;

import java.util.Scanner;

public class AreaOfTriangle {
    public static double side(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double area(double[] sides) {
        double factorS = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(factorS * (factorS - sides[0]) * (factorS - sides[1]) * (factorS - sides[2]));
    }

    public static boolean sameLineChecker(double[][] points) {
        // Judge (y1 - y2)/(x1 - x2) == (y1 - y3)/(x1 - x3) -> (y1 - y2)(x1 - x3) == (y1 - y3)(x1 - x2)
        return (points[0][1] - points[1][1]) * (points[0][0] - points[2][0])
                == (points[0][1] - points[2][1]) * (points[0][0] - points[1][0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] points = new double[3][2];
        double[] sides = new double[3];

        System.out.println("Enter the coordinates of three points separated by spaces\n" +
                "like x1 y1 x2 y2 x3 y3:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }

        if (sameLineChecker(points)) {
            throw new RuntimeException("Not a triangle, points are on the same line");
        }

        sides[0] = side(points[0][0], points[0][1], points[1][0], points[1][1]);
        sides[1] = side(points[0][0], points[0][1], points[2][0], points[2][1]);
        sides[2] = side(points[1][0], points[1][1], points[2][0], points[2][1]);

        System.out.println("The area of the triangle is " + area(sides) + ".");

    }
}
