package lab3.chapter6;
// 6.5

import java.util.Scanner;

public class SortThreeNumbers {
    final static int LEN = 3;

    public static void displaySortedNumbers(double num1, double num2, double num3){
        if(num1 > num2){
            if(num1 > num3){
                if(num2 > num3){
                    System.out.println(num3 + " " + num2 + " " + num1);
                }else{
                    System.out.println(num2 + " " + num3 + " " + num1);
                }
            }else{
                System.out.println(num2 + " " + num1 + " " + num3);
            }
        }else{
            if(num2 > num3){
                if(num1 > num3){
                    System.out.println(num3 + " " + num1 + " " + num2);
                }else{
                    System.out.println(num1 + " " + num3 + " " + num2);
                }
            }else{
                System.out.println(num1 + " " + num2 + " " + num3);
            }
        }
    }

    public static void main(String[] args) {
        double[] numbers = new double[LEN];

        Scanner input = new Scanner(System.in);

        for(int i = 0; i < LEN; i++){
            numbers[i] = input.nextDouble();
        }

        displaySortedNumbers(numbers[0], numbers[1], numbers[2]);
    }
}
