package lab1.chapter2;

import java.util.Scanner;

public class FinancialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subtotal = scanner.nextDouble();
        double gratuityRate = scanner.nextDouble();

        double gratuity = subtotal * gratuityRate * 0.01;
        double total = subtotal + gratuity;

        System.out.printf("The gratuity is $%g and total is $%g.\n", gratuity, total);

    }
}
