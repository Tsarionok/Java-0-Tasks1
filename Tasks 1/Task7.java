package EPAM_HW_1;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = input.nextInt();
        System.out.print("Enter b: ");
        int b = input.nextInt();

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
