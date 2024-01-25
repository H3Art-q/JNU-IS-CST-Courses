package lab6.chapter10;
// 10.7

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMMachine {
    private int ACCOUNTS_NUM;
    private List<Account> accountList;

    ATMMachine(int accountsNumber) {
        ACCOUNTS_NUM = accountsNumber;
        accountList = new ArrayList<>();
        for (int i = 0; i < ACCOUNTS_NUM; i++) {
            accountList.add(new Account(i, 100));
        }
    }

    public Account userIDMatch(int ID) {
        for (Account account : accountList) {
            if (ID == account.getId()) {
                return account;
            }
        }
        System.out.println("Wrong ID, try again");
        return null;
    }

    public boolean mainMenu(Account account, Scanner input) {
        switch (input.nextInt()) {
            case 1:
                System.out.println("The balance is " + account.getBalance());
                break;
            case 2:
                System.out.print("Enter an amount to withdraw: ");
                if (!account.withdraw(input.nextDouble())) {
                    System.out.println("Insufficient balance, withdrawal failed");
                }
                break;
            case 3:
                System.out.print("Enter an amount to deposit: ");
                account.deposit(input.nextDouble());
                break;
            case 4:
                System.out.println();
                return false;
            default:
                System.out.println("Wrong choice, try again");
        }
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        ATMMachine machine = new ATMMachine(10);
        Scanner input = new Scanner(System.in);
        Account user;

        while (true) {
            do {
                System.out.print("Enter an ID: ");
                user = machine.userIDMatch(input.nextInt());
            } while (user == null);

            do {
                System.out.print("Main menu\n" +
                        "1: check balance\n" +
                        "2: withdraw\n" +
                        "3: deposit\n" +
                        "4: exit\n" +
                        "Enter a choice: ");
            } while (machine.mainMenu(user, input));

            user = null;
        }
    }
}
