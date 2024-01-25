package lab3.chapter5;
// 5.29

import java.util.Scanner;

public class DisplayCalendar {
    final static String[] Months = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else return (year % 4 == 0) && (year % 100 != 0);
    }

    private static int getDaysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
        }
        return daysInMonth;
    }

    private static void printCalendar(int year, int firstDay) {
        int dayOfWeek = firstDay;

        for (int month = 1; month <= 12; month++) {
            System.out.printf("%28s\n", Months[month - 1] + ' ' + year);
            System.out.println("---------------------------------------------");
            System.out.println("Sun    Mon    Tue    Wed    Thu    Fri    Sat");

            if (dayOfWeek != 7) {
                for (int gap = dayOfWeek; gap > 0; gap--) {
                    System.out.print("       ");
                }
                System.out.print(" ");
            } else {
                dayOfWeek = 0;
            }

            int dayLimit = getDaysInMonth(year, month);
            for (int day = 1; day <= dayLimit; day++, dayOfWeek++) {
                if (dayOfWeek == 7) {
                    dayOfWeek = 0;
                    System.out.print("\n");
                }

                if (dayOfWeek == 0) {
                    System.out.print(" ");
                }
                System.out.printf("%-7d", day);
            }

            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
        int year, firstDay;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the year: ");
        year = input.nextInt();
        System.out.print("Enter the first day of the year(day in week, 0 - 6): ");
        firstDay = input.nextInt();
        input.close();

        printCalendar(year, firstDay);
    }
}
