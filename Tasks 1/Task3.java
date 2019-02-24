package EPAM_HW_1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double R1, R2, square;
        boolean isNegative;

        do {
            System.out.print("Enter radius R1 and R2(R1 > R2):\n" + "R1 = ");

            while (!input.hasNextDouble()) {
                System.out.print("That(R1) not a number!\nRepeat input: R1 = ");
                input.next();
            }

            R1 = input.nextDouble();
            System.out.print("R2 = ");

            while (!input.hasNextDouble()) {
                System.out.print("That(R2) not a number!\nRepeat input: R2 = ");
                input.next();
            }

            R2 = input.nextDouble();
            isNegative = false;

            if (R1 < R2 || R1 < 0 || R2 < 0) {
                isNegative = true;
                System.out.println("Expected R1 > R2 or some radius values are negative!");
            }

        } while (isNegative);

        square = Math.PI * (R1 - R2) * (R1 - R2);

        System.out.println("Square of ring = " + square);
    }
}
