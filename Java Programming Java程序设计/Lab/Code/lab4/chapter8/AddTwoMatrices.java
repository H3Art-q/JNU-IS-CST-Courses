package lab4.chapter8;
// 8.5

import java.util.Scanner;

public class AddTwoMatrices {
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

    public static double[][] addMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[STAGE][STAGE];

        for (int i = 0; i < STAGE; i++) {
            for (int j = 0; j < STAGE; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void printProcess(double[][] addMatrix1, double[][] addMatrix2, double[][] result) {
        System.out.printf("%f %f %f     %f %f %f     %f %f %f\n",
                addMatrix1[0][0], addMatrix1[0][1], addMatrix1[0][2],
                addMatrix2[0][0], addMatrix2[0][1], addMatrix2[0][2],
                result[0][0], result[0][1], result[0][2]
        );
        System.out.printf("%f %f %f  +  %f %f %f  =  %f %f %f\n",
                addMatrix1[1][0], addMatrix1[1][1], addMatrix1[1][2],
                addMatrix2[1][0], addMatrix2[1][1], addMatrix2[1][2],
                result[1][0], result[1][1], result[1][2]
        );
        System.out.printf("%f %f %f     %f %f %f     %f %f %f\n",
                addMatrix1[2][0], addMatrix1[2][1], addMatrix1[2][2],
                addMatrix2[2][0], addMatrix2[2][1], addMatrix2[2][2],
                result[2][0], result[2][1], result[2][2]
        );
    }

    public static void main(String[] args) {
        double[][] matrix1, matrix2;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter two 3 * 3 matrices(real numbers seperated by SPACE)");

        System.out.print("Enter matrix1: ");
        matrix1 = initMatrix(input);
        System.out.print("Enter matrix2: ");
        matrix2 = initMatrix(input);

        // if I close the Scanner(System.in) in a function,
        // it will close System.in as well
        // when I want to use it again, the System.in has already
        // been closed, therefore I cannot get any data from System.in
        // finally if I use Scanner.nextXXX(), then I will receive a
        // IOException
        input.close();

        System.out.println("The matrices are added as follows");
        printProcess(matrix1, matrix2, addMatrix(matrix1, matrix2));
    }
}
