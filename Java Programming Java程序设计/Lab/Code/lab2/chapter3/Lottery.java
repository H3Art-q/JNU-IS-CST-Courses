package lab2.chapter3;
// 3.15

import java.util.Scanner;

public class Lottery {
    private static void bubbleSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static int randomInteger() {
        return (int) (Math.random() * 1000);
    }

    private static int[] partNumber(int num) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = num % 10;
            num /= 10;
        }
        return result;
    }

    private static boolean singleMatch(int lottNum, int userNum) {
        int[] lott = partNumber(lottNum);
        int[] user = partNumber(userNum);
        for (int num1 : lott) {
            for (int num2 : user) {
                if (num2 == num1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean multiMatch(int lottNum, int userNum) {
        int[] lott = partNumber(lottNum);
        int[] user = partNumber(userNum);
        int len = lott.length;
        bubbleSort(lott, len);
        bubbleSort(user, len);
        for (int i = 0; i < len; i++) {
            if (lott[i] != user[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean completeMatch(int lottNum, int userNum) {
        return lottNum == userNum;
    }

    private static void awardJudge(int lottNum, int userNum) {
        if (singleMatch(lottNum, userNum)) {
            if (multiMatch(lottNum, userNum)) {
                if (completeMatch(lottNum, userNum)) {
                    System.out.println("Your input matches the lottery number in the exact order,");
                    System.out.println("The award is $10,000!");
                } else {
                    System.out.println("All digits in your input match all digits in the lottery number,");
                    System.out.println("The award is $3,000!");
                }
            } else {
                System.out.println("One digit in your input matches a digit in the lottery number");
                System.out.println("the award is $1,000!");
            }
        } else {
            System.out.println("Your input didn't match any digit. What a shame!");
        }
    }

    public static void main(String[] args) {
        int lotteryNumber = randomInteger();
        int userNumber;

        Scanner input = new Scanner(System.in);

        System.out.println("The program generated a lottery number.");
        System.out.println("If your guess match this number, you will get a big award!");
        System.out.print("Now you should enter a three-digit integer: ");

        userNumber = input.nextInt();
        if (userNumber > 999 || userNumber < 100) {
            throw new RuntimeException("Only allow a three-digit integer!");
        }

        awardJudge(lotteryNumber, userNumber);
    }
}
