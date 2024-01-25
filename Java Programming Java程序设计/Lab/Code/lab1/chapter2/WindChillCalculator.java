package lab1.chapter2;

import java.util.Scanner;

public class WindChillCalculator {
    public static double calculator(double ta, double v) {
        return 35.74 + 0.6215 * ta - 35.75 * Math.pow(v, 0.16) + 0.4275 * ta * Math.pow(v, 0.16);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        double outsideTemperature = scanner.nextDouble();
        if (outsideTemperature < -58.0 || outsideTemperature > 41.0) {
            throw new RuntimeException("Temperature is out of range");
        }

        System.out.print("Enter the wind speed (≥ 2) in miles per hour: ");
        double windSpeed = scanner.nextDouble();
        if (windSpeed < 2.0) {
            throw new RuntimeException("Wind speed is out of range");
        }

        System.out.printf("The wind chill index is %.5f.", calculator(outsideTemperature, windSpeed));
    }
}
