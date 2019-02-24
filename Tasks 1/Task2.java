package EPAM_HW_1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double dinosaurMassKg, dinosaurMassMg, dinosaurMassG, dinosaurMassTon;
        boolean massIsNegative;

        do {
            massIsNegative = false;
            System.out.print("Enter dinosaur weight(in kilograms): ");
            dinosaurMassKg = input.nextDouble();

            if (dinosaurMassKg < 0) {
                massIsNegative = true;
                System.out.println("Incorrect dinosaur weight");
            }
        }while (massIsNegative);

        dinosaurMassG = dinosaurMassKg * 1000;
        dinosaurMassMg = dinosaurMassG * 1000;
        dinosaurMassTon = dinosaurMassKg / 1000;

        System.out.println("Dinosaur weight:\n" +
                            dinosaurMassG + " g.;\n" +
                            dinosaurMassMg + " mg.;\n" +
                            dinosaurMassTon + "t.;");

    }
}
