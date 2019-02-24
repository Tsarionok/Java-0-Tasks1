package EPAM_HW_1;

import java.util.Scanner;

public class Task5_1 {
    public static void main(String[] args) {

        final int MIN_NUM = 100_000, MAX_NUM = 999_999;
        int num;
        double sumOfNumber = 0, compositionOfNumber = 1;
        boolean isSuperImpose = true, isNotSixDigitNumber;

        do {
            isNotSixDigitNumber = false;
            System.out.print("Enter 6-digit integer number: ");

            num = enterWithCheck();

            if (num < MIN_NUM || num > MAX_NUM) {
                System.out.println("This is not a 6-digit number!");
                isNotSixDigitNumber = true;
            }
        } while (isNotSixDigitNumber);

        int cloneNumber = num;
        do {
            sumOfNumber += (cloneNumber % 10);
            compositionOfNumber *= (cloneNumber % 10);

            if (cloneNumber > 10) {
                cloneNumber = (cloneNumber - cloneNumber % 10) / 10;
            }
            else {
                isSuperImpose = false;
            }

        } while (isSuperImpose);

        System.out.println("Arithmetic mean of number: " + sumOfNumber / 6);
        System.out.println("Geometric mean of number: " + Math.pow(compositionOfNumber, 1./6));
    }
    private static int enterWithCheck(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()){
            System.out.print("This is not an integer number!\nEnter 6-digit integer number: ");
            input.next();
        }
        return input.nextInt();
    }
}