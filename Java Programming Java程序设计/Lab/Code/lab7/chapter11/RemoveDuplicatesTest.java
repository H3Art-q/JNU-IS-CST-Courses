package lab7.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicatesTest {
    private final static int LIMIT = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.print("Enter 10 integers: ");

        for (int i = 0; i < LIMIT; i++) {
            arrayList.add(input.nextInt());
        }

        input.close();

        RemoveDuplicates.removeDuplicate(arrayList);

        System.out.print("The distinct integers are ");

        for (int result : arrayList) {
            System.out.print(result + " ");
        }
    }
}
