package EPAM_HW_1;

import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) {

        double dinosaurMassKg, dinosaurMassMg, dinosaurMassG, dinosaurMassTon;
        boolean massIsNegative;

        do {
            massIsNegative = false;
            System.out.print("Enter dinosaur weight(in kilograms): ");
            dinosaurMassKg = enterWithCheck();

            if (dinosaurMassKg < 0) {
                massIsNegative = true;
                System.out.println("Incorrect dinosaur weight");
            }
        }while (massIsNegative);

        dinosaurMassG = dinosaurMassKg * 1000;          // Если в дальнейшем понадобится какое-либо из значений,
        dinosaurMassMg = dinosaurMassG * 1000;          // то не лишним было бы создание отдельной переменной
        dinosaurMassTon = dinosaurMassKg / 1000;        //

        System.out.println("Dinosaur weight:\n" +
                            dinosaurMassG + " g.;\n" +
                            dinosaurMassMg + " mg.;\n" +
                            dinosaurMassTon + "t.;");
    }

    private static double enterWithCheck(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextDouble()){
            System.out.print("This is not a fractional number!\nEnter fractional number: ");
            input.next();
        }
        return input.nextDouble();
    }
}
