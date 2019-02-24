package EPAM_HW_1;

import java.util.Scanner;

public class Task7_1 {
    public static void main(String[] args) {

        System.out.print("Enter a: ");
        int a = enterWithCheck();
        System.out.print("Enter b: ");
        int b = enterWithCheck();

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static int enterWithCheck(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()){
            System.out.print("This is not an integer number!\nEnter integer number: ");
            input.next();
        }
        return input.nextInt();
    }
}
