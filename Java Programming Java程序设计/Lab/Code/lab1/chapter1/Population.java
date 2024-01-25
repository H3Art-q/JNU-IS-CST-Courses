package lab1.chapter1;

public class Population {
    private static final double timeofYear = 365 * 24 * 60 * 60;
    private static final double birthTime = 7.0;
    private static final double deathTime = 13.0;
    private static final double immigTime = 45.0;

    public static void main(String[] args) {
        double finalPopulation = 312_032_486;

        for (int i = 0; i < 5; i++) {
            double increaseNum = timeofYear / birthTime + timeofYear / immigTime;
            double decreaseNum = timeofYear / deathTime;
            finalPopulation += increaseNum - decreaseNum;

            System.out.println("After " + (i + 1) + " year, the total population is:");
            System.out.printf("%d\n", (int)finalPopulation);
        }
    }
}
