package EPAM_HW_1;

import java.util.Scanner;

public class Task1_1 {
    public static void main(String[] args) {
        int a, b, c;

        System.out.print("Enter 3 numbers:\n" + "a = ");
        a = enterWithCheck();
        System.out.print("b = ");
        b = enterWithCheck();
        System.out.print("c = ");
        c = enterWithCheck();

        if(a == b && a == c) {
            System.out.println("All numbers are the same!");
        }
        else if(a == b || a == c || b == c) {
            System.out.println("Among the numbers are the same!");
        }
        else {
            System.out.println("All numbers are different!");
        }
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
