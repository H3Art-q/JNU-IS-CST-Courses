package lab7.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayListTest {
    private final static int LIMIT = 5;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Please enter 5 numbers(integer):");

        for (int i = 0; i < LIMIT; i++){
            arrayList.add(input.nextInt());
        }

        input.close();

        System.out.println("You have already enter 5 numbers. They are:");

        System.out.println(arrayList);

        SortArrayList.sort(arrayList);

        System.out.println("Sort these numbers in increasing order, the result is:");

        System.out.println(arrayList);
    }
}
