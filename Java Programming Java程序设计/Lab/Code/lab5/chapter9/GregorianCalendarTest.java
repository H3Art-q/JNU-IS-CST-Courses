package lab5.chapter9;
// 9.5

import java.util.GregorianCalendar;

public class GregorianCalendarTest {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();

        System.out.println("Current year is " + calendar.get(GregorianCalendar.YEAR));
        // The first month of the year in the Gregorian and Julian calendars is JANUARY which is 0
        System.out.println("Current month is " + calendar.get(GregorianCalendar.MONTH));
        System.out.println("(The first month of the year in the Gregorian and Julian calendars is JANUARY which is 0)");
        System.out.println("Current day is " + calendar.get(GregorianCalendar.DAY_OF_MONTH));

        // Method setTimeInMillis(long) can be used to set a specified elapsed time since January 1, 1970
        calendar.setTimeInMillis(1234567898765L);
        System.out.println("If we use setTimeInMillis(long), and pass a value 1234567898765L to it");

        System.out.println("The corresponding year is " + calendar.get(GregorianCalendar.YEAR));
        System.out.println("The corresponding month is " + calendar.get(GregorianCalendar.MONTH));
        System.out.println("The corresponding day is " + calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
