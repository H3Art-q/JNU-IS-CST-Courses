package lab4.chapter8;
// 8.27

import java.util.Scanner;

public class ColumnSorting {
    final static int STAGE = 3;

    public static double[][] initMatrix(Scanner input) {
        double[][] matrix = new double[STAGE][STAGE];
        for (int i = 0; i < STAGE; i++) {
            for (int j = 0; j < STAGE; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    // Sort in increasing order
    public static double[] bubbleSort(double num1, double num2, double num3) {
        double[] result = new double[STAGE];
        result[0] = num1;
        result[1] = num2;
        result[2] = num3;
        for (int i = 0; i < STAGE - 1; i++) {
            for (int j = 0; j < STAGE - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    double temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    public static double[][] sortColumns(double[][] matrix) {
        double[][] sortedMatrix = new double[STAGE][STAGE];

        for (int i = 0; i < STAGE; i++) {
            double[] tempColumn = bubbleSort(matrix[0][i], matrix[1][i], matrix[2][i]);
            for (int j = 0; j < STAGE; j++) {
                sortedMatrix[j][i] = tempColumn[j];
            }
        }

        return sortedMatrix;
    }

    public static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < STAGE; i++) {
            for (int j = 0; j < STAGE; j++) {
                System.out.printf("%f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] matrix;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a 3−by−3 matrix row by row:");
        matrix = initMatrix(input);
        input.close();

        System.out.println("The column−sorted array is");
        displayMatrix(sortColumns(matrix));

    }
}
