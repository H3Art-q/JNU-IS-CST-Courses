package lab7.chapter11;
// 11.17

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectSquare {
    /*
    Store all smallest factors of m into an array list.
    n is the product of the factors that appear an odd number of times
    in the array list.
     */
    private static final ArrayList<Integer> primeRecord = new ArrayList<>();
    private static final ArrayList<Integer> exponentRecord = new ArrayList<>();

    private static void findPrimeFactor(int num) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                int expo = 0;
                while (num % i == 0) {
                    num /= i;
                    expo++;
                }
                primeRecord.add(i);
                exponentRecord.add(expo);
            }
        }
    }

    private static int findFactorN() {
        int limit = primeRecord.size(), result = 1;

        for (int i = 0; i < limit; i++) {
            if (exponentRecord.get(i) % 2 != 0) {
                result *= primeRecord.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int m, n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer m: ");
        m = input.nextInt();
        input.close();

        findPrimeFactor(m);
        n = findFactorN();

        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + m * n);
    }
}
