package lab2.chapter3;
// 3.31

import java.util.Scanner;

public class CurrencyExchange {
    private static double CtoU(double rate, double amount) {
        return amount / rate;
    }

    private static double UtoC(double rate, double amount) {
        return amount * rate;
    }

    public static void main(String[] args) {
        double exchangeRate, amount;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the exchange rate from dollars to RMB: ");
        exchangeRate = input.nextDouble();

        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");

        switch (input.nextInt()) {
            case 0:
                System.out.print("Enter the dollar amount: ");
                amount = input.nextDouble();
                System.out.printf("$%f is %f yuan\n", amount, UtoC(exchangeRate, amount));
                break;
            case 1:
                System.out.print("Enter the RMB amount: ");
                amount = input.nextDouble();
                System.out.printf("%f yuan is $%f\n", amount, CtoU(exchangeRate, amount));
                break;
            default:
                System.out.println("CIncorrect input");
        }
    }
}
