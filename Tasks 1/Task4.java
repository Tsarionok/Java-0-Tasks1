package EPAM_HW_1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num;
        boolean isFourDigitNumber, isIncreasing = true;

        do {
            isFourDigitNumber = false;
            System.out.print("Enter 4-digit integer number: ");

            while (!input.hasNextInt()){
                System.out.print("This is not an integer number!\nEnter 4-digit integer number: ");
                input.next();
            }
            num = input.nextInt();

            if (num < 1000 || num > 9999) {
                System.out.println("This is not a 4-digit number!");
                isFourDigitNumber = true;
            }
        } while (isFourDigitNumber);

        int roundingNumber, cloneOfNumber = num;

        do {
            roundingNumber = cloneOfNumber % 10;
            if ((cloneOfNumber % 100 - roundingNumber)/10 < roundingNumber){
                cloneOfNumber = (cloneOfNumber - roundingNumber) / 10;
            }
            else{
                isIncreasing = false;
            }

        } while (isIncreasing && cloneOfNumber > 10);

        if (isIncreasing) {
            System.out.println("Components of the " + num + " increase monotonically.");
        } else {
            System.out.println("Components of the " + num + " do not increase monotonically.");
        }
    }
}
