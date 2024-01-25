package lab6.chapter10;

import java.util.Scanner;

public class MyIntegerTest {
    public static boolean isPrime(int num) {
        if (num < 0 || (num % 2 == 0 && num != 2)) {
            return false;
        }
        for (int i = 3; i <= (int) Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean objectTest(int testNum) {
        MyInteger myInteger = new MyInteger(testNum);
        System.out.println("Create a MyInteger object with value " + myInteger.getValue());

        if (myInteger.isEven() && MyInteger.isEven(myInteger) && myInteger.getValue() % 2 == 0) {
            System.out.println(myInteger.getValue() + " is an even number");
        } else if (myInteger.isOdd() && MyInteger.isOdd(myInteger) && myInteger.getValue() % 2 == 1) {
            System.out.println(myInteger.getValue() + " is an odd number");
        } else {
            return false;
        }

        if (myInteger.isPrime() == MyInteger.isPrime(myInteger) &&
                myInteger.isPrime() == isPrime(myInteger.getValue())) {
            if (isPrime(myInteger.getValue())) {
                System.out.println(myInteger.getValue() + " is an prime number");
            } else {
                System.out.println(myInteger.getValue() + " isn't an prime number");
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean parseTest(int testNum) {
        // String parsing
        System.out.println("Parse a String: " + testNum);
        String testString = String.valueOf(testNum);

        if (MyInteger.parseInt(testString) == testNum) {
            System.out.println("Parse " + testNum + " successful");
        } else {
            System.out.println("Parse " + testNum + " failed");
            return false;
        }

        // char array parsing
        System.out.println("Parse a char array: " + testNum);
        char[] testCharArray = testString.toCharArray();
        if (MyInteger.parseInt(testCharArray) == testNum) {
            System.out.println("Parse " + testNum + " successful");
        } else {
            System.out.println("Parse " + testNum + " failed");
            return false;
        }

        return true;
    }

    public static boolean intTest(int testNum) {
        System.out.println("Create a int number with value " + testNum);

        if (MyInteger.isEven(testNum) && testNum % 2 == 0) {
            System.out.println(testNum + " is an even number");
        } else if (MyInteger.isOdd(testNum) && testNum % 2 == 1) {
            System.out.println(testNum + " is an odd number");
        } else {
            return false;
        }

        if (MyInteger.isPrime(testNum) == isPrime(testNum)) {
            if (isPrime(testNum)) {
                System.out.println(testNum + " is an prime number");
            } else {
                System.out.println(testNum + " isn't an prime number");
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int testNumber = input.nextInt();

        if (objectTest(testNumber)) {
            System.out.println("\nObject test: Success\n");
        } else {
            throw new RuntimeException("Object test: Fail");
        }

        if (intTest(testNumber)) {
            System.out.println("\nint test: Success\n");
        } else {
            throw new RuntimeException("int test: Fail");
        }

        if (parseTest(testNumber)) {
            System.out.println("\nParse test: Success\n");
        } else {
            throw new RuntimeException("Parse test: Fail");
        }
    }
}
