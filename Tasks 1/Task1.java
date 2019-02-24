package EPAM_HW_1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a, b, c;

        System.out.print("Enter 3 numbers:\n" + "a = ");
        a = input.nextInt();
        System.out.print("b = ");
        b = input.nextInt();
        System.out.print("c = ");
        c = input.nextInt();

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
}
