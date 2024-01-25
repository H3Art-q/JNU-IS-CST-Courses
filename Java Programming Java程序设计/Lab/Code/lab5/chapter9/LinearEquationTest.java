package lab5.chapter9;

import java.util.Scanner;

public class LinearEquationTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c, d, e, f;

        System.out.println("Suppose we have a 2 * 2 system of linear equations: ");
        System.out.println("\tax + by = e\n" + "\tcx + dy = f");
        System.out.println("This program will help you judge whether it can be solve,");
        System.out.println("if can, it will output the corresponding x and y");

        System.out.print("Enter the factors(Order: a, b, c, d, e, f): ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        d = input.nextDouble();
        e = input.nextDouble();
        f = input.nextDouble();

        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);

        if(!linearEquation.isSolvable()){
            System.out.println("The equation has no solution.");
        }else{
            System.out.println("The solution x is " + linearEquation.getX());
            System.out.println("The solution y is " + linearEquation.getY());
        }
    }
}
