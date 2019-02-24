package EPAM_HW_1;

import java.util.Scanner;

public class Task6_1 {
    public static void main(String[] args) {
        final int MIN_NUM = 1_000_000, MAX_NUM = 9_999_999;
        int num, changedNum;
        boolean isNotSevenDigitNumber;

        do {
            System.out.print("Enter 7-digit integer number: ");

            num = enterWithCheck();

            if (num < MIN_NUM || num > MAX_NUM) {
                System.out.println("This is not a 7-digit number!");
                isNotSevenDigitNumber = true;
            }
            else {
                isNotSevenDigitNumber = false;
            }
        } while (isNotSevenDigitNumber);

        changedNum = reverseNum(num);
        System.out.println("Reversed number is " + changedNum);
    }
    private static int enterWithCheck(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()){
            System.out.print("This is not an integer number!\nEnter 7-digit integer number: ");
            input.next();
        }
        return input.nextInt();
    }
    private static int reverseNum(int someNum){
        int changedNum = 0;

        while (someNum > 0) {
            changedNum = changedNum * 10 + someNum % 10;
            someNum = (someNum - someNum % 10) / 10;
        }

        return changedNum;
    }
}