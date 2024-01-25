package lab2.chapter4;
// 4.9

import java.util.Scanner;

public class FindUnicode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String charStore;

        System.out.print("Enter a character: ");

        charStore = input.next();

        if (charStore.length() != 1) {
            throw new RuntimeException("Only allow 1 character!");
        }

        System.out.println("The Unicode for the character " + charStore.charAt(0)
                + " is " + charStore.codePointAt(0));

        input.close();
    }
}
