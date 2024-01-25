package lab2.chapter4;
// 4.11

import java.util.Scanner;

public class DeximalToHex {
    final static String hexValue = "0123456789ABCDEF";

    public static void main(String[] args) {
        int number;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal value (0 to 15): ");

        number = input.nextInt();

        if (number >= 0 && number <= 15) {
            System.out.println("The hex value is " + hexValue.charAt(number));
            // System.out.printf("The hex value is %X\n", number);
        } else {
            System.out.println(number + " is an invalid input");
        }

        input.close();
    }
}
