package epamhw2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int firstNum, secondNum;
        boolean isInputIncorrect = true;
        do {
            firstNum = enterWithCheck();
            secondNum = enterWithCheck();
            if (firstNum < secondNum) {
                isInputIncorrect = false;
            } else {
                System.out.println("Try again(a < b)");
            }
        } while (isInputIncorrect);

        System.out.println("All pairs of friendly numbers in the range from " + firstNum + " to " + secondNum + ":");
        for (int i = firstNum; i <= secondNum; i++) {
            if (i == findSumOfDivisors(findSumOfDivisors(i)) && i < findSumOfDivisors(i)) {
                System.out.println(i + " and " + findSumOfDivisors(i));
            }
        }
    }

    private static int enterWithCheck () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a natural number: ");
        while (!input.hasNextInt()) {
            System.out.print("This is not a natural number!\nEnter a natural number: ");
            input.next();
        }
        return input.nextInt();
    }

    private static int findSumOfDivisors(int num){
        int sum = 1;
        for (int i = 2; i <= num / 2; i++){
            if (num % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
