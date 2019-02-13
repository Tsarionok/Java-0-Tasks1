package EPAM_HW_1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, reverseNum;
        char[] arrayOfNums;
        boolean isSevenDigitNumber;

        do {
            isSevenDigitNumber = false;
            System.out.print("Enter 7-digit integer number: ");

            while (!input.hasNextInt()){
                System.out.print("This is not an integer number!\nEnter 7-digit integer number: ");
                input.next();
            }
            num = input.nextInt();

            if (num < 1000000 || num > 9999999) {
                System.out.println("This is not a 7-digit number!");
                isSevenDigitNumber = true;
            }
        } while (isSevenDigitNumber);

        Integer Num = new Integer(num);

        arrayOfNums = Num.toString().toCharArray();
        String reverseStrOfNums = "";

        for (int i = arrayOfNums.length-1; i>=0; i--) {
            reverseStrOfNums += arrayOfNums[i];
        }

        reverseNum = Integer.parseInt(reverseStrOfNums);
        System.out.println("Reverse number: " + reverseNum);
    }
}
