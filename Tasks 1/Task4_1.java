package EPAM_HW_1;

import java.util.Scanner;

public class Task4_1 {
    public static void main(String[] args) {

        final int MIN_NUM = 1000, MAX_NUM = 9999;
        int num;
        boolean isNotFourDigitNumber;

        do {
            System.out.print("Enter 4-digit integer number: ");

            num = enterWithCheck();

            if (num < MIN_NUM || num > MAX_NUM) {
                System.out.println("This is not a 4-digit number!");
                isNotFourDigitNumber = true;
            }
            else {
                isNotFourDigitNumber = false;
            }
        } while (isNotFourDigitNumber);

        if (checkForIncreasing(num)) {
            System.out.println("Components of the " + num + " increase monotonically.");
        }
        else {
            System.out.println("Components of the " + num + " do not increase monotonically.");
        }
    }

    private static int enterWithCheck(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()){
            System.out.print("This is not an integer number!\nEnter 4-digit integer number: ");
            input.next();
        }
        return input.nextInt();
    }

    private static boolean checkForIncreasing(int num){
        boolean isIncreasing = true;
        int roundingNumber;

        do {
            roundingNumber = num % 10;
            if ((num % 100 - roundingNumber)/10 < roundingNumber){
                num = (num - roundingNumber) / 10;
            }
            else{
                isIncreasing = false;
            }
        } while (isIncreasing && num > 10);

        return isIncreasing;
    }
}
