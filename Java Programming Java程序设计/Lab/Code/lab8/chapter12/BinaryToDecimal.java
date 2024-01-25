package lab8.chapter12;
// 12.7

import java.util.Scanner;

public class BinaryToDecimal {
    public static int bin2Dec(String binaryString) throws NumberFormatException {
        // cool package method
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a binary number: ");
            int decimal = bin2Dec(input.nextLine());
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException e) {
            System.out.println("Not a binary number");
        }
    }
}