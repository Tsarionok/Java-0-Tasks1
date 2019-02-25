package epamhw2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int num, firstNum, secondNum;
        do {
            num = enterWithCheck();
        } while (num < 1);

        System.out.println("1) The highest number of " + num + " is " + findTheHighestNumber(num));
        System.out.println("2) This number is " + (determineSymmetry(num) ? "a palindrome!" : "not a palindrome!"));
        System.out.println("3) Thus number is " + (determinePrime(num) ? "prime!" : "compound!"));
        System.out.print("4) Prime divisors of number are: ");
        findAllPrimeDivisors(num);

        do {
            System.out.println("Enter a: ");
            firstNum = enterWithCheck();
        } while (firstNum < 1);
        do {
            System.out.println("Enter b: ");
            secondNum = enterWithCheck();
        } while (secondNum < 1);

        System.out.print("5/a) Least common multiple of " + firstNum + " and " + secondNum + " is ");
        System.out.println(findLeastCommonMultiple(firstNum, secondNum));
        System.out.print("5/b) Greatest common divisor of " + firstNum + " and " + secondNum + " is ");
        System.out.println(findGreatestCommonDivisor(firstNum, secondNum));
        System.out.println("6) Amount of unique common digits of " + num + " is " + findCommonDigits(num));
    }

    private static int enterWithCheck(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a natural number: ");
        while (!input.hasNextInt()){
            System.out.print("This is not a natural number!\nEnter a natural number: ");
            input.next();
        }
        return input.nextInt();
    }

    private static int findTheHighestNumber (int num){
        int highestNumber = 0;

        do {
            if (num % 10 > highestNumber){
                highestNumber = num % 10;
            }
            num = (num - num % 10) / 10;
        } while (num > 0);

        return highestNumber;
    }

    private static boolean determineSymmetry (int num){
        int changedNum = 0, copyOfNum = num;

        while (num > 0) {
            changedNum = changedNum * 10 + num % 10;
            num = (num - num % 10) / 10;
        }
        if (copyOfNum == changedNum){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean determinePrime (int num){
        boolean isNotDivided = true;
        int i = 2, sqrtOfNum = (int)Math.sqrt(num);
        while (isNotDivided && i < sqrtOfNum + 1) {
            if (num % i == 0){
                isNotDivided = false;
            }
            else{
                i++;
            }
        }
        if (isNotDivided) {
            return true;
        }
        else{
            return false;
        }
    }

    private static void findAllPrimeDivisors (int num) {
        for (int i = 2; i < num / 2 + 1; i++){
            if ((num % i == 0) && (determinePrime(i))) {
                System.out.print(i + " ");
            }
        }
    }

    private static int findLeastCommonMultiple (int firstNum, int secondNum){
        int commonMultiple = (firstNum < secondNum ? firstNum : secondNum);
        while (!(commonMultiple % firstNum == 0 && commonMultiple % secondNum == 0)) {
            commonMultiple++;
        }
        return commonMultiple;
    }

    private static int findGreatestCommonDivisor (int firstNum, int secondNum){
        while (firstNum != 0 && secondNum != 0) {
            if (firstNum > secondNum) {
                firstNum %= secondNum;
            }
            else {
                secondNum %= firstNum;
            }
        }
        return firstNum + secondNum;
    }

    private static int findCommonDigits (int num){
        int countOfUniqueDigits = 0;
        for (int i = 0; i < 10; i++){
            boolean isEndOfNum = true;
            int cloneOfNum = num;
            while ((cloneOfNum > 0) && isEndOfNum) {
                if ((cloneOfNum % 10) == i) {
                    countOfUniqueDigits++;
                    isEndOfNum = false;
                }
                cloneOfNum /= 10;
            }
        }
        return countOfUniqueDigits;
    }
}
