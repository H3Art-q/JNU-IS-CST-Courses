package lab2.chapter4;
// 4.17

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class DaysOfMonth {

    final static HashMap<Integer, Integer> dayOfMonth = new HashMap<>(12);

    private static void initMap() {
        dayOfMonth.put(0, 31);
        dayOfMonth.put(1, 28);
        dayOfMonth.put(2, 31);
        dayOfMonth.put(3, 30);
        dayOfMonth.put(4, 31);
        dayOfMonth.put(5, 30);
        dayOfMonth.put(6, 31);
        dayOfMonth.put(7, 31);
        dayOfMonth.put(8, 30);
        dayOfMonth.put(9, 31);
        dayOfMonth.put(10, 30);
        dayOfMonth.put(11, 31);
    }

    final static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private static int match(String mon) {
        for (int i = 0; i < months.length; i++) {
            if (Objects.equals(months[i], mon)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isLeapYear(int year) {
        /*
        Either is the multiple of 400
        or is the multiple of 4 but not the multiple of 100
         */
        if (year % 400 == 0) {
            return true;
        } else return year % 100 != 0 && year % 4 == 0;
    }

    private static int calculator(int year, int mon) {
        if (mon == 1) {
            if (isLeapYear(year)) {
                return dayOfMonth.get(mon) + 1;
            }
        }
        return dayOfMonth.get(mon);
    }

    public static void main(String[] args) {
        int year;
        String month;
        initMap();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        year = input.nextInt();
        System.out.print("Enter a month: ");
        month = input.next();

        int matchNum = match(month);
        if (matchNum == -1) {
            System.out.println(month + " is not a correct month name");
        } else {
            System.out.println(month + ' ' + year + " has " + calculator(year, matchNum) + " days");
        }

        input.close();
    }
}
