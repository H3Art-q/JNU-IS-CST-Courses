package lab8.chapter12;
// 12.3

import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {

    private final static int MAXLEN = 100;
    private static final int[] array = new int[MAXLEN];

    private static void randomIntGenerator() {
        for (int i = 0; i < MAXLEN; i++) {
            array[i] = (int) (100000 * Math.random());
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            randomIntGenerator();
            System.out.println("Here we have an array with 100 random integers stored inside");
            System.out.print("Please enter the index of the array: ");
            int index = input.nextInt();
            System.out.println("The element in index " + index + " is " + array[index]);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
    }
}
