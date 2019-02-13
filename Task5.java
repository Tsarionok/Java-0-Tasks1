package EPAM_HW_1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num;
        double sumOfNumber = 0, compositionOfNumber = 1;
        boolean isSuperImpose = true, isSixDigitNumber;

        do {
            isSixDigitNumber = false;
            System.out.print("Enter 6-digit integer number: ");

            while (!input.hasNextInt()){
                System.out.print("This is not an integer number!\nEnter 6-digit integer number: ");
                input.next();
            }
            num = input.nextInt();

            if (num < 100000 || num > 999999) {
                System.out.println("This is not a 6-digit number!");
                isSixDigitNumber = true;
            }
        } while (isSixDigitNumber);

        int cloneNumber = num;
        do {
            sumOfNumber += (cloneNumber % 10);
            compositionOfNumber *= (cloneNumber % 10);

            if (cloneNumber > 10) {
                cloneNumber = (cloneNumber - cloneNumber % 10) / 10;
            } else {
                isSuperImpose = false;
            }

        } while (isSuperImpose);

        System.out.println("Arithmetic mean of number: " + sumOfNumber / 6);
        System.out.println("Geometric mean of number: " + Math.pow(compositionOfNumber, 1./6));
    }
}