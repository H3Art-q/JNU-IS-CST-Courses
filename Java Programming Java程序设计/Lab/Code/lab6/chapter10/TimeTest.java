package lab6.chapter10;

public class TimeTest {
    public static void main(String[] args) {
        Time test1 = new Time();
        System.out.println("Create the first Time object with no-arg constructor");
        test1.displayTime();

        Time test2 = new Time(555550000);
        System.out.println("Create the second Time object with specified elapsed time constructor");
        test2.displayTime();

        Time test3 = new Time(5, 23, 55);
        System.out.println("Create the third Time object with  specified hour, minute, and second constructor");
        test3.displayTime();

        System.out.println("If we set the third time use System.currentTimeMillis(), it will display:");
        test3.setTime(System.currentTimeMillis());
        test3.displayTime();
    }
}
