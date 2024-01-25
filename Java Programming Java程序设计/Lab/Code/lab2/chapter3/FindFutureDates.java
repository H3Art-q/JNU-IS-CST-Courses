package lab2.chapter3;
// 3.5

import java.util.Scanner;

public class FindFutureDates {
    final static String[] dateOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private static int calculator(int today, int gap) {
        return (today + gap) % 7;
    }

    private static String result(int today, int future) {
        return "Today is " +
                dateOfWeek[today] +
                " and the future day is " +
                dateOfWeek[future];
    }

    public static void main(String[] args) {
        int today, timeGap;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter today's day: ");
        today = input.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        timeGap = input.nextInt();

        System.out.println(result(today, calculator(today, timeGap)));
    }
}
