package epamhw2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int num = enterWithCheck(), sumOfDivisors = 0;
        for (int i = 1; i < num / 2 + 1; i++){
            if (num % i == 0){
                sumOfDivisors += i;
            }
        }
        System.out.println("Number is " + (sumOfDivisors == num ? "perfect" : "not perfect"));
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
}
