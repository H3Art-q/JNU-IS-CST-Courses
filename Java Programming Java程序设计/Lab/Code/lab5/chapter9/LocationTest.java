package lab5.chapter9;

import java.util.Scanner;

public class LocationTest {
    public static Location locateLargest(double[][] a) {
        Location result = new Location();
        int lenOfRow = a.length;
        int lenOfColumn = a[0].length;

        for (int i = 0; i < lenOfRow; i++) {
            for (int j = 0; j < lenOfColumn; j++) {
                if (a[i][j] > result.maxValue) {
                    result.maxValue = a[i][j];
                    result.row = i;
                    result.column = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns in the array: ");
        int numberOfRow = input.nextInt();
        int numberOfColumn = input.nextInt();

        double[][] testArray = new double[numberOfRow][numberOfColumn];

        System.out.println("Enter the array:");
        for (int i = 0; i < numberOfRow; i++) {
            for (int j = 0; j < numberOfColumn; j++) {
                testArray[i][j] = input.nextDouble();
            }
        }

        Location findResult = locateLargest(testArray);

        System.out.printf("The location of the largest element is %f at (%d, %d)",
                findResult.maxValue, findResult.row, findResult.column);
    }
}
