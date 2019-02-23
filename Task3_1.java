package EPAM_HW_1;

import java.util.Scanner;

public class Task3_1 {
    public static void main(String[] args) {

        double R1, R2, square;
        boolean isNegative;

        do {
            System.out.print("Enter radius R1 and R2(R1 > R2):\n" + "R1 = ");
            R1 = enterWithCheck();

            System.out.print("R2 = ");
            R2 = enterWithCheck();

            isNegative = false;
            if (R1 < R2 || R1 < 0 || R2 < 0) {
                isNegative = true;
                System.out.println("Expected R1 > R2 or some radius values are negative!");
            }
        } while (isNegative);

        square = Math.PI * (R1 * R1 - R2 * R2);

        System.out.println("Square of ring = " + square);
    }

    private static double enterWithCheck(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextDouble()){
            System.out.print("This is not a fractional number!\nEnter fractional number: ");
            input.next();
        }
        return input.nextDouble();
    }
}
