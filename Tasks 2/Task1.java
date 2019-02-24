package epamhw2;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        final int amountOfFlips = 1000;
        flipCoin(amountOfFlips);
    }

    private static void flipCoin(final int amountOfFlips){
        Random random = new Random();
        int amountOfTails = 0, amountOfHeads = 0;

        boolean isTailSide;
        for (int i = 0; i < amountOfFlips; i++) {
            isTailSide = random.nextBoolean();
            if (isTailSide){
                amountOfTails++;
            }
            else {
                amountOfHeads++;
            }
        }
        System.out.println("Count of Tails: " + amountOfTails + "\nCount of heads: " + amountOfHeads);
    }
}
